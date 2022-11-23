package com.android;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

public class CustomTypefaceSpan extends TypefaceSpan {

    private final Typeface newType;

    public CustomTypefaceSpan(String family, Typeface type) {
        super(family);
        newType = type;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        applyCustomTypeFace(ds, newType);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        applyCustomTypeFace(paint, newType);
    }

    private static void applyCustomTypeFace(Paint paint, Typeface tf) {

        Typeface old = paint.getTypeface();
        int oldStyle = old == null ? 0 : old.getStyle();

        int fake = oldStyle & tf.getStyle();
        boolean boldText = (fake & Typeface.BOLD) != 0;
        paint.setFakeBoldText(boldText);

        float skewX = (fake & Typeface.ITALIC) != 0 ? -0.25f : 0f;
        paint.setTextSkewX(skewX);

        paint.setTypeface(tf);

    }
}