package android.pdf.io;

import android.graphics.Color;

import android.pdf.kernel.ElementType;

/**
 * This class used to create each line for pdf document.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Line extends Element {

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

    int lineColor;
    int lineStrokeWidth;

    /**
     * @param rowSpan It represents the number of rows to span.
     * @param colSpan It represents the number of columns to span.
     */
    public Line(int rowSpan, int colSpan) {
        setRowSpan(rowSpan);
        setColSpan(colSpan);
        setLineStrokeWidth(1);
        setLineColor(Color.BLACK);
    }

    /**
     * @return Line It used to find the type of Element's
     */
    @Override
    public byte getElementType() {
        return ElementType.LINE;
    }

    /**
     * @param rowSpan It represents the number of rows to span.
     * @return Line
     */
    public Line setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    /**
     * @param colSpan It represents the number of rows to span.
     * @return Line
     */
    public Line setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    /**
     * @param marginLeft It specifies extra space on the LEFT side of the view.
     * @return Line
     */
    public Line setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * @param marginTop It specifies extra space on the TOP side of the view.
     * @return Line
     */
    public Line setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * @param marginRight It specifies extra space on the Right side of the view.
     * @return Line
     */
    public Line setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * @param marginBottom It specifies extra space on the BOTTOM side of the view.
     * @return Line
     */
    public Line setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * @param paddingLeft It used to specify extra space on the LEFT Side inside the view.
     * @return Line
     */
    public Line setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * @param paddingTop It used to specify extra space on the TOP Side inside the view.
     * @return Line
     */
    public Line setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * @param paddingRight It used to specify extra space on the RIGHT Side inside the view.
     * @return Line
     */
    public Line setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * @param paddingBottom It used to specify extra space on the BOTTOM Side inside the view.
     * @return Line
     */
    public Line setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * @param margin It specifies extra space on the LEFT, TOP, RIGHT, BOTTOM side's of the view.
     * @return Line
     */
    public Line setMargin(int margin){
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
     * @return Line
     */
    public Line setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        setMarginLeft(marginLeft);
        setMarginTop(marginTop);
        setMarginRight(marginRight);
        setMarginBottom(marginBottom);
        return this;
    }

    /**
     * @param padding It used to specify extra space on the LEFT, TOP, RIGHT, BOTTOM side's inside the view.
     * @return Line
     */
    public Line setPadding(int padding) {
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
     * @return Line
     */
    public Line setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        setPaddingLeft(paddingLeft);
        setPaddingTop(paddingTop);
        setPaddingRight(paddingRight);
        setPaddingBottom(paddingBottom);
        return this;
    }

    /**
     * @param lineColor It used to set the color of line.
     * @return Line
     */
    public Line setLineColor(int lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    /**
     * @param lineStrokeWidth It used to set the strokeWidth of line.
     * @return Line
     */
    public Line setLineStrokeWidth(int lineStrokeWidth) {
        this.lineStrokeWidth = lineStrokeWidth;
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

    public int getLineColor() {
        return lineColor;
    }

    public int getLineStrokeWidth() {
        return lineStrokeWidth;
    }
}
