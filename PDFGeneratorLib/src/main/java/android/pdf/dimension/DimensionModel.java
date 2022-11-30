package android.pdf.dimension;

public class DimensionModel {

    private final float xdpi;
    private final float ydpi;
    private final float density;
    private final float scaledDensity;
    private final int densityDpi;
    private final int heightPixels;
    private final int widthPixels;

    public DimensionModel(float xdpi, float ydpi, float density, float scaledDensity, int densityDpi, int heightPixels, int widthPixels) {
        this.xdpi = xdpi;
        this.ydpi = ydpi;
        this.density = density;
        this.scaledDensity = scaledDensity;
        this.densityDpi = densityDpi;
        this.heightPixels = heightPixels;
        this.widthPixels = widthPixels;
    }

    public float getXdpi() {
        return xdpi;
    }

    public float getYdpi() {
        return ydpi;
    }

    public float getDensity() {
        return density;
    }

    public float getScaledDensity() {
        return scaledDensity;
    }

    public int getDensityDpi() {
        return densityDpi;
    }

    public int getHeightPixels() {
        return heightPixels;
    }

    public int getWidthPixels() {
        return widthPixels;
    }
}
