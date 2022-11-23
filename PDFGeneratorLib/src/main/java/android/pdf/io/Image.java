package android.pdf.io;

import android.graphics.Bitmap;
import android.widget.ImageView;

import android.pdf.kernel.ElementType;

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

    public Image(int rowSpan, int colSpan, Bitmap image) {
        setImage(image);
        setRowSpan(rowSpan);
        setColSpan(colSpan);
        setImageWidth(image.getWidth());
        setImageHeight(image.getHeight());
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public byte getElementType() {
        return ElementType.IMAGE;
    }

    public Image setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    public Image setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    public Image setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public Image setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public Image setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    public Image setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public Image setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public Image setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    public Image setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public Image setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    public Image setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
        return this;
    }

    public Image setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
        return this;
    }

    public Image setImage(Bitmap image) {
        this.image = image;
        return this;
    }

    public Image setBorder(boolean border) {
        this.border = border;
        return this;
    }

    public Image setPadding(int padding) {
        setPaddingLeft(padding);
        setPaddingTop(padding);
        setPaddingRight(padding);
        setPaddingBottom(padding);
        return this;
    }

    public Image setMargin(int margin) {
        setMarginLeft(margin);
        setMarginTop(margin);
        setMarginRight(margin);
        setMarginBottom(margin);
        return this;
    }

    public Image setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
        return this;
    }

    public Image setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public Image setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

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
