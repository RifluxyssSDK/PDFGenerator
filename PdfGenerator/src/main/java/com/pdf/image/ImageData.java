package com.pdf.image;

import android.content.Context;
import android.graphics.Bitmap;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class ImageData {

    final Context context;

    Bitmap imageBitmap;

    int marginLeft = 0,
    marginTop = 0,
    marginRight = 0,
    marginBottom = 0;

    public ImageData(Context context, Bitmap imageBitmap) {
        this.context = context;
        this.imageBitmap = imageBitmap;

    }

    public ImageData setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
        BitmapMargin canvasToBitmap = new BitmapMargin(context, this);
        imageBitmap = canvasToBitmap.getBitmap();
        return this;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public ImageData init(int pageWidth, int pageHeight) {
        imageBitmap = Bitmap.createScaledBitmap(imageBitmap, pageWidth, pageHeight, false);
        return this;
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

}


