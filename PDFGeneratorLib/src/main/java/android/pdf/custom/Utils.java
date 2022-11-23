package android.pdf.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;

import android.pdf.kernel.FontStyle;

import androidx.core.content.res.ResourcesCompat;

import com.rifluxyss.pdfgenerator.R;

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
                return ResourcesCompat.getFont(context, R.font.times_roman);
            case FontStyle.HELVETICA:
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


    public static int getViewHeight(List<View> views) {

        int mHeight = 0;

        for (int i = 0; i < views.size(); i++) {

            views.get(i).measure(0, 0);
            mHeight += views.get(i).getMeasuredHeight();

        }

        return mHeight;
    }
}
