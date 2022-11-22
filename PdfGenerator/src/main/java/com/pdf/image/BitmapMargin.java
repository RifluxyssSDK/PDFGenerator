package com.pdf.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@SuppressWarnings("unused")
@SuppressLint("ViewConstructor")
public class BitmapMargin extends View {

    Bitmap bitmap;
    final ImageData imageData;

    public BitmapMargin(Context context, ImageData imageData) {
        super(context);

        this.imageData = imageData;
        bitmap = Bitmap.createBitmap(
                (imageData.getImageBitmap().getWidth() + imageData.getMarginLeft() + imageData.getMarginRight()),
                (imageData.getImageBitmap().getHeight() + imageData.getMarginTop() + imageData.getMarginBottom()),
                Bitmap.Config.ARGB_8888
        );

        Canvas canvas = new Canvas(bitmap);
        draw(canvas);
    }

    @SuppressLint("DrawAllocation")
    @Override
    public void onDraw(Canvas canvas) {

        canvas.drawBitmap(imageData.getImageBitmap(), imageData.getMarginLeft(), imageData.getMarginTop(), null);
        canvas.setBitmap(bitmap);

        try {

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            byteArrayOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
