package android.pdf.io;

import android.graphics.Color;

import android.pdf.customtext.TextBuilder;
import android.pdf.kernel.ElementType;

/**
 * This class used to create each text for pdf document.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Text extends Element {

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

    int gravity;
    int textColor;
    int textSize;
    byte fontStyle;
    int backgroundColor;

    boolean border;
    int borderWidth;
    int borderColor;

    String message;
    TextBuilder textBuilder;

    /**
     * @param rowSpan It represents the number of rows to span.
     * @param colSpan It represents the number of columns to span.
     * @param message It used to create text for pdf document.
     */
    public Text(int rowSpan, int colSpan, String message) {
        setRowSpan(rowSpan);
        setColSpan(colSpan);
        setMessage(message);
        init();
    }

    /**
     * @param rowSpan It represents the number of rows to span.
     * @param colSpan It represents the number of columns to span.
     * @param TextBuilder It used to create text for pdf document.
     */
    public Text(int rowSpan, int colSpan, TextBuilder TextBuilder) {
        setRowSpan(rowSpan);
        setColSpan(colSpan);
        setTextBuilder(TextBuilder);
        init();
    }

    /**
     * Add sum default value's.
     */
    private void init(){
        setTextSize(7);
        setBorderWidth(1);
        setTextColor(Color.BLACK);
        setBorderColor(Color.BLACK);
    }

    /**
     * @return Text It used to find the type of Element's
     */
    @Override
    public byte getElementType() {
        return ElementType.TEXT;
    }

    /**
     * @param rowSpan It represents the number of rows to span.
     * @return Text
     */
    public Text setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    /**
     * @param colSpan It represents the number of rows to span.
     * @return Text
     */
    public Text setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    /**
     * @param marginLeft It specifies extra space on the LEFT side of the view.
     * @return Text
     */
    public Text setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * @param marginTop It specifies extra space on the TOP side of the view.
     * @return Text
     */
    public Text setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * @param marginRight It specifies extra space on the Right side of the view.
     * @return Text
     */
    public Text setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * @param marginBottom It specifies extra space on the BOTTOM side of the view.
     * @return Text
     */
    public Text setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * @param paddingLeft It used to specify extra space on the LEFT Side inside the view.
     * @return Text
     */
    public Text setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * @param paddingTop It used to specify extra space on the TOP Side inside the view.
     * @return Text
     */
    public Text setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * @param paddingRight It used to specify extra space on the RIGHT Side inside the view.
     * @return Text
     */
    public Text setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * @param paddingBottom It used to specify extra space on the BOTTOM Side inside the view.
     * @return Text
     */
    public Text setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * @param gravity It used to set the gravity of text. ( EX : "Gravity.CENTER", "Gravity.CENTER | Gravity.CENTER_VERTICAL" )
     * @return Text
     */
    public Text setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * @param textColor It used to set the color of text.
     * @return Text
     */
    public Text setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * @param textSize It used to set the size of text.
     * @return Text
     */
    public Text setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * @param fontStyle It used to set the fontStyle of text.
     * @return Text
     */
    public Text setFontStyle(byte fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    /**
     * @param backgroundColor It used to set the background of text.
     * @return Text
     */
    public Text setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * @param border It used to set the border of text.
     * @return Text
     */
    public Text setBorder(boolean border) {
        this.border = border;
        return this;
    }

    /**
     * @param borderWidth It used to set the strokeWidth of text border.
     * @return Text
     */
    public Text setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * @param borderColor It used to set the color of text border.
     * @return Text
     */
    public Text setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * @param message It used to create text for pdf document.
     * @return Text
     */
    public Text setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * @param padding It used to specify extra space on the LEFT, TOP, RIGHT, BOTTOM side's inside the view.
     * @return Text
     */
    public Text setPadding(int padding) {
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
    public Text setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        setPaddingLeft(paddingLeft);
        setPaddingTop(paddingTop);
        setPaddingRight(paddingRight);
        setPaddingBottom(paddingBottom);
        return this;
    }

    /**
     * @param margin It specifies extra space on the LEFT, TOP, RIGHT, BOTTOM side's of the view.
     * @return Text
     */
    public Text setMargin(int margin) {
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
    public Text setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        setMarginLeft(marginLeft);
        setMarginTop(marginTop);
        setMarginRight(marginRight);
        setMarginBottom(marginBottom);
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

    public int getGravity() {
        return gravity;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getTextSize() {
        return textSize;
    }

    public byte getFontStyle() {
        return fontStyle;
    }

    public int getBackgroundColor() {
        return backgroundColor;
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

    public String getMessage() {
        return message;
    }

    public TextBuilder getTextBuilder() {
        return textBuilder;
    }

    /**
     * @param textBuilder It used to create text for pdf document.
     */
    public void setTextBuilder(TextBuilder textBuilder) {
        this.textBuilder = textBuilder;
    }
}
