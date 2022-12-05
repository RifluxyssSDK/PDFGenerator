package android.pdf.dimension;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * The Dimension Class Used To Create Document As A Fixed Size.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Dimension {

    private final Context context;
    private final DisplayMetrics displayMetrics;

    /**
     * Instantiates a new Dimension.
     *
     * @param context the Context
     */
    public Dimension(Context context) {

        this.context = context;

        displayMetrics = context.getResources().getDisplayMetrics();

        this.init();
    }

    /**
     * Change to custom {@link DisplayMetrics}
     */
    private void init() {

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

    /**
     * Change to default {@link DisplayMetrics}
     */
    public void setDefault() {

        DisplayMetrics metrics = new DisplayMetrics();

        context.getResources().getDisplayMetrics().setTo(displayMetrics);

    }
}
