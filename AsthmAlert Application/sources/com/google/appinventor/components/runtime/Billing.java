package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesApplicationMetadata;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.annotations.androidmanifest.MetaDataElement;
import com.google.appinventor.components.common.ComponentCategory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@DesignerComponent(category = ComponentCategory.MONETIZATION_GENERAL, description = "Google Play In-App Billing component", helpUrl = "https://docs.kodular.io/components/monetization/in-app-billing/", iconName = "images/billing.png", nonVisible = true, version = 2)
@UsesLibraries({"play-billing.aar", "play-billing.jar"})
@SimpleObject
@UsesApplicationMetadata(metaDataElements = {@MetaDataElement(name = "com.google.android.play.billingclient.version", value = "5.2.1")})
@UsesPermissions({"com.android.vending.BILLING", "android.permission.INTERNET"})
public class Billing extends AndroidNonvisibleComponent implements BillingClientStateListener, PurchasesUpdatedListener, OnDestroyListener {
    private static final String LOG_TAG = "KodularBilling";
    private static final String TEST_PRODUCT_ID = "android.test.purchased";
    /* access modifiers changed from: private */
    public Activity activity;
    /* access modifiers changed from: private */
    public BillingClient billingClient;
    private Context context;
    private boolean testMode = false;

    @Deprecated
    @SimpleFunction(description = "Do not use this block anymore. This block is deprecated and does nothing and will be removed in the future!")
    public void Initialize(String str, String str2) {
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Is one time purchase supported.")
    public boolean IsOneTimePurchaseSupported() {
        return true;
    }

    @Deprecated
    @SimpleFunction(description = "Returns true if the product with the specific id is purchased.")
    public boolean IsPurchased(String str) {
        return false;
    }

    @Deprecated
    @SimpleFunction(description = "Returns true if the product is subscribed.")
    public boolean IsSubscribed(String str) {
        return false;
    }

    @Deprecated
    @SimpleFunction(description = "Subscribe a product with the given product id.")
    public void Subscribe(String str) {
    }

    @Deprecated
    @SimpleFunction(description = "Get subscription details from the given id.")
    public void SubscriptionDetails(String str) {
    }

    @DesignerProperty(defaultValue = "true", editorType = "boolean")
    @Deprecated
    @SimpleProperty
    public void SuppressToast(boolean z) {
    }

    @Deprecated
    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Do not use this block anymore. This block is deprecated and does nothing and will be removed in the future!", userVisible = false)
    public boolean SuppressToast() {
        return true;
    }

    @Deprecated
    @SimpleFunction(description = "Do not use this block anymore. This block is deprecated and does nothing and will be removed in the future!")
    public void UpdateSubscription(String str) {
    }

    public void onBillingServiceDisconnected() {
    }

    public void onBillingSetupFinished(BillingResult billingResult) {
    }

    public Billing(Form form) {
        super(form);
        this.context = form.$context();
        this.activity = form.$context();
        form.registerForOnDestroy(this);
        BillingClient build = BillingClient.newBuilder(this.context).setListener(this).enablePendingPurchases().build();
        this.billingClient = build;
        build.startConnection(this);
        Log.d(LOG_TAG, "Billing Created");
    }

    @SimpleFunction(description = "Load Owned Purchases from Google.")
    public void LoadOwnedPurchases() {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        QueryPurchaseHistoryParams queryPurchaseHistoryParams = getQueryPurchaseHistoryParams("inapp");
        final QueryPurchaseHistoryParams queryPurchaseHistoryParams2 = getQueryPurchaseHistoryParams("subs");
        this.billingClient.queryPurchaseHistoryAsync(queryPurchaseHistoryParams, new PurchaseHistoryResponseListener() {
            public final void onPurchaseHistoryResponse(BillingResult billingResult, List<PurchaseHistoryRecord> list) {
                if (Billing.this.isSuccessful(billingResult) && Billing.isListNonNullAndNotEmpty(list)) {
                    for (PurchaseHistoryRecord products : list) {
                        arrayList.add(products.getProducts().get(0));
                    }
                }
                Billing.this.billingClient.queryPurchaseHistoryAsync(queryPurchaseHistoryParams2, new PurchaseHistoryResponseListener() {
                    public final void onPurchaseHistoryResponse(BillingResult billingResult, List<PurchaseHistoryRecord> list) {
                        if (Billing.this.isSuccessful(billingResult) && Billing.isListNonNullAndNotEmpty(list)) {
                            for (PurchaseHistoryRecord products : list) {
                                arrayList2.add(products.getProducts().get(0));
                            }
                        }
                        Billing.this.GotOwnedPurchases(arrayList, arrayList2);
                    }
                });
            }
        });
        Log.d(LOG_TAG, "Load Owned Purchases called");
    }

    @SimpleFunction(description = "Purchase a product with the given product id.")
    public void Purchase(String str, String str2) {
        Log.d(LOG_TAG, "Purchase: ".concat(String.valueOf(str)));
        if (this.testMode) {
            str = TEST_PRODUCT_ID;
        }
        this.billingClient.queryProductDetailsAsync(getQueryProductDetailsParams(str, str2), new ProductDetailsResponseListener() {
            public final void onProductDetailsResponse(BillingResult billingResult, List<ProductDetails> list) {
                if (Billing.this.isSuccessful(billingResult) && Billing.isListNonNullAndNotEmpty(list)) {
                    Billing.this.startBillingFlow(list.get(0));
                }
            }
        });
    }

    @SimpleFunction(description = "Consumes a purchase to enable users to buy it again.")
    public void Consume(final String str) {
        Log.i(LOG_TAG, "Consuming purchase: ".concat(String.valueOf(str)));
        this.billingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), new PurchasesResponseListener() {
            public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
                boolean z;
                if (!Billing.this.isSuccessful(billingResult) || !Billing.isListNonNullAndNotEmpty(list)) {
                    Billing.this.Consumed(false, str);
                    return;
                }
                Iterator<Purchase> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Purchase next = it.next();
                    if (str.equals(next.getProducts().get(0)) && Billing.this.isPurchased(next)) {
                        Billing.this.billingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(next.getPurchaseToken()).build(), new ConsumeResponseListener() {
                            public final void onConsumeResponse(BillingResult billingResult, String str) {
                                boolean access$000 = Billing.this.isSuccessful(billingResult);
                                Log.i(Billing.LOG_TAG, "Consume response: BillingResult = ".concat(String.valueOf(access$000)));
                                Billing.this.Consumed(access$000, str);
                            }
                        });
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    Billing.this.Consumed(false, str);
                }
            }
        });
    }

    @SimpleFunction
    public void CheckPurchase(final String str, final String str2) {
        this.billingClient.queryPurchasesAsync(getQueryPurchasesParams(str2), new PurchasesResponseListener() {
            public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
                if (Billing.this.isSuccessful(billingResult) && Billing.isListNonNullAndNotEmpty(list)) {
                    for (Purchase products : list) {
                        if (str.equals(products.getProducts().get(0))) {
                            Billing.this.GotPurchaseResult(str, str2, true);
                            return;
                        }
                    }
                }
                Billing.this.GotPurchaseResult(str, str2, false);
            }
        });
    }

    @SimpleFunction(description = "Get product details from the specific product id. Product type can be either inapp or subs.")
    public void ProductDetails(String str, final String str2) {
        Log.d(LOG_TAG, "ProductDetails: " + str + ", " + str2);
        this.billingClient.queryProductDetailsAsync(getQueryProductDetailsParams(str, str2), new ProductDetailsResponseListener() {
            public final void onProductDetailsResponse(BillingResult billingResult, List<ProductDetails> list) {
                if (Billing.this.isSuccessful(billingResult) && Billing.isListNonNullAndNotEmpty(list)) {
                    ProductDetails productDetails = list.get(0);
                    if (str2.equals("inapp")) {
                        Billing.this.GotProductDetails(true, productDetails.getProductId(), productDetails.getTitle(), productDetails.getDescription(), productDetails.getOneTimePurchaseOfferDetails().getPriceCurrencyCode(), productDetails.getOneTimePurchaseOfferDetails().getFormattedPrice());
                    } else if (str2.equals("subs")) {
                        Billing.this.GotSubscriptionDetails(true, true, productDetails.getProductId(), productDetails.getTitle(), productDetails.getDescription(), productDetails.getOneTimePurchaseOfferDetails().getPriceCurrencyCode(), productDetails.getOneTimePurchaseOfferDetails().getFormattedPrice());
                    }
                } else if (str2.equals("inapp")) {
                    Billing.this.GotProductDetails(false, "", "", "", "", "");
                } else if (str2.equals("subs")) {
                    Billing.this.GotSubscriptionDetails(false, true, "", "", "", "", "");
                }
            }
        });
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether In-app billing service is ready to purchase.")
    public boolean ReadyToPurchase() {
        return this.billingClient.isReady();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Check Play Market services availability.")
    public boolean IsIabServiceAvailable() {
        return this.billingClient.isReady();
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Is subscriptions supported.")
    public boolean IsSubscriptionsSupported() {
        return isFeatureSupported("subscriptions");
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Is subscription update supported.")
    public boolean IsSubscriptionUpdateSupported() {
        return isFeatureSupported("subscriptionsUpdate");
    }

    @DesignerProperty(defaultValue = "false", editorType = "boolean")
    @SimpleProperty
    public void TestMode(boolean z) {
        this.testMode = z;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Whether it is testing mode enabled or not.")
    public boolean TestMode() {
        return this.testMode;
    }

    @SimpleEvent(description = "Error occurred event.")
    public void ErrorOccurred(final String str) {
        this.activity.runOnUiThread(new Runnable() {
            public final void run() {
                EventDispatcher.dispatchEvent(Billing.this, "ErrorOccurred", str);
            }
        });
    }

    @SimpleEvent(description = "After purchase event.")
    public void AfterPurchase(final String str) {
        this.activity.runOnUiThread(new Runnable() {
            public final void run() {
                EventDispatcher.dispatchEvent(Billing.this, "AfterPurchase", str);
            }
        });
    }

    @SimpleEvent(description = "When product is consumed.")
    public void Consumed(final boolean z, final String str) {
        this.activity.runOnUiThread(new Runnable() {
            public final void run() {
                EventDispatcher.dispatchEvent(Billing.this, "Consumed", Boolean.valueOf(z), str);
            }
        });
    }

    @SimpleEvent(description = "Got Product Details")
    public void GotProductDetails(boolean z, String str, String str2, String str3, String str4, String str5) {
        final boolean z2 = z;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        this.activity.runOnUiThread(new Runnable() {
            public final void run() {
                EventDispatcher.dispatchEvent(Billing.this, "GotProductDetails", Boolean.valueOf(z2), str6, str7, str8, str9, str10);
            }
        });
    }

    @SimpleEvent(description = "Got Subscription Details")
    public void GotSubscriptionDetails(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5) {
        final boolean z3 = z;
        final boolean z4 = z2;
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        this.activity.runOnUiThread(new Runnable() {
            public final void run() {
                EventDispatcher.dispatchEvent(Billing.this, "GotSubscriptionDetails", Boolean.valueOf(z3), Boolean.valueOf(z4), str6, str7, str8, str9, str10);
            }
        });
    }

    @SimpleEvent(description = "Got Owned Purchases")
    public void GotOwnedPurchases(final List<String> list, final List<String> list2) {
        this.activity.runOnUiThread(new Runnable() {
            public final void run() {
                EventDispatcher.dispatchEvent(Billing.this, "GotOwnedPurchases", list, list2);
            }
        });
    }

    @SimpleEvent(description = "Triggers with the result of IsPurchased")
    public void GotPurchaseResult(final String str, final String str2, final boolean z) {
        this.activity.runOnUiThread(new Runnable() {
            public final void run() {
                EventDispatcher.dispatchEvent(Billing.this, "IsPurchasedResult", str, str2, Boolean.valueOf(z));
            }
        });
    }

    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        if (isSuccessful(billingResult) && isListNonNullAndNotEmpty(list)) {
            for (Purchase handlePurchase : list) {
                handlePurchase(handlePurchase);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean isSuccessful(BillingResult billingResult) {
        return billingResult.getResponseCode() == 0;
    }

    private boolean isFeatureSupported(String str) {
        return isSuccessful(this.billingClient.isFeatureSupported(str));
    }

    /* access modifiers changed from: private */
    public boolean isPurchased(Purchase purchase) {
        return purchase.getPurchaseState() == 1;
    }

    /* access modifiers changed from: private */
    public static <T> boolean isListNonNullAndNotEmpty(List<T> list) {
        return list != null && list.size() > 0;
    }

    private QueryProductDetailsParams getQueryProductDetailsParams(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId(str).setProductType(str2).build());
        return QueryProductDetailsParams.newBuilder().setProductList(arrayList).build();
    }

    private QueryPurchasesParams getQueryPurchasesParams(String str) {
        return QueryPurchasesParams.newBuilder().setProductType(str).build();
    }

    private QueryPurchaseHistoryParams getQueryPurchaseHistoryParams(String str) {
        return QueryPurchaseHistoryParams.newBuilder().setProductType(str).build();
    }

    /* access modifiers changed from: private */
    public void startBillingFlow(ProductDetails productDetails) {
        BillingFlowParams.ProductDetailsParams build = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails).build();
        final BillingFlowParams build2 = BillingFlowParams.newBuilder().setProductDetailsParamsList(Arrays.asList(new BillingFlowParams.ProductDetailsParams[]{build})).build();
        this.activity.runOnUiThread(new Runnable() {
            public final void run() {
                Billing.this.billingClient.launchBillingFlow(Billing.this.activity, build2);
            }
        });
    }

    private void handlePurchase(final Purchase purchase) {
        if (isPurchased(purchase) && !purchase.isAcknowledged()) {
            this.billingClient.acknowledgePurchase(AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), new AcknowledgePurchaseResponseListener() {
                public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                    Log.i(Billing.LOG_TAG, "Acknowledge response: BillingResult = " + Billing.this.isSuccessful(billingResult));
                    Billing.this.AfterPurchase((String) purchase.getProducts().get(0));
                }
            });
        }
    }

    public void onDestroy() {
        this.billingClient.endConnection();
    }
}
