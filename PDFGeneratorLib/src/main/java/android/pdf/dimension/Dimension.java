package android.pdf.dimension;

import android.pdf.core.Instance;
import android.util.DisplayMetrics;

/**
 * The type Dimension.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Dimension {

    private final Instance instance = Instance.getInstance();

    /**
     * Save default display metrics.
     */
    public void saveDefaultDisplayMetrics() {
        DisplayMetrics displayMetrics = instance.getContext().getResources().getDisplayMetrics();
        instance.setDimensionModel(new DimensionModel(
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
        instance.getContext().getResources().getDisplayMetrics().setTo(displayMetrics);
    }

    /**
     * Sets default display metrics.
     */
    public void setDefaultDisplayMetrics() {
        DimensionModel dimensionModel = instance.getDimensionModel();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.density = dimensionModel.getDensity();
        displayMetrics.densityDpi = dimensionModel.getDensityDpi();
        displayMetrics.heightPixels = dimensionModel.getHeightPixels();
        displayMetrics.widthPixels = dimensionModel.getWidthPixels();
        displayMetrics.scaledDensity = dimensionModel.getScaledDensity();
        displayMetrics.xdpi = dimensionModel.getXdpi();
        displayMetrics.ydpi = dimensionModel.getYdpi();
        instance.getContext().getResources().getDisplayMetrics().setTo(displayMetrics);
    }
}
