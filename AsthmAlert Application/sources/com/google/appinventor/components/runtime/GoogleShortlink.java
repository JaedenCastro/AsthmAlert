package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.microsoft.appcenter.ingestion.models.CommonProperties;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

@DesignerComponent(category = ComponentCategory.INTERNAL, description = "A component to create Short links with the Google API", iconName = "images/google.png", nonVisible = true, version = 1)
@UsesLibraries({"httpcore.jar", "httpmime.jar"})
@SimpleObject
@UsesPermissions({"android.permission.INTERNET"})
public final class GoogleShortlink extends AndroidNonvisibleComponent {
    private String AGGRF5jTQInc5pUFaFXws4RnGLG0yIcZMIkVuaCJtvs6ytQWDb3uUe5MrjxIRxbt = null;
    private String KmWMzrb8pAMl652ZF8qeuTq7pG7ZDLw36UnzkrmNxV5DvooPwgtf6GDSAEiAO9jG = null;
    private final Context context;
    private ConnectivityManager hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private NetworkInfo f154hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private final String xaqHe1zmXpFIxCQ2Rqyod5yEaSTeb7CYPqkTrZecvYFjGogfgX23htIKbmu7xARG = "https://www.googleapis.com/urlshortener/v1/url";

    @SimpleProperty(description = "Don't use this default api key for your final app's. This default api key is only for development mode. Sponsored by NMD (Next Mobile Development).")
    public final String DefaultApiKey() {
        return "";
    }

    public GoogleShortlink(ComponentContainer componentContainer) {
        super(componentContainer.$form());
        Activity $context = componentContainer.$context();
        this.context = $context;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = (ConnectivityManager) $context.getSystemService("connectivity");
        Log.d("GoogleShortlink", "GoogleShortlink Created");
    }

    @SimpleFunction(description = "Convert a link into a short link. Powerd by Google.")
    public final void UrlToShort(String str) {
        NetworkInfo activeNetworkInfo = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getActiveNetworkInfo();
        this.f154hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = activeNetworkInfo;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            GotResponse(false, "There was a error. Please try again..");
            return;
        }
        new b(this, (byte) 0).execute(new String[]{str});
    }

    @SimpleFunction(description = "Convert a short link from google into a normal link. Powerd by Google.")
    public final void ShortToUrl(String str) {
        this.AGGRF5jTQInc5pUFaFXws4RnGLG0yIcZMIkVuaCJtvs6ytQWDb3uUe5MrjxIRxbt = str;
        NetworkInfo activeNetworkInfo = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getActiveNetworkInfo();
        this.f154hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = activeNetworkInfo;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            GotResponse(false, "There was a error. Please try again..");
            return;
        }
        new a(this, (byte) 0).execute(new String[]{str});
    }

    @DesignerProperty(defaultValue = "", editorType = "string")
    @SimpleProperty(description = "Set here your api key to use the service. How to get a api key? Read here more: \"https://goo.gl/AFks2R\"")
    public final void ApiKey(String str) {
        this.KmWMzrb8pAMl652ZF8qeuTq7pG7ZDLw36UnzkrmNxV5DvooPwgtf6GDSAEiAO9jG = str;
    }

    @SimpleEvent(description = "Event to detect when a link was converted.")
    public final void GotResponse(boolean z, String str) {
        EventDispatcher.dispatchEvent(this, "GotResponse", Boolean.valueOf(z), str);
    }

    class b extends AsyncTask<String, Void, String> {
        private String Zv9msgDgBftU4SA7C2ygCk7MYKz0i3cazgjcHvHHF7brwk6qR9wS1wUER4Y8ppMY;
        private final String fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8;

        private b() {
            this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = "https://www.googleapis.com/urlshortener/v1/url?key=" + GoogleShortlink.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME((GoogleShortlink) GoogleShortlink.this);
            this.Zv9msgDgBftU4SA7C2ygCk7MYKz0i3cazgjcHvHHF7brwk6qR9wS1wUER4Y8ppMY = null;
        }

        /* synthetic */ b(GoogleShortlink googleShortlink, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    final String string = jSONObject.getString(CommonProperties.ID);
                    if (jSONObject.has(CommonProperties.ID)) {
                        ((Activity) GoogleShortlink.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(GoogleShortlink.this)).runOnUiThread(new Runnable() {
                            public final void run() {
                                GoogleShortlink.this.GotResponse(true, string);
                            }
                        });
                    }
                } catch (JSONException e) {
                    Log.d("JSONException", e.getMessage());
                    GoogleShortlink.this.GotResponse(false, "There was a error. Please try again..");
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME */
        public String doInBackground(String... strArr) {
            this.Zv9msgDgBftU4SA7C2ygCk7MYKz0i3cazgjcHvHHF7brwk6qR9wS1wUER4Y8ppMY = strArr[0];
            try {
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 5000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                HttpPost httpPost = new HttpPost(this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8);
                httpPost.setHeader("Content-type", "application/json");
                httpPost.setHeader("Accept", "application/json");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("longUrl", this.Zv9msgDgBftU4SA7C2ygCk7MYKz0i3cazgjcHvHHF7brwk6qR9wS1wUER4Y8ppMY);
                httpPost.setEntity(new StringEntity(jSONObject.toString(), "UTF-8"));
                HttpResponse execute = defaultHttpClient.execute(httpPost);
                if (execute.getStatusLine().getStatusCode() != 200) {
                    return null;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                execute.getEntity().writeTo(byteArrayOutputStream);
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            } catch (Exception e) {
                Log.d("Exception", e.getMessage());
                GoogleShortlink.this.GotResponse(false, "There was a error. Please try again..");
                return null;
            }
        }
    }

    class a extends AsyncTask<String, Void, String> {
        private URL url;

        private a() {
            this.url = null;
        }

        /* synthetic */ a(GoogleShortlink googleShortlink, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (str != null) {
                try {
                    GoogleShortlink.this.GotResponse(true, str);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                    GoogleShortlink.this.GotResponse(false, "There was a error. Please try again..");
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME */
        public String doInBackground(String... strArr) {
            try {
                this.url = new URL(strArr[0]);
            } catch (MalformedURLException e) {
                Log.d("MalformedURLException", e.getMessage());
            }
            return GoogleShortlink.getFinalURL(this.url).toString();
        }
    }

    public static URL getFinalURL(URL url) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 303 || responseCode == 301 || responseCode == 302) {
                String headerField = httpURLConnection.getHeaderField("Location");
                if (headerField.startsWith("/")) {
                    headerField = url.getProtocol() + "://" + url.getHost() + headerField;
                }
                return getFinalURL(new URL(headerField));
            }
        } catch (Exception e) {
            Log.d("Exception", e.getMessage());
        }
        return url;
    }
}
