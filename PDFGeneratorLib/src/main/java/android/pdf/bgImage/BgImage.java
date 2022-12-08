package android.pdf.bgImage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.pdf.constant.PageSize;
import android.pdf.core.Instance;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class BgImage {

    /**
     * This bitmap used to set background image for each page of document.
     */
    private final Bitmap image;
    /**
     * It used to creating a white space on image LEFT side.
     */
    private int marginLeft;
    /**
     * It used to creating a white space on image TOP side.
     */
    private int marginTop;
    /**
     * It used to creating a white space on image RIGHT side.
     */
    private int marginRight;
    /**
     * It used to creating a white space on image BOTTOM side.
     */
    private int marginBottom;

    /**
     * @param image This bitmap used to set background image for each page of document.
     */
    public BgImage(Bitmap image) {
        this.image = image;
    }

    /**
     * @param margin This parameter used to creating a white space around the given image.
     */
    public void setMargin(int margin) {
        this.marginLeft = margin;
        this.marginTop = margin;
        this.marginRight = margin;
        this.marginBottom = margin;
    }

    /**
     * @param marginLeft   This parameter used to creating a white space on image LEFT side.
     * @param marginTop    This parameter used to creating a white space on image TOP side.
     * @param marginRight  This parameter used to creating a white space on image RIGHT side.
     * @param marginBottom This parameter used to creating a white space on image BOTTOM side.
     */
    public void setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
    }

    /**
     * @return marginLeft
     */
    public int getMarginLeft() {
        return marginLeft;
    }

    /**
     * @return marginTop
     */
    public int getMarginTop() {
        return marginTop;
    }

    /**
     * @return marginRight
     */
    public int getMarginRight() {
        return marginRight;
    }

    /**
     * @return marginBottom
     */
    public int getMarginBottom() {
        return marginBottom;
    }

    /**
     * @return backgroundImage
     */
    public Bitmap getImage() {
        PageSize pageSize = Instance.getInstance().getPageSize();
        Bitmap bitmap = Bitmap.createBitmap((image.getWidth() + getMarginLeft() + getMarginRight()), (image.getHeight() + getMarginTop() + getMarginBottom()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.TRANSPARENT);
        canvas.drawBitmap(image, getMarginLeft(), getMarginTop(), null);
        return Bitmap.createScaledBitmap(bitmap, pageSize.getDocumentWidth(), pageSize.getDocumentHeight(), true);
    }
}
