package android.pdf.io;

import android.graphics.Color;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PageCount {

    int marginLeft;
    int marginTop;
    int marginRight;
    int marginBottom;

    int paddingLeft;
    int paddingTop;
    int paddingRight;
    int paddingBottom;

    int textSize;
    int textColor;
    int backgroundColor;
    
    int gravity;
    int borderColor;
    int borderWidth;

    boolean border;
    String startMessage;
    String middleMessage;

    byte fontStyle;
    float lineSpacing;

    int totalPageCount;

    /**
     * @param startMessage This string used to create pageCount on pdf document.
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
     * @param marginLeft It specifies extra space on the LEFT side of the view.
     * @return
     */
    public PageCount setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * @param marginTop It specifies extra space on the TOP side of the view.
     * @return
     */
    public PageCount setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * @param marginRight It specifies extra space on the RIGHT side of the view.
     * @return
     */
    public PageCount setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * @param marginBottom It specifies extra space on the BOTTOM side of the view.
     * @return
     */
    public PageCount setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * @param paddingLeft It used to specify extra space on the LEFT Side inside the view.
     * @return
     */
    public PageCount setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * @param paddingTop It used to specify extra space on the TOP Side inside the view.
     * @return
     */
    public PageCount setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * @param paddingRight It used to specify extra space on the RIGHT Side inside the view.
     * @return
     */
    public PageCount setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * @param paddingBottom It used to specify extra space on the BOTTOM Side inside the view.
     * @return
     */
    public PageCount setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * @param textSize It used to set the size of text.
     * @return
     */
    public PageCount setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * @param textColor It used to set the color of text.
     * @return
     */
    public PageCount setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * @param backgroundColor It used to set the background of text.
     * @return
     */
    public PageCount setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * @param gravity It used to set the gravity of text. ( EX : "Gravity.CENTER", "Gravity.CENTER | Gravity.CENTER_VERTICAL" )
     * @return
     */
    public PageCount setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * @param borderColor It used to set the color of text border.
     * @return
     */
    public PageCount setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * @param borderWidth It used to set the strokeWidth of text border.
     * @return
     */
    public PageCount setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * @param border It used to set the border of text.
     * @return
     */
    public PageCount setBorder(boolean border) {
        this.border = border;
        return this;
    }

    /**
     * @param startMessage It used to set the startMessage of pageCount view.
     * @return
     */
    public PageCount setStartMessage(String startMessage) {
        this.startMessage = startMessage;
        return this;
    }

    /**
     * @param middleMessage It used to set the middleMessage of pageCount view.
     * @return
     */
    public PageCount setMiddleMessage(String middleMessage) {
        this.middleMessage = middleMessage;
        return this;
    }

    /**
     * @param fontStyle It used to set the fontStyle of text.
     * @return
     */
    public PageCount setFontStyle(byte fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    /**
     * @param lineSpacing It used to set the lineSpacing of text.
     * @return
     */
    public PageCount setLineSpacing(float lineSpacing) {
        this.lineSpacing = lineSpacing;
        return this;
    }

    /**
     * @param totalPageCount automatically calculated by document size...
     * @return
     */
    public PageCount setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
        return this;
    }

    /**
     * @param padding It used to specify extra space on the LEFT, TOP, RIGHT, BOTTOM side's inside the view.
     * @return
     */
    public PageCount setPadding(int padding) {
        setPaddingLeft(padding);
        setPaddingTop(padding);
        setPaddingRight(padding);
        setPaddingBottom(padding);
        return this;
    }

    /**
     * @param margin It specifies extra space on the LEFT, TOP, RIGHT, BOTTOM side's of the view.
     * @return
     */
    public PageCount setMargin(int margin) {
        setMarginLeft(margin);
        setMarginTop(margin);
        setMarginRight(margin);
        setMarginBottom(margin);
        return this;
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

    public int getTextSize() {
        return textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getGravity() {
        return gravity;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public boolean isBorder() {
        return border;
    }

    public String getStartMessage() {
        return startMessage;
    }

    public String getMiddleMessage() {
        return middleMessage;
    }

    public byte getFontStyle() {
        return fontStyle;
    }

    public float getLineSpacing() {
        return lineSpacing;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }
}
