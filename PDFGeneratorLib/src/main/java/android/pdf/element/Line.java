package android.pdf.element;

import android.graphics.Color;

import android.pdf.abstract_io.Element;
import android.pdf.constant.ElementType;

/**
 * This class used to create each line for pdf document.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Line extends Element {

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
     * The Line color.
     */
    int lineColor;
    /**
     * The Line stroke width.
     */
    int lineStrokeWidth;

    /**
     * Instantiates a new Line.
     *
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
     * Sets row span.
     *
     * @param rowSpan It represents the number of rows to span.
     * @return Line row span
     */
    public Line setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    /**
     * Sets col span.
     *
     * @param colSpan It represents the number of rows to span.
     * @return Line col span
     */
    public Line setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    /**
     * Sets margin left.
     *
     * @param marginLeft It specifies extra space on the LEFT side of the view.
     * @return Line margin left
     */
    public Line setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * Sets margin top.
     *
     * @param marginTop It specifies extra space on the TOP side of the view.
     * @return Line margin top
     */
    public Line setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * Sets margin right.
     *
     * @param marginRight It specifies extra space on the Right side of the view.
     * @return Line margin right
     */
    public Line setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * Sets margin bottom.
     *
     * @param marginBottom It specifies extra space on the BOTTOM side of the view.
     * @return Line margin bottom
     */
    public Line setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * Sets padding left.
     *
     * @param paddingLeft It used to specify extra space on the LEFT Side inside the view.
     * @return Line padding left
     */
    public Line setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * Sets padding top.
     *
     * @param paddingTop It used to specify extra space on the TOP Side inside the view.
     * @return Line padding top
     */
    public Line setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * Sets padding right.
     *
     * @param paddingRight It used to specify extra space on the RIGHT Side inside the view.
     * @return Line padding right
     */
    public Line setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * Sets padding bottom.
     *
     * @param paddingBottom It used to specify extra space on the BOTTOM Side inside the view.
     * @return Line padding bottom
     */
    public Line setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * Set margin line.
     *
     * @param margin It specifies extra space on the LEFT, TOP, RIGHT, BOTTOM side's of the view.
     * @return Line line
     */
    public Line setMargin(int margin){
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
     * @return Line margin
     */
    public Line setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        setMarginLeft(marginLeft);
        setMarginTop(marginTop);
        setMarginRight(marginRight);
        setMarginBottom(marginBottom);
        return this;
    }

    /**
     * Sets padding.
     *
     * @param padding It used to specify extra space on the LEFT, TOP, RIGHT, BOTTOM side's inside the view.
     * @return Line padding
     */
    public Line setPadding(int padding) {
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
     * @return Line padding
     */
    public Line setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        setPaddingLeft(paddingLeft);
        setPaddingTop(paddingTop);
        setPaddingRight(paddingRight);
        setPaddingBottom(paddingBottom);
        return this;
    }

    /**
     * Sets line color.
     *
     * @param lineColor It used to set the color of line.
     * @return Line line color
     */
    public Line setLineColor(int lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    /**
     * Sets line stroke width.
     *
     * @param lineStrokeWidth It used to set the strokeWidth of line.
     * @return Line line stroke width
     */
    public Line setLineStrokeWidth(int lineStrokeWidth) {
        this.lineStrokeWidth = lineStrokeWidth;
        return this;
    }

    /**
     * Gets row span.
     *
     * @return the row span
     */
    public int getRowSpan() {
        return rowSpan;
    }

    /**
     * Gets col span.
     *
     * @return the col span
     */
    public int getColSpan() {
        return colSpan;
    }

    /**
     * Gets margin left.
     *
     * @return the margin left
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
     * Gets line color.
     *
     * @return the line color
     */
    public int getLineColor() {
        return lineColor;
    }

    /**
     * Gets line stroke width.
     *
     * @return the line stroke width
     */
    public int getLineStrokeWidth() {
        return lineStrokeWidth;
    }
}
