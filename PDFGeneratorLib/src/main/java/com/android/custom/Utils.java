package com.android.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;

import com.android.kernel.FontStyle;

import java.util.List;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Utils {

    public static Drawable createBorder(int backgroundColor, int borderColor, int width) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(width, borderColor);
        gradientDrawable.setColor(backgroundColor);
        return new LayerDrawable(new Drawable[]{gradientDrawable});
    }

    public static Typeface createGetFont(Context context, int typeFace) {

        switch (typeFace) {
            default:
                return Typeface.createFromAsset(context.getAssets(), "font/Times-Roman.otf");
            case FontStyle.HELVETICA:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica.ttf");
            case FontStyle.HELVETICA_BOLD:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-Bold.ttf");
            case FontStyle.HELVETICA_BOLD_OBLIQUE:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-BoldOblique.ttf");
            case FontStyle.HELVETICA_ROUNDED_BOLD:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-rounded-bold.otf");
            case FontStyle.HELVETICA_OBLIQUE:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-Oblique.ttf");
            case FontStyle.HELVETICA_LIGHT:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-light.ttf");
            case FontStyle.HELVETICA_COMPRESSED:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-compressed.otf");
        }
    }


    public static int getViewHeight(List<View> views) {

        int mHeight = 0;

        for (int i = 0; i < views.size(); i++) {

            views.get(i).measure(0, 0);
            mHeight += views.get(i).getMeasuredHeight();

        }

        return mHeight;
    }
}
