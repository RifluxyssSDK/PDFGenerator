package android.pdf.custom;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * The Dimension Class Used To Create Document As A Fixed Size.
 */
public class Dimension {

    /**
     * Instantiates a new Dimension.
     *
     * @param context the context
     */
    public Dimension(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        metrics.density = 2f;
        metrics.densityDpi = 320;
        metrics.heightPixels = 1184;
        metrics.widthPixels = 768;
        metrics.scaledDensity = 2f;
        metrics.xdpi = 320f;
        metrics.ydpi = 320f;
        context.getResources().getDisplayMetrics().setTo(metrics);
    }
}
