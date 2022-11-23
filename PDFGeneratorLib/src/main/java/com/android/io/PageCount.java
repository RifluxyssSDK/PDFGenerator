package com.android.io;

import android.graphics.Color;

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

    public PageCount(String startMessage, String middleMessage) {
        setTextSize(6);
        setBorderWidth(1);
        setTextColor(Color.BLACK);
        setBorderColor(Color.BLACK);
        setStartMessage(startMessage);
        setMiddleMessage(middleMessage);
    }

    public PageCount setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public PageCount setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public PageCount setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    public PageCount setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public PageCount setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public PageCount setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    public PageCount setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public PageCount setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    public PageCount setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    public PageCount setTextColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    public PageCount setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public PageCount setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public PageCount setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public PageCount setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public PageCount setBorder(boolean border) {
        this.border = border;
        return this;
    }

    public PageCount setStartMessage(String startMessage) {
        this.startMessage = startMessage;
        return this;
    }

    public PageCount setMiddleMessage(String middleMessage) {
        this.middleMessage = middleMessage;
        return this;
    }

    public PageCount setFontStyle(byte fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    public PageCount setLineSpacing(float lineSpacing) {
        this.lineSpacing = lineSpacing;
        return this;
    }

    public PageCount setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
        return this;
    }

    public PageCount setPadding(int padding) {
        setPaddingLeft(padding);
        setPaddingTop(padding);
        setPaddingRight(padding);
        setPaddingBottom(padding);
        return this;
    }

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
