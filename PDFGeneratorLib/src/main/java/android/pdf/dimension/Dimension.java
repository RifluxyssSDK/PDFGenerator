package android.pdf.dimension;

import android.content.Context;
import android.pdf.core.Document;
import android.util.DisplayMetrics;

/**
 * The Dimension Class Used To Create Document As A Fixed Size.
 */
public class Dimension {

    private final Context context;
    private final Document document;

    /**
     * Instantiates a new Dimension.
     *
     * @param document the Document
     */
    public Dimension(Document document) {

        this.document = document;
        this.context = document.getContext();

        document.setDimensionModel(new DimensionModel(
                context.getResources().getDisplayMetrics().xdpi,
                context.getResources().getDisplayMetrics().ydpi,
                context.getResources().getDisplayMetrics().density,
                context.getResources().getDisplayMetrics().scaledDensity,
                context.getResources().getDisplayMetrics().densityDpi,
                context.getResources().getDisplayMetrics().heightPixels,
                context.getResources().getDisplayMetrics().widthPixels
        ));
    }

    public void init() {

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

    public void setDefault() {

        DisplayMetrics metrics = new DisplayMetrics();

        DimensionModel dimensionModel = document.getDimensionModel();

        metrics.density = dimensionModel.getDensity();
        metrics.densityDpi = dimensionModel.getDensityDpi();
        metrics.heightPixels = dimensionModel.getHeightPixels();
        metrics.widthPixels = dimensionModel.getWidthPixels();
        metrics.scaledDensity = dimensionModel.getScaledDensity();
        metrics.xdpi = dimensionModel.getXdpi();
        metrics.ydpi = dimensionModel.getYdpi();

        context.getResources().getDisplayMetrics().setTo(metrics);
    }
}