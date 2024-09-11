package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.errors.PermissionException;
import com.google.appinventor.components.runtime.util.QUtil;
import com.microsoft.appcenter.http.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

@DesignerComponent(category = ComponentCategory.MEDIA, description = "", iconName = "images/ocr.png", nonVisible = true, version = 5)
@SimpleObject
@UsesPermissions({"android.permission.INTERNET", "android.permission.READ_EXTERNAL_STORAGE"})
public class Ocr extends AndroidNonvisibleComponent implements Component {
    private String PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP = "http://2.bp.blogspot.com/-3C9EzBNi9rA/UiS93S6uqoI/AAAAAAAAEjM/fATWa50u0BY/w1200-h630-p-k-nu/Hello+world+android+app.jpg";
    private Context context;
    private Boolean hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO = Boolean.FALSE;
    private boolean havePermission = false;
    private String qPA23Y7cwrM2jVYdTZaCOyuoTEsak9zRoCsFocZMlDYlamZRzkT9xY09N4QNxUyM = "helloworld";
    private boolean repl = false;
    /* access modifiers changed from: private */
    public boolean rwH5QsW1tECSJqEYisIw7mgmF1LBaoVJw606thITSS1io7bESEMnIJXTcF47IT5D = false;
    /* access modifiers changed from: private */
    public String tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "eng";
    private Boolean vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq = Boolean.FALSE;
    private Boolean wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = Boolean.FALSE;
    private boolean xhzCIls1ZjY8rVr9uwfX6Ll4V1k7OjFmFraAgvYK73j7xL9tODrZc0oupoL3seO9 = false;

    public Ocr(ComponentContainer componentContainer) {
        super(componentContainer.$form());
        this.context = componentContainer.$context();
        Log.d("Ocr", "Ocr Created");
        if (this.form instanceof ReplForm) {
            this.repl = true;
        }
    }

    @SimpleFunction(description = "Get the text from a picture via the image url. Example: http://name/yourimage.jpg. Service powered by ocr.space.")
    public void GetTextFromImageUrl(String str) {
        if (str == null || str.isEmpty()) {
            str = this.PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP;
        }
        if (!str.endsWith(".png") || !str.endsWith(".PNG") || !str.endsWith(".jpg") || !str.endsWith(".JPG") || !str.endsWith(".gif") || !str.endsWith(".GIF") || !str.endsWith(".pdf") || !str.endsWith(".PDF")) {
            GotResponse(false, "The file must end with a valid extension like 'png'/'PNG', 'jpg'/'JPG', 'gif'/'GIF', or 'pdf'/'PDF'.");
            return;
        }
        new b(this, (byte) 0).execute(new String[]{"https://api.ocr.space/parse/imageurl?apikey=" + this.qPA23Y7cwrM2jVYdTZaCOyuoTEsak9zRoCsFocZMlDYlamZRzkT9xY09N4QNxUyM + "&url=" + str + "&isOverlayRequired=" + this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou + "&isCreateSearchablePdf=" + this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq + "&language=" + this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA});
    }

    class b extends AsyncTask<String, Void, String> {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return Ocr.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Ocr.this, ((String[]) objArr)[0]);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Ocr.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Ocr.this, (String) obj);
        }

        private b() {
        }

        /* synthetic */ b(Ocr ocr, byte b) {
            this();
        }
    }

    @SimpleFunction(description = "Upload your image to the server from ocr.space and then you get back the text from the picture.")
    public void UploadImage(final String str) {
        if (!this.havePermission) {
            this.form.runOnUiThread(new Runnable() {
                public final void run() {
                    Ocr.this.form.askPermission("android.permission.READ_EXTERNAL_STORAGE", new PermissionResultHandler() {
                        public final void HandlePermissionResponse(String str, boolean z) {
                            if (z) {
                                Ocr.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Ocr.this);
                                Ocr.this.UploadImage(str);
                                return;
                            }
                            Ocr.this.form.dispatchPermissionDeniedEvent((Component) Ocr.this, "UploadImage", "android.permission.READ_EXTERNAL_STORAGE");
                        }
                    });
                }
            });
            return;
        }
        c cVar = new c(this, (byte) 0);
        String[] strArr = new String[1];
        File externalStorageDir = QUtil.getExternalStorageDir(this.context);
        if (str.startsWith("file:///")) {
            str = str.substring(7);
        } else if (str.startsWith("file:///") || str.startsWith("/")) {
            if (!str.startsWith("/")) {
                str = externalStorageDir + File.separator + str;
            } else if (!str.startsWith(externalStorageDir.toString())) {
                str = externalStorageDir + str;
            }
        } else if (this.repl) {
            str = QUtil.getReplAssetPath(this.context) + str;
        } else {
            str = new File(this.context.getCacheDir() + "///" + str).getPath();
        }
        strArr[0] = str;
        cVar.execute(strArr);
    }

    class c extends AsyncTask<String, Void, String> {
        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Ocr.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Ocr.this, (String) obj);
        }

        private c() {
        }

        /* synthetic */ c(Ocr ocr, byte b) {
            this();
        }

        /* access modifiers changed from: private */
        /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME */
        public String doInBackground(String... strArr) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(new File(strArr[0]).getPath());
                if (decodeFile != null) {
                    decodeFile = Bitmap.createScaledBitmap(decodeFile, (decodeFile.getWidth() / 100) * 80, (decodeFile.getHeight() / 100) * 80, false);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (decodeFile != null) {
                    decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://api.ocr.space/parse/image").openConnection();
                httpsURLConnection.setRequestMethod(DefaultHttpClient.METHOD_POST);
                httpsURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                httpsURLConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apikey", Ocr.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Ocr.this));
                jSONObject.put("isOverlayRequired", Ocr.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Ocr.this));
                String encodeToString = Base64.encodeToString(byteArray, 0);
                jSONObject.put("base64image", "data:image/png;base64," + encodeToString.replace(" ", "").replace("\n", ""));
                jSONObject.put("language", Ocr.this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA);
                httpsURLConnection.setDoOutput(true);
                DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
                String B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T = Ocr.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(jSONObject);
                if (B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T != null) {
                    dataOutputStream.writeBytes(B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            bufferedReader.close();
                            String valueOf = String.valueOf(stringBuffer);
                            boolean unused = Ocr.this.rwH5QsW1tECSJqEYisIw7mgmF1LBaoVJw606thITSS1io7bESEMnIJXTcF47IT5D = true;
                            return valueOf;
                        }
                    }
                } else {
                    boolean unused2 = Ocr.this.rwH5QsW1tECSJqEYisIw7mgmF1LBaoVJw606thITSS1io7bESEMnIJXTcF47IT5D = false;
                    return "There was a problem to get a response from the ocr server.";
                }
            } catch (PermissionException e) {
                Log.e("Ocr", String.valueOf(e));
                String str = e.getMessage();
                boolean unused3 = Ocr.this.rwH5QsW1tECSJqEYisIw7mgmF1LBaoVJw606thITSS1io7bESEMnIJXTcF47IT5D = false;
                return str;
            } catch (Exception e2) {
                Log.e("Ocr", String.valueOf(e2));
                String str2 = e2.getMessage();
                boolean unused4 = Ocr.this.rwH5QsW1tECSJqEYisIw7mgmF1LBaoVJw606thITSS1io7bESEMnIJXTcF47IT5D = false;
                return str2;
            }
        }
    }

    @SimpleEvent(description = "You will find here the success state and the response content.")
    public void GotResponse(boolean z, String str) {
        EventDispatcher.dispatchEvent(this, "GotResponse", Boolean.valueOf(z), str);
    }

    @SimpleEvent(description = "You will find here the server status from the ocr provider. Possible results are 'UP' or 'DOWN'. 'pro Usa1' = Usa, East Coast. 'pro Usa2' = Usa, West Coast. ")
    public void GotServerStatus(String str, String str2, String str3, String str4, String str5) {
        EventDispatcher.dispatchEvent(this, "GotServerStatus", str, str2, str3, str4, str5);
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "Allows you to specify if the image/pdf text overlay is required. Overlay could be used to show the text over the image.")
    public void Overlayed(boolean z) {
        this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou = Boolean.valueOf(z);
    }

    @SimpleProperty(description = "Return the state of overlayed property.")
    public boolean Overlayed() {
        return this.wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou.booleanValue();
    }

    @DesignerProperty(defaultValue = "1", editorType = "ocr_language")
    @SimpleProperty(description = "Choose the language used for OCR. If no language is specified, English is taken as 'Default'.")
    public void Language(int i) {
        switch (i) {
            case 1:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "eng";
                return;
            case 2:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "ara";
                return;
            case 3:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "bul";
                return;
            case 4:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "chs";
                return;
            case 5:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "cht";
                return;
            case 6:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "hrv";
                return;
            case 7:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "cze";
                return;
            case 8:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "dan";
                return;
            case 9:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "dut";
                return;
            case 10:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "eng";
                return;
            case 11:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "fin";
                return;
            case 12:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "fre";
                return;
            case 13:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "ger";
                return;
            case 14:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "gre";
                return;
            case 15:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "hun";
                return;
            case 16:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "kor";
                return;
            case 17:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "ita";
                return;
            case 18:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "jpn";
                return;
            case 19:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "nor";
                return;
            case 20:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "pol";
                return;
            case 21:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "por";
                return;
            case 22:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "rus";
                return;
            case 23:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "slv";
                return;
            case 24:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "spa";
                return;
            case 25:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "swe";
                return;
            case 26:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "tur";
                return;
            default:
                this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA = "eng";
                return;
        }
    }

    @SimpleProperty(description = "Return the language code.")
    public String Language() {
        return this.tFNQ38WX0EWx1sBmwkfGOavwj0ohdRyv5RfL5KQ0qa5Pnr6qc7YsZTQu1aP3NtmA;
    }

    @DesignerProperty(defaultValue = "helloworld", editorType = "string")
    @SimpleProperty(description = "You can use the default api key: helloworld, or you can create your own api key at: https://ocr.space/ocrapi")
    public void ApiKey(String str) {
        this.qPA23Y7cwrM2jVYdTZaCOyuoTEsak9zRoCsFocZMlDYlamZRzkT9xY09N4QNxUyM = str;
    }

    @SimpleProperty(description = "Return the api key.")
    public String ApiKey() {
        return this.qPA23Y7cwrM2jVYdTZaCOyuoTEsak9zRoCsFocZMlDYlamZRzkT9xY09N4QNxUyM;
    }

    @SimpleProperty(description = "You can use the test image url if you have not any picture online on a server or else.")
    public String TestImageUrl() {
        return this.PMWpqVMsyfTUgqkfqh3FKX4Q3IYlcybzKrBGEl7qtzs6HNVssJ63V430Ige89pyP;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "A searchable PDF file is a PDF file that includes text that can be searched upon using the standard Adobe Reader “search” functionality. In addition, the text can be selected and copied from the PDF. In this case the JSON response of the API contains a download link for the the searchable PDF. This download link is valid for one hour, than all data is removed from the OCR servers.")
    public void CreateSearchablePdf(boolean z) {
        this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq = Boolean.valueOf(z);
    }

    @SimpleProperty(description = "Return the state of create searchable Pdf property.")
    public boolean CreateSearchablePdf() {
        return this.vSp02fkBXgM8EI0gm0rKWXHQ6wdQINJBQuAtCR15YU8g4XNqVKV8r32SYxkQYxkq.booleanValue();
    }

    @SimpleProperty(description = "Set this block before you upload a image and before you try to get the response from a image url. If this property is set to true, the response content returns only the created pdf download link.")
    public void ReturnOnlyPdfLink(boolean z) {
        this.hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO = Boolean.valueOf(z);
    }

    @SimpleProperty(description = "Set this block before you upload a image and before you try to get the response from a image url. If this property is set to true, the response content returns only the message. That means the response content will be only the scanned text in words.")
    public void ReturnOnlyMessage(boolean z) {
        this.xhzCIls1ZjY8rVr9uwfX6Ll4V1k7OjFmFraAgvYK73j7xL9tODrZc0oupoL3seO9 = z;
    }

    @SimpleFunction(description = "Get the server status from the free ocr.space server. This is helpful if you want to know if the server is online or offline. Returns true when online, else false when offline.")
    public void GetOcrServerStatus() throws Exception {
        new a(this, (byte) 0).execute(new String[]{"https://status.ocr.space"});
    }

    class a extends AsyncTask<String, String, String> {
        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return Ocr.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(Ocr.this, ((String[]) objArr)[0]);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            Ocr.this.GotServerStatus(Ocr.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T((String) obj, "Free OCR API <span class=\"status {{ data.status }}\"> "), Ocr.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T((String) obj, "PRO API (Endpoint #1, USA, East Coast)  <span class=\"status {{ data.status }}\"> "), Ocr.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T((String) obj, "PRO API (Endpoint #1, USA, West Coast)  <span class=\"status {{ data.status }}\"> "), Ocr.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T((String) obj, "PRO API (Endpoint #2, Europe)  <span class=\"status {{ data.status }}\"> "), Ocr.B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T((String) obj, "PRO API (Endpoint #3, Asia)   <span class=\"status {{ data.status }}\"> "));
        }

        private a() {
        }

        /* synthetic */ a(Ocr ocr, byte b) {
            this();
        }
    }

    private static String B8WBXPBCF2jGfUDZZU2zV5EYdqbUBu0lAZ0THCEqYyuE8VACR9dY7rDnwBIqh64T(String str, String str2) {
        try {
            String substring = str.substring(str.indexOf(str2) + str2.length(), str.length());
            return substring.substring(0, substring.indexOf(" </span>"));
        } catch (Exception e) {
            Log.e("Ocr", String.valueOf(e));
            return e.getMessage();
        }
    }

    private static String wq07duYRO6iFAgWM70EZOSvbCMKs1QznMRJKrct0XuHOBYqCk3XqOKtSBGIpDou(String str, String str2) {
        String str3;
        char c2 = 65535;
        try {
            int hashCode = str2.hashCode();
            if (hashCode != 1016488190) {
                if (hashCode == 1746365663) {
                    if (str2.equals("SearchablePDFURL")) {
                        c2 = 1;
                    }
                }
            } else if (str2.equals("ParsedText")) {
                c2 = 0;
            }
            if (c2 == 0) {
                str3 = new JSONObject(str).getJSONArray("ParsedResults").getJSONObject(0).getString("ParsedText");
            } else if (c2 != 1) {
                str3 = null;
            } else {
                str3 = new JSONObject(str).getString("SearchablePDFURL");
            }
            return str3 != null ? str3 : str;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private String hR11jdqaRrvBRiBFd4KN6gI7d8MNQVP5Yc7fufDZjGGTeTxaualejjrhiR1Iz2xO(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setRequestMethod(DefaultHttpClient.METHOD_GET);
            if (httpsURLConnection.getResponseCode() == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        bufferedReader.close();
                        this.rwH5QsW1tECSJqEYisIw7mgmF1LBaoVJw606thITSS1io7bESEMnIJXTcF47IT5D = true;
                        return sb.toString();
                    }
                }
            } else {
                this.rwH5QsW1tECSJqEYisIw7mgmF1LBaoVJw606thITSS1io7bESEMnIJXTcF47IT5D = false;
                return "There is no internet connection. Please try again.";
            }
        } catch (Exception e) {
            Log.e("Ocr", String.valueOf(e));
            this.rwH5QsW1tECSJqEYisIw7mgmF1LBaoVJw606thITSS1io7bESEMnIJXTcF47IT5D = false;
            return e.getMessage();
        }
    }

    /* access modifiers changed from: private */
    public static String hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME(JSONObject jSONObject) {
        try {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(next, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(obj.toString(), "UTF-8"));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
