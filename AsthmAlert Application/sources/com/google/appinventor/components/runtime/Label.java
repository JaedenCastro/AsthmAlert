package com.google.appinventor.components.runtime;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesLibraries;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.KodularHelper;
import com.google.appinventor.components.runtime.util.ProgressHelper;
import com.google.appinventor.components.runtime.util.TextViewUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;

@SimpleObject
@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "A Label displays a piece of text, which is specified through the <code>Text</code> property.  Other properties, all of which can be set in the Designer or Blocks Editor, control the appearance and placement of the text.", version = 10)
@UsesLibraries({"spinkit.jar"})
public final class Label extends AndroidViewComponent {
    private boolean PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC;
    private int backgroundColor;
    private boolean clickable = false;
    private boolean cxDeivMnEpGbjLe4A1R1VhwwbdnX12vGTzD2ggofq0XWzd0wEZ70Vx6p1IyPlwn3;
    private int fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = 0;
    private int fontTypeface;
    private final LinearLayout.LayoutParams hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

    /* renamed from: hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME  reason: collision with other field name */
    private final TextView f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private int mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT;
    private boolean nn72cmMvpJDARAoxBpvS24CN9Of9fpinGcvMsNPLOdwkLzCSrjpb4bynF9b6riOG = false;
    private double rotationAngle = 0.0d;
    private boolean tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE;
    private int textColor;
    private boolean yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT;

    public Label(ComponentContainer componentContainer) {
        super(componentContainer);
        TextView textView = new TextView(componentContainer.$context());
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = textView;
        componentContainer.$add(this);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = (LinearLayout.LayoutParams) layoutParams;
            this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = ViewUtil.calculatePixels(textView, 2);
        } else {
            this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 = 0;
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = null;
            Log.e("Label", "Error: The label's view does not have linear layout parameters");
            new RuntimeException().printStackTrace();
        }
        TextAlignment(0);
        BackgroundColor(16777215);
        TextViewUtil.setContext(componentContainer.$context());
        TextViewUtil.setFontTypeface(textView, 0, this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT, this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
        FontSize(14.0f);
        Text("");
        TextColor(-16777216);
        HTMLFormat(false);
        HasMargins(true);
        Clickable(false);
        RotationAngle(0.0d);
    }

    public final View getView() {
        return this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    @SimpleEvent(description = "Event to detect that a user has done a simple \"Click\".")
    public final void Click() {
        EventDispatcher.dispatchEvent(this, "Click", new Object[0]);
    }

    @SimpleEvent(description = "Event to detect that a user has done a simple \"Long Click\".")
    public final void LongClick() {
        EventDispatcher.dispatchEvent(this, "LongClick", new Object[0]);
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "Set the component clickable or not clickable.")
    public final void Clickable(boolean z) {
        this.clickable = z;
        if (z) {
            this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setClickable(true);
            if (Build.VERSION.SDK_INT >= 23) {
                TextView textView = this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
                TypedArray obtainStyledAttributes = this.container.$context().obtainStyledAttributes(new int[]{16843534});
                Drawable drawable = obtainStyledAttributes.getDrawable(0);
                obtainStyledAttributes.recycle();
                textView.setForeground(drawable);
            }
            this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    Label.this.Click();
                }
            });
            this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOnLongClickListener(new View.OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    Label.this.LongClick();
                    return true;
                }
            });
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setForeground((Drawable) null);
        }
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOnClickListener((View.OnClickListener) null);
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setOnLongClickListener((View.OnLongClickListener) null);
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setClickable(false);
    }

    @SimpleProperty
    public final boolean Clickable() {
        return this.clickable;
    }

    @DesignerProperty(defaultValue = "0.0", editorType = "float", propertyType = "advanced")
    @SimpleProperty
    public final void RotationAngle(double d) {
        this.rotationAngle = d;
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setRotation((float) d);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Sets the degrees that the label is rotated around the pivot point. Increasing values result in clockwise rotation.")
    public final double RotationAngle() {
        return this.rotationAngle;
    }

    @SimpleFunction(description = "Place a blurred shadow of text underneath the text, drawn with the specified x, y, radius, color (e.g. -11, 12, 13, black ")
    public final void SetShadow(float f, float f2, float f3, int i) {
        KodularHelper.setShadow(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, f, f2, f3, i);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final int TextAlignment() {
        return this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT;
    }

    @DesignerProperty(defaultValue = "0", editorType = "textalignment")
    @SimpleProperty(userVisible = false)
    public final void TextAlignment(int i) {
        this.mBLKdPlRolYfdtud5Z8giGWyhURWoCw9yHsOv08fUnIBAM4MuKAWkHVD8nEhBmIT = i;
        TextViewUtil.setAlignment(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, i, false);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public final int BackgroundColor() {
        return this.backgroundColor;
    }

    @DesignerProperty(defaultValue = "&H00FFFFFF", editorType = "color")
    @SimpleProperty
    public final void BackgroundColor(int i) {
        this.backgroundColor = i;
        if (i != 0) {
            TextViewUtil.setBackgroundColor(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, i);
        } else {
            TextViewUtil.setBackgroundColor(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, 16777215);
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final boolean FontBold() {
        return this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public final void FontBold(boolean z) {
        this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT = z;
        TextViewUtil.setFontTypeface(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.fontTypeface, z, this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final boolean FontItalic() {
        return this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public final void FontItalic(boolean z) {
        this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC = z;
        TextViewUtil.setFontTypeface(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.fontTypeface, this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT, z);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Reports whether or not the label appears with margins.  All four margins (left, right, top, bottom) are the same.  This property has no effect in the designer, where labels are always shown with margins.")
    public final boolean HasMargins() {
        return this.cxDeivMnEpGbjLe4A1R1VhwwbdnX12vGTzD2ggofq0XWzd0wEZ70Vx6p1IyPlwn3;
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean", propertyType = "advanced")
    @SimpleProperty
    public final void HasMargins(boolean z) {
        this.cxDeivMnEpGbjLe4A1R1VhwwbdnX12vGTzD2ggofq0XWzd0wEZ70Vx6p1IyPlwn3 = z;
        int i = z ? this.fSI6lxX8qEfUYa0M3qSNEhqEY7tqyd89UewYfJ8WSYLJpTsAFdRvTVg7ORBsMzG8 : 0;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setMargins(i, i, i, i);
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.invalidate();
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public final float FontSize() {
        return TextViewUtil.getFontSize(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.container.$context());
    }

    @DesignerProperty(defaultValue = "14.0", editorType = "non_negative_float")
    @SimpleProperty
    public final void FontSize(float f) {
        TextViewUtil.setFontSize(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, f);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final int FontTypeface() {
        return this.fontTypeface;
    }

    @DesignerProperty(defaultValue = "0", editorType = "typeface")
    @SimpleProperty(userVisible = false)
    public final void FontTypeface(int i) {
        this.fontTypeface = i;
        TextViewUtil.setFontTypeface(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, i, this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT, this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public final String Text() {
        return TextViewUtil.getText(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME);
    }

    @DesignerProperty(editorType = "textArea")
    @SimpleProperty
    public final void Text(String str) {
        if (this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE) {
            TextViewUtil.setTextHTML(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, str);
        } else {
            TextViewUtil.setText(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, str);
        }
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "If true, then this label will show html text else it will show plain text. Note: Not all HTML is supported.")
    public final boolean HTMLFormat() {
        return this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean", propertyType = "advanced")
    @SimpleProperty(userVisible = false)
    public final void HTMLFormat(boolean z) {
        this.tee1T53LBirhPaiZzuBv7do2U2eC3n16AtczACNW2pKYEGgDhkkMv1hGUupyoKZE = z;
        Text(Text());
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE)
    public final int TextColor() {
        return this.textColor;
    }

    @DesignerProperty(defaultValue = "&HFF000000", editorType = "color")
    @SimpleProperty
    public final void TextColor(int i) {
        this.textColor = i;
        if (i != 0) {
            TextViewUtil.setTextColor(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, i);
        } else {
            TextViewUtil.setTextColor(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, -16777216);
        }
    }

    @DesignerProperty(editorType = "font_asset", propertyType = "advanced")
    @SimpleProperty(description = "Set a custom font.")
    public final void FontTypefaceImport(String str) {
        if (str != null) {
            TextViewUtil.setCustomFontTypeface(this.container.$form(), this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, str, this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT, this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
        }
    }

    @DesignerProperty(defaultValue = "false", editorType = "boolean", propertyType = "advanced")
    @SimpleProperty
    public final void Marquee(boolean z) {
        this.nn72cmMvpJDARAoxBpvS24CN9Of9fpinGcvMsNPLOdwkLzCSrjpb4bynF9b6riOG = z;
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setEllipsize(z ? TextUtils.TruncateAt.MARQUEE : null);
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSelected(z);
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setSingleLine(z);
    }

    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public final boolean Marquee() {
        return this.nn72cmMvpJDARAoxBpvS24CN9Of9fpinGcvMsNPLOdwkLzCSrjpb4bynF9b6riOG;
    }

    @SimpleFunction(description = "Allows you to set animation style. Valid (case-insensitive) values are: ChasingDots, Circle, CubeGrid, DoubleBounce, FadingCircle, FoldingCube, Pulse, RotatingCircle, RotatingPlane, ThreeBounce, WanderingCubes, Wave. If invalid style is used, animation will be removed.Position can be: top, left, right, bottom. Size can be 100. ")
    public final void AnimationStyle(String str, String str2, int i, int i2) {
        ProgressHelper.setButtonProgressAnimation(this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, str, str2, i, i2);
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setVisibility(8);
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setVisibility(0);
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.invalidate();
    }

    @DesignerProperty(defaultValue = "2147483647", editorType = "non_negative_integer", propertyType = "advanced")
    @SimpleProperty
    public final void MaxLines(int i) {
        this.f188hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setMaxLines(i);
    }
}
