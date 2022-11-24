package android.pdf.bgImage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class BgImage {

    private final Bitmap image;
    private int marginLeft;
    private int marginTop;
    private int marginRight;
    private int marginBottom;

    /**
     * @param image This bitmap used to set background image for each page of document.
     */
    public BgImage(Bitmap image) {
        this.image = image;
    }

    /**
     * @param margin This parameter used to creating a white space around the given bitmap.
     */
    public void setMargin(int margin) {
        this.marginLeft = margin;
        this.marginTop = margin;
        this.marginRight = margin;
        this.marginBottom = margin;
    }

    /**
     * @param marginLeft This parameter used to creating a white space on Left side on given image.
     * @param marginTop This parameter used to creating a white space on Top side on given image.
     * @param marginRight This parameter used to creating a white space on Right side on given image.
     * @param marginBottom This parameter used to creating a white space on Bottom side on given image.
     */
    public void setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    /**
     * @param width This parameter used to createScaledBitmap for actual document size.
     * @param height This parameter used to createScaledBitmap for actual document size.
     * @return backgroundImage
     */
    public Bitmap getImage(int width, int height) {
        return initBackground(width, height);
    }

    /**
     * @param width This parameter used to createScaledBitmap for actual document size.
     * @param height This parameter used to createScaledBitmap for actual document size.
     * @return backgroundImage
     */
    private Bitmap initBackground(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap((image.getWidth() + getMarginLeft() + getMarginRight()), (image.getHeight() + getMarginTop() + getMarginBottom()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT);
        canvas.drawBitmap(image, marginLeft, marginTop, null);
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }
}
