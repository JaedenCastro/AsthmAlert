package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.util.KodularHelper;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.TextViewUtil;

@SimpleObject
@DesignerComponent(category = ComponentCategory.USERINTERFACE, description = "write in ode", helpUrl = "https://docs.kodular.io/components/user-interface/switch/", version = 4)
public final class SwitchToggle extends AndroidViewComponent implements CompoundButton.OnCheckedChangeListener {
    private boolean PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC = false;
    private int Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm = Component.COLOR_GREEN;
    private String UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5 = "Switch Off";
    private int ZBOPOXf20XZKrN6ycbQhEDPC2OsW2QCGfMHApJMYjAVGCpHVQNyA3eb1TXx8tY2I = Component.COLOR_TEAL;
    private String ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD = "Switch On";
    private Context context;
    private int fontTypeface = 0;
    private final Switch hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    private int textColor = Component.COLOR_GREEN;
    private boolean yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT = false;

    public SwitchToggle(ComponentContainer componentContainer) {
        super(componentContainer.$form());
        Activity $context = componentContainer.$context();
        this.context = $context;
        TextViewUtil.setContext($context);
        Switch switchR = new Switch(this.context);
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = switchR;
        switchR.setOnCheckedChangeListener(this);
        KodularHelper.setPadding(switchR, this.context, 4, 4, 4, 4);
        switchR.setSwitchPadding((int) ((this.context.getResources().getDisplayMetrics().density * 10.0f) + 0.5f));
        componentContainer.$add(this);
        ThumbColor(Component.COLOR_GREEN);
        TrackColor(Component.COLOR_TEAL);
        TextViewUtil.setFontTypeface(switchR, this.fontTypeface, this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT, this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
        TextSize(14.0f);
        TextColor(Component.COLOR_GREEN);
        TextOn("Switch On");
        TextOff("Switch Off");
        Checked(false);
        Log.d("Switch", "Switch Created");
    }

    public final Switch getView() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            Switch switchR = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            switchR.setText(TextViewUtil.fromHtml(this.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD + "  "));
        } else {
            Switch switchR2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            switchR2.setText(TextViewUtil.fromHtml(this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5 + "  "));
        }
        Clicked(z);
    }

    @SimpleEvent(description = "Event invoked when a switch has been clicked. Returns true or false if the switch is checked or not.")
    public final void Clicked(boolean z) {
        EventDispatcher.dispatchEvent(this, "Clicked", Boolean.valueOf(z));
    }

    @DesignerProperty(defaultValue = "True", editorType = "boolean")
    @SimpleProperty(description = "If set to true, user can touch the switch.")
    public final void Enabled(boolean z) {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setEnabled(z);
    }

    @SimpleProperty(description = "Returns true is the switch is enabled.")
    public final boolean Enabled() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isEnabled();
    }

    @DesignerProperty(defaultValue = "&HFF4CAF50", editorType = "color")
    @SimpleProperty(description = "Change the disabled color of the switch.")
    public final void ThumbColor(int i) {
        this.Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm = i;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getThumbDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    @SimpleProperty(description = "Return the thumb color.")
    public final int ThumbColor() {
        return this.Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm;
    }

    @DesignerProperty(defaultValue = "&HFF009688", editorType = "color")
    @SimpleProperty(description = "Change the enabled color of the switch.")
    public final void TrackColor(int i) {
        this.ZBOPOXf20XZKrN6ycbQhEDPC2OsW2QCGfMHApJMYjAVGCpHVQNyA3eb1TXx8tY2I = i;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.getTrackDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }

    @SimpleProperty(description = "Return the thumb color.")
    public final int TrackColor() {
        return this.ZBOPOXf20XZKrN6ycbQhEDPC2OsW2QCGfMHApJMYjAVGCpHVQNyA3eb1TXx8tY2I;
    }

    @SimpleProperty(description = "Return true if the switch is checked else false.")
    public final boolean isChecked() {
        return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isChecked();
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(description = "Set the toggle to checked or unchecked")
    public final void Checked(boolean z) {
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setChecked(z);
    }

    @DesignerProperty(defaultValue = "14.0", editorType = "non_negative_float")
    @SimpleProperty(description = "The text size of the switch.")
    public final void TextSize(float f) {
        TextViewUtil.setFontSize(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, f);
    }

    @SimpleProperty(description = "Return the text size of the switch.")
    public final float TextSize() {
        return TextViewUtil.getFontSize(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.context);
    }

    @DesignerProperty(defaultValue = "&HFF4CAF50", editorType = "color")
    @SimpleProperty(description = "Set the text color for the switch.")
    public final void TextColor(int i) {
        this.textColor = i;
        this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setTextColor(i);
    }

    @SimpleProperty(description = "Returns the text color for the switch.")
    public final int TextColor() {
        return this.textColor;
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final boolean FontBold() {
        return this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public final void FontBold(boolean z) {
        this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT = z;
        TextViewUtil.setFontTypeface(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.fontTypeface, z, this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final boolean FontItalic() {
        return this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC;
    }

    @DesignerProperty(defaultValue = "False", editorType = "boolean")
    @SimpleProperty(userVisible = false)
    public final void FontItalic(boolean z) {
        this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC = z;
        TextViewUtil.setFontTypeface(this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, this.fontTypeface, this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT, z);
    }

    @SimpleProperty(category = PropertyCategory.APPEARANCE, userVisible = false)
    public final int FontTypeface() {
        return this.fontTypeface;
    }

    @DesignerProperty(defaultValue = "0", editorType = "typeface")
    @SimpleProperty(userVisible = false)
    public final void FontTypeface(int i) {
        this.fontTypeface = i;
    }

    @DesignerProperty(defaultValue = "", editorType = "font_asset", propertyType = "advanced")
    @SimpleProperty(description = "Set a custom font.")
    public final void FontTypefaceImport(String str) {
        if (str != null) {
            TextViewUtil.setCustomFontTypeface(this.container.$form(), this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME, str, this.yKzj3OK1ig8r7pqFZ5OXQyoqJiWnRvwjZPZ1kORJGZPQRb8FuKJuM2qAKu5QCSLT, this.PpoaLB2hgzDTOuqu9FkRmbGOAi4DOSz44cSb2WOQzHfJN0AfA0f9dWyZXVLXkHHC);
        }
    }

    @DesignerProperty(defaultValue = "Switch On", editorType = "textArea")
    @SimpleProperty(description = "Set here the switch on text. HTML tags are too possible: <b>, <big>, <blockquote>, <br>, <cite>, <dfn>, <div>, <em>, <small>, <strong>, <sub>, <sup>, <tt>, <u>. Example: <big>Test</big>.")
    public final void TextOn(String str) {
        this.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD = str;
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isChecked()) {
            Switch switchR = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            switchR.setText(TextViewUtil.fromHtml(this.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD + "  "));
            return;
        }
        Switch switchR2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        switchR2.setText(TextViewUtil.fromHtml(this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5 + "  "));
    }

    @SimpleProperty(description = "Return the switch on text.")
    public final String TextOn() {
        return this.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD;
    }

    @DesignerProperty(defaultValue = "Switch Off", editorType = "textArea")
    @SimpleProperty(description = "Set here the switch off text. HTML tags are too possible: <b>, <big>, <blockquote>, <br>, <cite>, <dfn>, <div>, <em>, <small>, <strong>, <sub>, <sup>, <tt>, <u>. Example: <big>Test</big>.")
    public final void TextOff(String str) {
        this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5 = str;
        if (this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.isChecked()) {
            Switch switchR = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
            switchR.setText(TextViewUtil.fromHtml(this.ZFwQoaMsdRwNqOTkWG5sFNIKnTcrKyb4dIRsDmVa68cFIA9m1jUiaqOHngvgXrvD + "  "));
            return;
        }
        Switch switchR2 = this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        switchR2.setText(TextViewUtil.fromHtml(this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5 + "  "));
    }

    @SimpleProperty(description = "Return the switch off text.")
    public final String TextOff() {
        return this.UT8jc0jwpnlGoVnBZm9Vqfc7zQxpOFTo7zW0ZxKDjXZZsrQ7LsG7hsoko7RBNNg5;
    }

    @SimpleFunction(description = "Set the drawable used for the switch 'thumb' - the piece that the user can physically touch and drag along the track. If 'color Filter Enabled' is set to true, the image will get a light tint filter with the same color that you used as thumb color.")
    public final void ThumbImage(String str) {
        if (!str.isEmpty()) {
            try {
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setThumbDrawable(MediaUtil.getBitmapDrawable(this.container.$form(), str));
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.invalidate();
            } catch (Exception unused) {
                Log.e("Switch", "Unable to load ".concat(String.valueOf(str)));
            }
        }
    }

    @SimpleFunction(description = "Set the drawable used for the switch 'thumb' - the piece that the user can physically touch and drag along the track. You can find the icon name (or code) here at https://material.io/icons . Use as size as example '300'.")
    public final void ThumbImageFromMaterialFont(String str, float f) {
        if (!str.isEmpty()) {
            if (f == 0.0f) {
                f = 80.0f;
            }
            int i = (int) f;
            try {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(KodularHelper.textToBitmap(this.context, "material", str, this.Sj3UMCQcT7f46E8U4TVavenawPElr174psURarVHJJBTqMXe22hIekct3fzxe7Vm, f));
                bitmapDrawable.setBounds(0, 0, i, i);
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.setThumbDrawable(bitmapDrawable);
                this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME.invalidate();
            } catch (Exception e) {
                Log.e("Switch", String.valueOf(e));
            }
        }
    }
}
