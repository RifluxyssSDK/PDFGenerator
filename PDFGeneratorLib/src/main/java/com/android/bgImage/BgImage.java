package com.android.bgImage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class BgImage {

    private final Bitmap image;
    private int marginLeft;
    private int marginTop;
    private int marginRight;
    private int marginBottom;

    public BgImage(Bitmap image) {
        this.image = image;
    }

    public void setMargin(int margin) {
        this.marginLeft = margin;
        this.marginTop = margin;
        this.marginRight = margin;
        this.marginBottom = margin;
    }

    public void setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public Bitmap getImage(int width, int height) {
        return initBackground(width, height);
    }

    private Bitmap initBackground(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap((image.getWidth() + getMarginLeft() + getMarginRight()), (image.getHeight() + getMarginTop() + getMarginBottom()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT);
        canvas.drawBitmap(image, marginLeft, marginTop, null);
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }
}
