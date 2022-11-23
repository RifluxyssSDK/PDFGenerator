package com.android.io;

import android.graphics.Color;

import com.android.kernel.ElementType;

import java.util.ArrayList;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Paragraph extends Cell {

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

    boolean border;
    int borderWidth;
    int borderColor;
    int backgroundColor;

    final ArrayList<Element> elements = new ArrayList<>();

    public Paragraph() {
        setBorderWidth(1);
        setBorderColor(Color.BLACK);
    }

    @Override
    public byte getCellType() {
        return ElementType.PARAGRAPH;
    }

    public Paragraph setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    public Paragraph setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    public Paragraph setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    public Paragraph setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    public Paragraph setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    public Paragraph setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    public Paragraph setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public Paragraph setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    public Paragraph setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public Paragraph setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    public Paragraph setBorder(boolean border) {
        this.border = border;
        return this;
    }

    public Paragraph setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public Paragraph setBorderColor(int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public Paragraph setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Paragraph setPadding(int padding) {
        setPaddingLeft(padding);
        setPaddingTop(padding);
        setPaddingRight(padding);
        setPaddingBottom(padding);
        return this;
    }

    public Paragraph setMargin(int margin) {
        setMarginLeft(margin);
        setMarginTop(margin);
        setMarginRight(margin);
        setMarginBottom(margin);
        return this;
    }

    public Paragraph add(Element element) {
        elements.add(element);
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

    public boolean isBorder() {
        return border;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void clear() {
        elements.clear();
    }
}
