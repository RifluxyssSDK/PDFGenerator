package android.pdf.cell;

import android.graphics.Color;

import android.pdf.abstract_io.Cell;
import android.pdf.abstract_io.Element;
import android.pdf.constant.ElementType;

import java.util.ArrayList;

/**
 * The type Paragraph.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Paragraph extends Cell {

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
     * The Elements.
     */
    final ArrayList<Element> elements = new ArrayList<>();

    /**
     * Instantiates a new Paragraph.
     */
    public Paragraph() {
        setBorderWidth(1);
        setBorderColor(Color.BLACK);
    }

    @Override
    public byte getCellType() {
        return ElementType.PARAGRAPH;
    }

    /**
     * Sets row span.
     *
     * @param rowSpan the row span
     * @return the row span
     */
    public Paragraph setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    /**
     * Sets col span.
     *
     * @param colSpan the col span
     * @return the col span
     */
    public Paragraph setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    /**
     * Sets margin left.
     *
     * @param marginLeft the margin left
     * @return the margin left
     */
    public Paragraph setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * Sets margin top.
     *
     * @param marginTop the margin top
     * @return the margin top
     */
    public Paragraph setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * Sets margin right.
     *
     * @param marginRight the margin right
     * @return the margin right
     */
    public Paragraph setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * Sets margin bottom.
     *
     * @param marginBottom the margin bottom
     * @return the margin bottom
     */
    public Paragraph setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * Sets padding left.
     *
     * @param paddingLeft the padding left
     * @return the padding left
     */
    public Paragraph setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * Sets padding top.
     *
     * @param paddingTop the padding top
     * @return the padding top
     */
    public Paragraph setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * Sets padding right.
     *
     * @param paddingRight the padding right
     * @return the padding right
     */
    public Paragraph setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * Sets padding bottom.
     *
     * @param paddingBottom the padding bottom
     * @return the padding bottom
     */
    public Paragraph setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * Sets border.
     *
     * @param border the border
     * @return the border
     */
    public Paragraph setBorder(boolean border) {
        this.border = border;
        return this;
    }

    /**
     * Sets border width.
     *
     * @param borderWidth the border width
     * @return the border width
     */
    public Paragraph setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Sets border color.
     *
     * @param borderColor the border color
     * @return the border color
     */
    public Paragraph setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Sets background color.
     *
     * @param backgroundColor the background color
     * @return the background color
     */
    public Paragraph setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Sets padding.
     *
     * @param padding the padding
     * @return the padding
     */
    public Paragraph setPadding(int padding) {
        setPaddingLeft(padding);
        setPaddingTop(padding);
        setPaddingRight(padding);
        setPaddingBottom(padding);
        return this;
    }

    /**
     * Sets padding.
     *
     * @param paddingLeft   the padding left
     * @param paddingTop    the padding top
     * @param paddingRight  the padding right
     * @param paddingBottom the padding bottom
     * @return the padding
     */
    public Paragraph setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        setPaddingLeft(paddingLeft);
        setPaddingTop(paddingTop);
        setPaddingRight(paddingRight);
        setPaddingBottom(paddingBottom);
        return this;
    }

    /**
     * Sets margin.
     *
     * @param margin the margin
     * @return the margin
     */
    public Paragraph setMargin(int margin) {
        setMarginLeft(margin);
        setMarginTop(margin);
        setMarginRight(margin);
        setMarginBottom(margin);
        return this;
    }

    /**
     * Add paragraph.
     *
     * @param element the element {@link Element}
     * @return the paragraph
     */
    public Paragraph add(Element element) {
        elements.add(element);
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
     * Gets elements.
     *
     * @return the elements {@link Element}
     */
    public ArrayList<Element> getElements() {
        return elements;
    }
}
