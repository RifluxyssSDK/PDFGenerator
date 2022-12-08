package android.pdf.dimension;

/**
 * The type Dimension model.
 */
public class DimensionModel {

    private final int densityDpi,heightPixels, widthPixels;
    private final float density, scaledDensity,xdpi, ydpi;

    /**
     * Instantiates a new Dimension model.
     *
     * @param densityDpi    the density dpi
     * @param heightPixels  the height pixels
     * @param widthPixels   the width pixels
     * @param density       the density
     * @param scaledDensity the scaled density
     * @param xdpi          the xdpi
     * @param ydpi          the ydpi
     */
    public DimensionModel(int densityDpi, int heightPixels, int widthPixels, float density, float scaledDensity, float xdpi, float ydpi) {
        this.densityDpi = densityDpi;
        this.heightPixels = heightPixels;
        this.widthPixels = widthPixels;
        this.density = density;
        this.scaledDensity = scaledDensity;
        this.xdpi = xdpi;
        this.ydpi = ydpi;
    }

    /**
     * Gets density dpi.
     *
     * @return the density dpi
     */
    public int getDensityDpi() {
        return densityDpi;
    }

    /**
     * Gets height pixels.
     *
     * @return the height pixels
     */
    public int getHeightPixels() {
        return heightPixels;
    }

    /**
     * Gets width pixels.
     *
     * @return the width pixels
     */
    public int getWidthPixels() {
        return widthPixels;
    }

    /**
     * Gets density.
     *
     * @return the density
     */
    public float getDensity() {
        return density;
    }

    /**
     * Gets scaled density.
     *
     * @return the scaled density
     */
    public float getScaledDensity() {
        return scaledDensity;
    }

    /**
     * Gets xdpi.
     *
     * @return the xdpi
     */
    public float getXdpi() {
        return xdpi;
    }

    /**
     * Gets ydpi.
     *
     * @return the ydpi
     */
    public float getYdpi() {
        return ydpi;
    }
}
