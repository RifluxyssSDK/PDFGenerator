package android.pdf.element;

import android.graphics.Color;

import android.pdf.core.Instance;
import android.pdf.exception.Authorization;
import android.pdf.io.Element;
import android.pdf.customtext.TextBuilder;
import android.pdf.constant.ElementType;

/**
 * The type Text.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Text extends Element {

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
     * The Gravity.
     */
    int gravity;
    /**
     * The Text color.
     */
    int textColor;
    /**
     * The Text size.
     */
    int textSize;
    /**
     * The Font style.
     */
    byte fontStyle;
    /**
     * The Background color.
     */
    int backgroundColor;

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
     * The Line space.
     */
    float lineSpace;

    /**
     * The Message.
     */
    String message;
    /**
     * The Text builder.
     */
    TextBuilder textBuilder;

    /**
     * Instantiates a new Text.
     *
     * @param rowSpan the row span
     * @param colSpan the col span
     * @param message the message
     */
    public Text(int rowSpan, int colSpan, String message) {
        setRowSpan(rowSpan);
        setColSpan(colSpan);
        setMessage(message);
        init();
    }

    private void authorization() {
        Authorization.colSpanAuthenticate(getColSpan());
    }

    /**
     * Instantiates a new Text.
     *
     * @param rowSpan     the row span
     * @param colSpan     the col span
     * @param TextBuilder the text builder
     */
    public Text(int rowSpan, int colSpan, TextBuilder TextBuilder) {
        setRowSpan(rowSpan);
        setColSpan(colSpan);
        setTextBuilder(TextBuilder);
        init();
    }

    private void init(){
        authorization();
        setTextSize(7);
        setLineSpace(1);
        setBorderWidth(1);
        setTextColor(Color.BLACK);
        setBorderColor(Color.BLACK);
    }

    @Override
    public byte getElementType() {
        return ElementType.TEXT;
    }

    /**
     * Sets row span.
     *
     * @param rowSpan the row span
     * @return the row span
     */
    public Text setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    /**
     * Sets col span.
     *
     * @param colSpan the col span
     * @return the col span
     */
    public Text setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    /**
     * Sets margin left.
     *
     * @param marginLeft the margin left
     * @return the margin left
     */
    public Text setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * Sets margin top.
     *
     * @param marginTop the margin top
     * @return the margin top
     */
    public Text setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * Sets margin right.
     *
     * @param marginRight the margin right
     * @return the margin right
     */
    public Text setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * Sets margin bottom.
     *
     * @param marginBottom the margin bottom
     * @return the margin bottom
     */
    public Text setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * Sets padding left.
     *
     * @param paddingLeft the padding left
     * @return the padding left
     */
    public Text setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * Sets padding top.
     *
     * @param paddingTop the padding top
     * @return the padding top
     */
    public Text setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * Sets padding right.
     *
     * @param paddingRight the padding right
     * @return the padding right
     */
    public Text setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * Sets padding bottom.
     *
     * @param paddingBottom the padding bottom
     * @return the padding bottom
     */
    public Text setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * Sets gravity.
     *
     * @param gravity the gravity
     * @return the gravity
     */
    public Text setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * Sets text color.
     *
     * @param textColor the text color
     * @return the text color
     */
    public Text setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * Sets text size.
     *
     * @param textSize the text size
     * @return the text size
     */
    public Text setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * Sets font style.
     *
     * @param fontStyle the font style
     * @return the font style
     */
    public Text setFontStyle(byte fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    /**
     * Sets background color.
     *
     * @param backgroundColor the background color
     * @return the background color
     */
    public Text setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Sets border.
     *
     * @param border the border
     * @return the border
     */
    public Text setBorder(boolean border) {
        this.border = border;
        return this;
    }

    /**
     * Sets border width.
     *
     * @param borderWidth the border width
     * @return the border width
     */
    public Text setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Sets border color.
     *
     * @param borderColor the border color
     * @return the border color
     */
    public Text setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Sets line space.
     *
     * @param lineSpace the line space
     * @return the line space
     */
    public Text setLineSpace(float lineSpace) {
        this.lineSpace = lineSpace;
        return this;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @return the message
     */
    public Text setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Sets padding.
     *
     * @param padding the padding
     * @return the padding
     */
    public Text setPadding(int padding) {
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
    public Text setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
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
    public Text setMargin(int margin) {
        setMarginLeft(margin);
        setMarginTop(margin);
        setMarginRight(margin);
        setMarginBottom(margin);
        return this;
    }

    /**
     * Sets margin.
     *
     * @param marginLeft   the margin left
     * @param marginTop    the margin top
     * @param marginRight  the margin right
     * @param marginBottom the margin bottom
     * @return the margin
     */
    public Text setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        setMarginLeft(marginLeft);
        setMarginTop(marginTop);
        setMarginRight(marginRight);
        setMarginBottom(marginBottom);
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
     * Gets gravity.
     *
     * @return the gravity
     */
    public int getGravity() {
        return gravity;
    }

    /**
     * Gets text color.
     *
     * @return the text color
     */
    public int getTextColor() {
        return textColor;
    }

    /**
     * Gets text size.
     *
     * @return the text size
     */
    public int getTextSize() {
        return textSize;
    }

    /**
     * Gets font style.
     *
     * @return the font style
     */
    public byte getFontStyle() {
        return fontStyle;
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
     * Gets line space.
     *
     * @return the line space
     */
    public float getLineSpace() {
        return lineSpace;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets text builder.
     *
     * @return the text builder
     */
    public TextBuilder getTextBuilder() {
        return textBuilder;
    }

    /**
     * Sets text builder.
     *
     * @param textBuilder the text builder
     */
    public void setTextBuilder(TextBuilder textBuilder) {
        this.textBuilder = textBuilder;
    }
}
