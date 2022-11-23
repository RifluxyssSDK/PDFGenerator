package com.android.io;

import com.android.kernel.ElementType;

public class Line extends Element {

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

    int lineColor;
    int lineStrokeWidth;

    @Override
    public byte getElementType() {
        return ElementType.LINE;
    }

    public Line setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    public Line setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    public Line setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public Line setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public Line setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    public Line setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public Line setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public Line setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    public Line setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public Line setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    public Line setLineColor(int lineColor) {
        this.lineColor = lineColor;
        return this;
    }

    public Line setLineStrokeWidth(int lineStrokeWidth) {
        this.lineStrokeWidth = lineStrokeWidth;
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

    public int getLineColor() {
        return lineColor;
    }

    public int getLineStrokeWidth() {
        return lineStrokeWidth;
    }
}
