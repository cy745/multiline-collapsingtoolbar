package net.opacapp.multilinecollapsingtoolbar;

import android.text.TextPaint;

public class TextAlphaHelper {
    /**
     * 实现自定义透明度
     */
    private boolean textAlpha = false;
    private int textAlphaValue = 255;

    public void updateTextAlpha(int value) {
        this.textAlpha = value >= 0 && value < 255;
        this.textAlphaValue = value;
    }

    public boolean shouldDrawAlpha() {
        return textAlpha || textAlphaValue == 0;
    }

    public void autoSetAlphaToTextPaint(TextPaint toTextPaint) {
        if (shouldDrawAlpha()) {
            toTextPaint.setAlpha(textAlphaValue);
        }
    }
}
