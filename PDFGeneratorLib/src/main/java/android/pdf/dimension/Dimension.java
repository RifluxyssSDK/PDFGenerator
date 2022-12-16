package android.pdf.dimension;

import android.pdf.core.Instance;
import android.util.DisplayMetrics;

/**
 * The type Dimension.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Dimension extends Instance {

    /**
     * Save default display metrics.
     */
    public void saveDefaultDisplayMetrics() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        setDimensionModel(new DimensionModel(
                displayMetrics.densityDpi,
                displayMetrics.heightPixels,
                displayMetrics.widthPixels,
                displayMetrics.density,
                displayMetrics.scaledDensity,
                displayMetrics.xdpi,
                displayMetrics.ydpi
        ));
    }

    /**
     * Sets custom display metrics.
     */
    public void setCustomDisplayMetrics() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.density = 2f;
        displayMetrics.densityDpi = 320;
        displayMetrics.heightPixels = 1184;
        displayMetrics.widthPixels = 768;
        displayMetrics.scaledDensity = 2f;
        displayMetrics.xdpi = 320f;
        displayMetrics.ydpi = 320f;
        getContext().getResources().getDisplayMetrics().setTo(displayMetrics);
    }

    /**
     * Sets default display metrics.
     */
    public void setDefaultDisplayMetrics() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.density = getDimensionModel().getDensity();
        displayMetrics.densityDpi = getDimensionModel().getDensityDpi();
        displayMetrics.heightPixels = getDimensionModel().getHeightPixels();
        displayMetrics.widthPixels = getDimensionModel().getWidthPixels();
        displayMetrics.scaledDensity = getDimensionModel().getScaledDensity();
        displayMetrics.xdpi = getDimensionModel().getXdpi();
        displayMetrics.ydpi = getDimensionModel().getYdpi();
        getContext().getResources().getDisplayMetrics().setTo(displayMetrics);
    }
}
