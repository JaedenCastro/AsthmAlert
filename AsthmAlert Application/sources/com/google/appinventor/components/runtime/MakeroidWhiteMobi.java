package com.google.appinventor.components.runtime;

import android.content.Context;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.white.mobi.sdk.IRewardsListener;
import com.white.mobi.sdk.WMManager;

@DesignerComponent(category = ComponentCategory.INTERNAL, description = "WhiteMobi component", helpUrl = "https://docs.kodular.io/components/monetization/whitemobi/", iconName = "images/whitemobi.png", nonVisible = true, version = 1)
@UsesLibraries({"gson.jar", "whitemobisdk.jar"})
@SimpleObject
@UsesPermissions({"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
public class MakeroidWhiteMobi extends AndroidNonvisibleComponent implements OnPauseListener, OnResumeListener {
    private Context context;
    private String symWhrqAyHWXMObHLoQEIMlJvqdZFvcp7UyC2VmDxP3CgSs0pkdkxz6qiaDBzrEK = "";

    public MakeroidWhiteMobi(ComponentContainer componentContainer) {
        super(componentContainer.$form());
        this.context = componentContainer.$context();
        this.form.registerForOnPause(this);
        this.form.registerForOnResume(this);
        WMManager.setRewardListener(new IRewardsListener() {
            public final void onRewarded(int i) {
                MakeroidWhiteMobi.this.OfferCompleted(i);
            }
        });
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public void ApplicationKey(String str) {
        this.symWhrqAyHWXMObHLoQEIMlJvqdZFvcp7UyC2VmDxP3CgSs0pkdkxz6qiaDBzrEK = str;
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR, description = "Return the application key.")
    public String ApplicationKey() {
        return this.symWhrqAyHWXMObHLoQEIMlJvqdZFvcp7UyC2VmDxP3CgSs0pkdkxz6qiaDBzrEK;
    }

    @SimpleFunction(description = "Show WhiteMobi offerwall")
    public void ShowOfferWall() {
        WMManager.showOfferWall(this.symWhrqAyHWXMObHLoQEIMlJvqdZFvcp7UyC2VmDxP3CgSs0pkdkxz6qiaDBzrEK);
    }

    @SimpleEvent(description = "Event triggered when an offer has been completed")
    public void OfferCompleted(int i) {
        EventDispatcher.dispatchEvent(this, "OfferCompleted", Integer.valueOf(i));
    }

    public void onPause() {
        WMManager.onPause();
    }

    public void onResume() {
        WMManager.onResume(this.context);
    }
}
