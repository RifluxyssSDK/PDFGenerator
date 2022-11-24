package android.pdf.io;

import android.graphics.Bitmap;
import android.widget.ImageView;

import android.pdf.kernel.ElementType;

/**
 * This class used to create each image for pdf document.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Image extends Element {

    int rowSpan;
    int colSpan;

    int marginLeft;
    int marginTop;
    int marginRight;
    int marginBottom;

    int paddingLeft;
    int paddingTop;
    int paddingRight;
    int paddingBottom;

    int imageWidth;
    int imageHeight;

    Bitmap image;
    boolean border;
    int borderWidth;
    int borderColor;
    int backgroundColor;
    ImageView.ScaleType scaleType;

    /**
     * @param rowSpan It represents the number of rows to span.
     * @param colSpan It represents the number of columns to span.
     * @param image It used to create image for pdf document.
     */
    public Image(int rowSpan, int colSpan, Bitmap image) {
        setImage(image);
        setRowSpan(rowSpan);
        setColSpan(colSpan);
        setImageWidth(image.getWidth());
        setImageHeight(image.getHeight());
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    /**
     * @return Image It used to find the type of Element's
     */
    @Override
    public byte getElementType() {
        return ElementType.IMAGE;
    }

    /**
     * @param rowSpan It represents the number of rows to span.
     * @return Image
     */
    public Image setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    /**
     * @param colSpan It represents the number of rows to span.
     * @return Image
     */
    public Image setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    /**
     * @param marginLeft It specifies extra space on the LEFT side of the view.
     * @return Image
     */
    public Image setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * @param marginTop It specifies extra space on the TOP side of the view.
     * @return Image
     */
    public Image setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * @param marginRight It specifies extra space on the Right side of the view.
     * @return Image
     */
    public Image setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * @param marginBottom It specifies extra space on the BOTTOM side of the view.
     * @return Image
     */
    public Image setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * @param paddingLeft It used to specify extra space on the LEFT Side inside the view.
     * @return Image
     */
    public Image setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * @param paddingTop It used to specify extra space on the TOP Side inside the view.
     * @return Image
     */
    public Image setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * @param paddingRight It used to specify extra space on the RIGHT Side inside the view.
     * @return Image
     */
    public Image setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * @param paddingBottom It used to specify extra space on the BOTTOM Side inside the view.
     * @return Image
     */
    public Image setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * @param imageWidth It used to set the width of image.
     * @return Image
     */
    public Image setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
        return this;
    }

    /**
     * @param imageHeight It used to set the height of image.
     * @return Image
     */
    public Image setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
        return this;
    }

    /**
     * @param image It used to create image for pdf document.
     * @return Image
     */
    public Image setImage(Bitmap image) {
        this.image = image;
        return this;
    }

    /**
     * @param border It used to set the border of image.
     * @return Image
     */
    public Image setBorder(boolean border) {
        this.border = border;
        return this;
    }

    /**
     * @param padding It used to specify extra space on the LEFT, TOP, RIGHT, BOTTOM side's inside the view.
     * @return Image
     */
    public Image setPadding(int padding) {
        setPaddingLeft(padding);
        setPaddingTop(padding);
        setPaddingRight(padding);
        setPaddingBottom(padding);
        return this;
    }

    /**
     * @param paddingLeft It used to specify extra space on the LEFT side inside the view.
     * @param paddingTop It used to specify extra space on the TOP side inside the view.
     * @param paddingRight It used to specify extra space on the RIGHT side inside the view.
     * @param paddingBottom It used to specify extra space on the BOTTOM side inside the view.
     * @return Text
     */
    public Image setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        setPaddingLeft(paddingLeft);
        setPaddingTop(paddingTop);
        setPaddingRight(paddingRight);
        setPaddingBottom(paddingBottom);
        return this;
    }

    /**
     * @param margin It specifies extra space on the LEFT, TOP, RIGHT, BOTTOM side's of the view.
     * @return Image
     */
    public Image setMargin(int margin) {
        setMarginLeft(margin);
        setMarginTop(margin);
        setMarginRight(margin);
        setMarginBottom(margin);
        return this;
    }

    /**
     * @param marginLeft It specifies extra space on the LEFT side of the view.
     * @param marginTop It specifies extra space on the TOP side of the view.
     * @param marginRight It specifies extra space on the RIGHT side of the view.
     * @param marginBottom It specifies extra space on the BOTTOM side of the view.
     * @return Text
     */
    public Image setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        setMarginLeft(marginLeft);
        setMarginTop(marginTop);
        setMarginRight(marginRight);
        setMarginBottom(marginBottom);
        return this;
    }

    /**
     * @param scaleType It used to set the scaleType of image.
     * @return Image
     */
    public Image setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
        return this;
    }

    /**
     * @param borderWidth It used to set the strokeWidth of image border.
     * @return Image
     */
    public Image setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * @param borderColor It used to set the color of image border.
     * @return Image
     */
    public Image setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * @param backgroundColor It used to set the background of image.
     * @return Image
     */
    public Image setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public int getRowSpan() {
        return rowSpan;
    }

    public int getColSpan() {
        return colSpan;
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

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public Bitmap getImage() {
        return image;
    }

    public boolean isBorder() {
        return border;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public ImageView.ScaleType getScaleType() {
        return scaleType;
    }
}
