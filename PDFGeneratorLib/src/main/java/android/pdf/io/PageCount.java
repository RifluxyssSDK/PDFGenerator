package android.pdf.io;

import android.graphics.Color;

/**
 * The type Page count.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PageCount {

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
     * The Text size.
     */
    int textSize;
    /**
     * The Text color.
     */
    int textColor;
    /**
     * The Background color.
     */
    int backgroundColor;

    /**
     * The Gravity.
     */
    int gravity;
    /**
     * The Border color.
     */
    int borderColor;
    /**
     * The Border width.
     */
    int borderWidth;

    /**
     * The Border.
     */
    boolean border;
    /**
     * The Start message.
     */
    String startMessage;
    /**
     * The Middle message.
     */
    String middleMessage;

    /**
     * The Font style.
     */
    byte fontStyle;
    /**
     * The Line spacing.
     */
    float lineSpacing;

    /**
     * The Total page count.
     */
    int totalPageCount;

    /**
     * Instantiates a new Page count.
     *
     * @param startMessage  This string used to create pageCount on pdf document.
     * @param middleMessage This string used to create pageCount on pdf document.
     */
    public PageCount(String startMessage, String middleMessage) {
        setTextSize(6);
        setBorderWidth(1);
        setTextColor(Color.BLACK);
        setBorderColor(Color.BLACK);
        setStartMessage(startMessage);
        setMiddleMessage(middleMessage);
    }

    /**
     * Sets margin left.
     *
     * @param marginLeft It specifies extra space on the LEFT side of the view.
     * @return margin left
     */
    public PageCount setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * Sets margin top.
     *
     * @param marginTop It specifies extra space on the TOP side of the view.
     * @return margin top
     */
    public PageCount setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * Sets margin right.
     *
     * @param marginRight It specifies extra space on the RIGHT side of the view.
     * @return margin right
     */
    public PageCount setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * Sets margin bottom.
     *
     * @param marginBottom It specifies extra space on the BOTTOM side of the view.
     * @return margin bottom
     */
    public PageCount setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * Sets padding left.
     *
     * @param paddingLeft It used to specify extra space on the LEFT Side inside the view.
     * @return padding left
     */
    public PageCount setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * Sets padding top.
     *
     * @param paddingTop It used to specify extra space on the TOP Side inside the view.
     * @return padding top
     */
    public PageCount setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * Sets padding right.
     *
     * @param paddingRight It used to specify extra space on the RIGHT Side inside the view.
     * @return padding right
     */
    public PageCount setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * Sets padding bottom.
     *
     * @param paddingBottom It used to specify extra space on the BOTTOM Side inside the view.
     * @return padding bottom
     */
    public PageCount setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * Sets text size.
     *
     * @param textSize It used to set the size of text.
     * @return text size
     */
    public PageCount setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * Sets text color.
     *
     * @param textColor It used to set the color of text.
     * @return text color
     */
    public PageCount setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * Sets background color.
     *
     * @param backgroundColor It used to set the background of text.
     * @return background color
     */
    public PageCount setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Sets gravity.
     *
     * @param gravity It used to set the gravity of text. ( EX : "Gravity.CENTER", "Gravity.CENTER | Gravity.CENTER_VERTICAL" )
     * @return gravity
     */
    public PageCount setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * Sets border color.
     *
     * @param borderColor It used to set the color of text border.
     * @return border color
     */
    public PageCount setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Sets border width.
     *
     * @param borderWidth It used to set the strokeWidth of text border.
     * @return border width
     */
    public PageCount setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Sets border.
     *
     * @param border It used to set the border of text.
     * @return border
     */
    public PageCount setBorder(boolean border) {
        this.border = border;
        return this;
    }

    /**
     * Sets start message.
     *
     * @param startMessage It used to set the startMessage of pageCount view.
     * @return start message
     */
    public PageCount setStartMessage(String startMessage) {
        this.startMessage = startMessage;
        return this;
    }

    /**
     * Sets middle message.
     *
     * @param middleMessage It used to set the middleMessage of pageCount view.
     * @return middle message
     */
    public PageCount setMiddleMessage(String middleMessage) {
        this.middleMessage = middleMessage;
        return this;
    }

    /**
     * Sets font style.
     *
     * @param fontStyle It used to set the fontStyle of text.
     * @return font style
     */
    public PageCount setFontStyle(byte fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    /**
     * Sets line spacing.
     *
     * @param lineSpacing It used to set the lineSpacing of text.
     * @return line spacing
     */
    public PageCount setLineSpacing(float lineSpacing) {
        this.lineSpacing = lineSpacing;
        return this;
    }

    /**
     * Sets total page count.
     *
     * @param totalPageCount automatically calculated by document size...
     * @return total page count
     */
    public PageCount setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
        return this;
    }

    /**
     * Sets padding.
     *
     * @param padding It used to specify extra space on the LEFT, TOP, RIGHT, BOTTOM side's inside the view.
     * @return padding
     */
    public PageCount setPadding(int padding) {
        setPaddingLeft(padding);
        setPaddingTop(padding);
        setPaddingRight(padding);
        setPaddingBottom(padding);
        return this;
    }

    /**
     * Sets margin.
     *
     * @param margin It specifies extra space on the LEFT, TOP, RIGHT, BOTTOM side's of the view.
     * @return margin
     */
    public PageCount setMargin(int margin) {
        setMarginLeft(margin);
        setMarginTop(margin);
        setMarginRight(margin);
        setMarginBottom(margin);
        return this;
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
     * Gets text size.
     *
     * @return the text size
     */
    public int getTextSize() {
        return textSize;
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
     * Gets background color.
     *
     * @return the background color
     */
    public int getBackgroundColor() {
        return backgroundColor;
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
     * Gets border color.
     *
     * @return the border color
     */
    public int getBorderColor() {
        return borderColor;
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
     * Is border boolean.
     *
     * @return the boolean
     */
    public boolean isBorder() {
        return border;
    }

    /**
     * Gets start message.
     *
     * @return the start message
     */
    public String getStartMessage() {
        return startMessage;
    }

    /**
     * Gets middle message.
     *
     * @return the middle message
     */
    public String getMiddleMessage() {
        return middleMessage;
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
     * Gets line spacing.
     *
     * @return the line spacing
     */
    public float getLineSpacing() {
        return lineSpacing;
    }

    /**
     * Gets total page count.
     *
     * @return the total page count
     */
    public int getTotalPageCount() {
        return totalPageCount;
    }
}
