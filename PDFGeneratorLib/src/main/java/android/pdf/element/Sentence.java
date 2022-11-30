package android.pdf.element;

import android.graphics.Color;

import android.pdf.abstract_io.Element;
import android.pdf.constant.ElementType;

import java.util.ArrayList;

/**
 * The type Sentence.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Sentence extends Element {

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
     * Instantiates a new Sentence.
     */
    public Sentence(int rowSpan, int colSpan) {
        setBorderWidth(1);
        setRowSpan(rowSpan);
        setColSpan(colSpan);
        setBorderColor(Color.BLACK);
    }

    /**
     * Sets row span.
     *
     * @param rowSpan the row span
     * @return the row span
     */
    public Sentence setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    /**
     * Sets col span.
     *
     * @param colSpan the col span
     * @return the col span
     */
    public Sentence setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    /**
     * Sets margin left.
     *
     * @param marginLeft the margin left
     * @return the margin left
     */
    public Sentence setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * Sets margin top.
     *
     * @param marginTop the margin top
     * @return the margin top
     */
    public Sentence setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * Sets margin right.
     *
     * @param marginRight the margin right
     * @return the margin right
     */
    public Sentence setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * Sets margin bottom.
     *
     * @param marginBottom the margin bottom
     * @return the margin bottom
     */
    public Sentence setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * Sets padding left.
     *
     * @param paddingLeft the padding left
     * @return the padding left
     */
    public Sentence setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * Sets padding top.
     *
     * @param paddingTop the padding top
     * @return the padding top
     */
    public Sentence setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * Sets padding right.
     *
     * @param paddingRight the padding right
     * @return the padding right
     */
    public Sentence setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * Sets padding bottom.
     *
     * @param paddingBottom the padding bottom
     * @return the padding bottom
     */
    public Sentence setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * Sets border.
     *
     * @param border the border
     * @return the border
     */
    public Sentence setBorder(boolean border) {
        this.border = border;
        return this;
    }

    /**
     * Sets border width.
     *
     * @param borderWidth the border width
     * @return the border width
     */
    public Sentence setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Sets border color.
     *
     * @param borderColor the border color
     * @return the border color
     */
    public Sentence setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Sets background color.
     *
     * @param backgroundColor the background color
     * @return the background color
     */
    public Sentence setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Sets padding.
     *
     * @param padding the padding
     * @return the padding
     */
    public Sentence setPadding(int padding) {
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
    public Sentence setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
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
    public Sentence setMargin(int margin) {
        setMarginLeft(margin);
        setMarginTop(margin);
        setMarginRight(margin);
        setMarginBottom(margin);
        return this;
    }

    /**
     * Add Sentence.
     *
     * @param element the element {@link Element}
     * @return the Sentence
     */
    public Sentence add(Element element) {
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

    /**
     * Clear.
     */
    public void clear() {
        elements.clear();
    }

    /**
     * @return byte {@link ElementType}
     */
    @Override
    public byte getElementType() {
        return ElementType.SENTENCE;
    }
}
