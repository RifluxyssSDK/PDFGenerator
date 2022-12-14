package android.pdf.utility;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.pdf.constant.FontStyle;
import android.pdf.core.Instance;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

import com.rifluxyss.pdfgenerator.R;

import java.util.List;

/**
 * The type Utils.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Utils {

    /**
     * Create border drawable.
     *
     * @param backgroundColor the background color
     * @param borderColor     the border color
     * @param width           the width
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
     * @param typeFace the type face
     * @return the typeface
     */
    public static Typeface createGetFont(int typeFace) {
        switch (typeFace) {
            default:
                return ResourcesCompat.getFont(Instance.getInstance().getContext(), R.font.helvetica);
            case FontStyle.HELVETICA_BOLD:
                return ResourcesCompat.getFont(Instance.getInstance().getContext(), R.font.helvetica_bold);
            case FontStyle.HELVETICA_BOLD_OBLIQUE:
                return ResourcesCompat.getFont(Instance.getInstance().getContext(), R.font.helvetica_bold_oblique);
            case FontStyle.HELVETICA_ROUNDED_BOLD:
                return ResourcesCompat.getFont(Instance.getInstance().getContext(), R.font.helvetica_rounded_bold);
            case FontStyle.HELVETICA_OBLIQUE:
                return ResourcesCompat.getFont(Instance.getInstance().getContext(), R.font.helvetica_oblique);
            case FontStyle.HELVETICA_LIGHT:
                return ResourcesCompat.getFont(Instance.getInstance().getContext(), R.font.helvetica_light);
            case FontStyle.HELVETICA_COMPRESSED:
                return ResourcesCompat.getFont(Instance.getInstance().getContext(), R.font.helvetica_compressed);
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
}
