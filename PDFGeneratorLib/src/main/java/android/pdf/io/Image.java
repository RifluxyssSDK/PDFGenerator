package android.pdf.io;

import android.graphics.Bitmap;
import android.widget.ImageView;

import android.pdf.kernel.ElementType;

/**
 * This class used to create each image for pdf document.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Image extends Element {

    /**
     * The Row span.
     */
    int rowSpan;
    /**
     * The Col span.
     */
    int colSpan;

    /**
     * The Margin left.
     */
    int marginLeft;
    /**
     * The Margin top.
     */
    int marginTop;
    /**
     * The Margin right.
     */
    int marginRight;
    /**
     * The Margin bottom.
     */
    int marginBottom;

    /**
     * The Padding left.
     */
    int paddingLeft;
    /**
     * The Padding top.
     */
    int paddingTop;
    /**
     * The Padding right.
     */
    int paddingRight;
    /**
     * The Padding bottom.
     */
    int paddingBottom;

    /**
     * The Image width.
     */
    int imageWidth;
    /**
     * The Image height.
     */
    int imageHeight;

    /**
     * The Image.
     */
    Bitmap image;
    /**
     * The Border.
     */
    boolean border;
    /**
     * The Border width.
     */
    int borderWidth;
    /**
     * The Border color.
     */
    int borderColor;
    /**
     * The Background color.
     */
    int backgroundColor;
    /**
     * The Scale type.
     */
    ImageView.ScaleType scaleType;

    /**
     * Instantiates a new Image.
     *
     * @param rowSpan It represents the number of rows to span.
     * @param colSpan It represents the number of columns to span.
     * @param image   It used to create image for pdf document.
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
     * Sets row span.
     *
     * @param rowSpan It represents the number of rows to span.
     * @return Image row span
     */
    public Image setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    /**
     * Sets col span.
     *
     * @param colSpan It represents the number of rows to span.
     * @return Image col span
     */
    public Image setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    /**
     * Sets margin left.
     *
     * @param marginLeft It specifies extra space on the LEFT side of the view.
     * @return Image margin left
     */
    public Image setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * Sets margin top.
     *
     * @param marginTop It specifies extra space on the TOP side of the view.
     * @return Image margin top
     */
    public Image setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * Sets margin right.
     *
     * @param marginRight It specifies extra space on the Right side of the view.
     * @return Image margin right
     */
    public Image setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * Sets margin bottom.
     *
     * @param marginBottom It specifies extra space on the BOTTOM side of the view.
     * @return Image margin bottom
     */
    public Image setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * Sets padding left.
     *
     * @param paddingLeft It used to specify extra space on the LEFT Side inside the view.
     * @return Image padding left
     */
    public Image setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * Sets padding top.
     *
     * @param paddingTop It used to specify extra space on the TOP Side inside the view.
     * @return Image padding top
     */
    public Image setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * Sets padding right.
     *
     * @param paddingRight It used to specify extra space on the RIGHT Side inside the view.
     * @return Image padding right
     */
    public Image setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * Sets padding bottom.
     *
     * @param paddingBottom It used to specify extra space on the BOTTOM Side inside the view.
     * @return Image padding bottom
     */
    public Image setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * Sets image width.
     *
     * @param imageWidth It used to set the width of image.
     * @return Image image width
     */
    public Image setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
        return this;
    }

    /**
     * Sets image height.
     *
     * @param imageHeight It used to set the height of image.
     * @return Image image height
     */
    public Image setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
        return this;
    }

    /**
     * Sets image.
     *
     * @param image It used to create image for pdf document.
     * @return Image image
     */
    public Image setImage(Bitmap image) {
        this.image = image;
        return this;
    }

    /**
     * Sets border.
     *
     * @param border It used to set the border of image.
     * @return Image border
     */
    public Image setBorder(boolean border) {
        this.border = border;
        return this;
    }

    /**
     * Sets padding.
     *
     * @param padding It used to specify extra space on the LEFT, TOP, RIGHT, BOTTOM side's inside the view.
     * @return Image padding
     */
    public Image setPadding(int padding) {
        setPaddingLeft(padding);
        setPaddingTop(padding);
        setPaddingRight(padding);
        setPaddingBottom(padding);
        return this;
    }

    /**
     * Sets padding.
     *
     * @param paddingLeft   It used to specify extra space on the LEFT side inside the view.
     * @param paddingTop    It used to specify extra space on the TOP side inside the view.
     * @param paddingRight  It used to specify extra space on the RIGHT side inside the view.
     * @param paddingBottom It used to specify extra space on the BOTTOM side inside the view.
     * @return Text padding
     */
    public Image setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        setPaddingLeft(paddingLeft);
        setPaddingTop(paddingTop);
        setPaddingRight(paddingRight);
        setPaddingBottom(paddingBottom);
        return this;
    }

    /**
     * Sets margin.
     *
     * @param margin It specifies extra space on the LEFT, TOP, RIGHT, BOTTOM side's of the view.
     * @return Image margin
     */
    public Image setMargin(int margin) {
        setMarginLeft(margin);
        setMarginTop(margin);
        setMarginRight(margin);
        setMarginBottom(margin);
        return this;
    }

    /**
     * Sets margin.
     *
     * @param marginLeft   It specifies extra space on the LEFT side of the view.
     * @param marginTop    It specifies extra space on the TOP side of the view.
     * @param marginRight  It specifies extra space on the RIGHT side of the view.
     * @param marginBottom It specifies extra space on the BOTTOM side of the view.
     * @return Text margin
     */
    public Image setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        setMarginLeft(marginLeft);
        setMarginTop(marginTop);
        setMarginRight(marginRight);
        setMarginBottom(marginBottom);
        return this;
    }

    /**
     * Sets scale type.
     *
     * @param scaleType It used to set the scaleType of image.
     * @return Image scale type
     */
    public Image setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
        return this;
    }

    /**
     * Sets border width.
     *
     * @param borderWidth It used to set the strokeWidth of image border.
     * @return Image border width
     */
    public Image setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Sets border color.
     *
     * @param borderColor It used to set the color of image border.
     * @return Image border color
     */
    public Image setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Sets background color.
     *
     * @param backgroundColor It used to set the background of image.
     * @return Image background color
     */
    public Image setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Gets row span.
     *
     * @return row span
     */
    public int getRowSpan() {
        return rowSpan;
    }

    /**
     * Gets col span.
     *
     * @return col span
     */
    public int getColSpan() {
        return colSpan;
    }

    /**
     * Gets margin left.
     *
     * @return margin left
     */
    public int getMarginLeft() {
        return marginLeft;
    }

    /**
     * Gets margin top.
     *
     * @return the margin top
     */
    public int getMarginTop() {
        return marginTop;
    }

    /**
     * Gets margin right.
     *
     * @return the margin right
     */
    public int getMarginRight() {
        return marginRight;
    }

    /**
     * Gets margin bottom.
     *
     * @return the margin bottom
     */
    public int getMarginBottom() {
        return marginBottom;
    }

    /**
     * Gets padding left.
     *
     * @return the padding left
     */
    public int getPaddingLeft() {
        return paddingLeft;
    }

    /**
     * Gets padding top.
     *
     * @return the padding top
     */
    public int getPaddingTop() {
        return paddingTop;
    }

    /**
     * Gets padding right.
     *
     * @return the padding right
     */
    public int getPaddingRight() {
        return paddingRight;
    }

    /**
     * Gets padding bottom.
     *
     * @return the padding bottom
     */
    public int getPaddingBottom() {
        return paddingBottom;
    }

    /**
     * Gets image width.
     *
     * @return the image width
     */
    public int getImageWidth() {
        return imageWidth;
    }

    /**
     * Gets image height.
     *
     * @return the image height
     */
    public int getImageHeight() {
        return imageHeight;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public Bitmap getImage() {
        return image;
    }

    /**
     * Is border boolean.
     *
     * @return the boolean
     */
    public boolean isBorder() {
        return border;
    }

    /**
     * Gets border width.
     *
     * @return the border width
     */
    public int getBorderWidth() {
        return borderWidth;
    }

    /**
     * Gets border color.
     *
     * @return the border color
     */
    public int getBorderColor() {
        return borderColor;
    }

    /**
     * Gets background color.
     *
     * @return the background color
     */
    public int getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Gets scale type.
     *
     * @return the scale type
     */
    public ImageView.ScaleType getScaleType() {
        return scaleType;
    }
}
