package com.pdf.model;


import android.graphics.Color;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PageCounterModel {

    String start;
    String middle;

    int pageCount;
    int marginLeft,
    marginTop,
    marginRight,
    marginBottom;
    int paddingLeft,
    paddingTop,
    paddingRight,
    paddingBottom;
    int textSize,
    fontStyle,
    textColor,
    backgroundColor,
    gravity,
    borderWidth,
    borderColor;

    boolean border;

    public PageCounterModel(String start, String middle) {
        this.start = start;
        this.middle = middle;

        setTextSize(6);
        setBorderWidth(1);
        setTextColor(Color.BLACK);

    }

    public PageCounterModel setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.paddingRight = paddingRight;
        this.paddingBottom = paddingBottom;
        return this;
    }

    public PageCounterModel setPadding(int padding) {
        this.paddingLeft = padding;
        this.paddingTop = padding;
        this.paddingRight = padding;
        this.paddingBottom = padding;
        return this;
    }

    public PageCounterModel setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
        return this;
    }

    public PageCounterModel setMargin(int margin) {
        this.marginLeft = margin;
        this.marginTop = margin;
        this.marginRight = margin;
        this.marginBottom = margin;
        return this;
    }

    public int getTextSize() {
        return textSize;
    }

    public PageCounterModel setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public int getFontStyle() {
        return fontStyle;
    }

    public PageCounterModel setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    public int getTextColor() {
        return textColor;
    }

    public PageCounterModel setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public PageCounterModel setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public int getGravity() {
        return gravity;
    }

    public PageCounterModel setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public PageCounterModel setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public PageCounterModel setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public String getStart() {
        return start;
    }

    public PageCounterModel setStart(String start) {
        this.start = start;
        return this;
    }

    public String getMiddle() {
        return middle;
    }

    public PageCounterModel setMiddle(String middle) {
        this.middle = middle;
        return this;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public PageCounterModel setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public PageCounterModel setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public PageCounterModel setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public PageCounterModel setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public PageCounterModel setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public PageCounterModel setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public PageCounterModel setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public PageCounterModel setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isBorder() {
        return border;
    }

    public PageCounterModel setBorder(boolean border) {
        this.border = border;
        return this;
    }
}
