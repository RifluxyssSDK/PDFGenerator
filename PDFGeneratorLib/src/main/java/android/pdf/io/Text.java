package android.pdf.io;

import android.graphics.Color;

import android.pdf.customtext.TextBuilder;
import android.pdf.kernel.ElementType;

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

    public Text(String message) {
        setRowSpan(1);
        setColSpan(1);
        setTextSize(7);
        setBorderWidth(1);
        setMessage(message);
        setTextColor(Color.BLACK);
        setBorderColor(Color.BLACK);
    }

    public Text(int rowSpan, int colSpan, String message) {
        setRowSpan(rowSpan);
        setColSpan(colSpan);
        setMessage(message);
        init();
    }

    public Text(int rowSpan, int colSpan, TextBuilder TextBuilder) {
        setRowSpan(rowSpan);
        setColSpan(colSpan);
        setTextBuilder(TextBuilder);
        init();
    }

    private void init(){
        setTextSize(7);
        setBorderWidth(1);
        setTextColor(Color.BLACK);
        setBorderColor(Color.BLACK);
    }

    @Override
    public byte getElementType() {
        return ElementType.TEXT;
    }

    public Text setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    public Text setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    public Text setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public Text setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public Text setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    public Text setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public Text setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public Text setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    public Text setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public Text setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    public Text setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public Text setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public Text setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public Text setFontStyle(byte fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    public Text setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Text setBorder(boolean border) {
        this.border = border;
        return this;
    }

    public Text setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public Text setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public Text setMessage(String message) {
        this.message = message;
        return this;
    }

    public Text setPadding(int padding) {
        setPaddingLeft(padding);
        setPaddingTop(padding);
        setPaddingRight(padding);
        setPaddingBottom(padding);
        return this;
    }

    public Text setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        setPaddingLeft(paddingLeft);
        setPaddingTop(paddingTop);
        setPaddingRight(paddingRight);
        setPaddingBottom(paddingBottom);
        return this;
    }

    public Text setMargin(int margin) {
        setMarginLeft(margin);
        setMarginTop(margin);
        setMarginRight(margin);
        setMarginBottom(margin);
        return this;
    }

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

    public void setTextBuilder(TextBuilder textBuilder) {
        this.textBuilder = textBuilder;
    }
}
