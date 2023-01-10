package android.pdf.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.media.ExifInterface;
import android.os.Build;
import android.os.Environment;
import android.pdf.element.Image;
import android.util.DisplayMetrics;
import android.view.View;

import android.pdf.constant.FontStyle;

import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.BitmapCompat;

import com.rifluxyss.pdfgenerator.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * Utility's
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Utils {

    /**
     * The constant fileExtension.
     */
    public static String fileExtension = ".png";

    /**
     * Create border drawable.
     *
     * @param backgroundColor the background color
     * @param borderColor     the border color
     * @param width           the width of border
     * @return the drawable
     */
    public static Drawable createBorder(int backgroundColor, int borderColor, int width) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(width, borderColor);
        gradientDrawable.setColor(backgroundColor);
        return new LayerDrawable(new Drawable[]{gradientDrawable});
    }

    /**
     * Create get font typeface.
     *
     * @param context  the context
     * @param typeFace the type face
     * @return the typeface
     */
    public static Typeface createGetFont(Context context, int typeFace) {

        switch (typeFace) {
            default:
                return ResourcesCompat.getFont(context, R.font.helvetica);
            case FontStyle.HELVETICA_BOLD:
                return ResourcesCompat.getFont(context, R.font.helvetica_bold);
            case FontStyle.HELVETICA_BOLD_OBLIQUE:
                return ResourcesCompat.getFont(context, R.font.helvetica_bold_oblique);
            case FontStyle.HELVETICA_ROUNDED_BOLD:
                return ResourcesCompat.getFont(context, R.font.helvetica_rounded_bold);
            case FontStyle.HELVETICA_OBLIQUE:
                return  ResourcesCompat.getFont(context, R.font.helvetica_oblique);
            case FontStyle.HELVETICA_LIGHT:
                return  ResourcesCompat.getFont(context, R.font.helvetica_light);
            case FontStyle.HELVETICA_COMPRESSED:
                return  ResourcesCompat.getFont(context, R.font.helvetica_compressed);
        }
    }


    /**
     * Gets view height.
     *
     * @param views the views
     * @return the view height
     */
    public static int getViewHeight(List<View> views) {

        int mHeight = 0;

        for (int i = 0; i < views.size(); i++) {

            views.get(i).measure(0, 0);
            mHeight += views.get(i).getMeasuredHeight();

        }

        return mHeight;
    }

    public int getDensity(Context context) {

        int density = 0;
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();

        switch(metrics.densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                density = DisplayMetrics.DENSITY_LOW;
                break;

            case DisplayMetrics.DENSITY_MEDIUM:
                density = DisplayMetrics.DENSITY_MEDIUM;
                break;

            case DisplayMetrics.DENSITY_HIGH:
                density = DisplayMetrics.DENSITY_HIGH;
                break;

            case DisplayMetrics.DENSITY_XHIGH:
                density = DisplayMetrics.DENSITY_XHIGH;
                break;

            case DisplayMetrics.DENSITY_XXHIGH:
                density = DisplayMetrics.DENSITY_XXHIGH;
                break;

            case DisplayMetrics.DENSITY_XXXHIGH:
                density = DisplayMetrics.DENSITY_XXXHIGH;
                break;
        }

        return density;

    }

    public static long getFolderSize(File f) {
        long size = 0;
        if (f.isDirectory()) {
            for (File file : Objects.requireNonNull(f.listFiles())) {
                size += BitmapCompat.getAllocationByteCount(BitmapFactory.decodeFile(file.getAbsolutePath()));

                size += getFolderSize(file);
            }
        } else {
            size=f.length();
        }
        return size;
    }

    public static long getFolderBitmapSize(File f) {
        long size = 0;
        if (f.isDirectory()) {
            for (File file : Objects.requireNonNull(f.listFiles())) {
                size += BitmapCompat.getAllocationByteCount(BitmapFactory.decodeFile(file.getAbsolutePath()));
            }
        } else {
            size=f.length();
        }
        return size;
    }

    public static String getStringSizeLengthFile(long size) {

        DecimalFormat df = new DecimalFormat("0.00");

        float sizeKb = size/1024.0f;

        if (sizeKb > 1) {
            return df.format(sizeKb).concat(" MB");
        } else {
            return df.format(sizeKb).concat(" KB");
        }

    }

}
