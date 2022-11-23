package com.android.core;

import android.content.Context;

import com.android.bgImage.BgImage;
import com.android.io.Cell;
import com.android.io.PageCount;
import com.android.kernel.DocType;
import com.android.kernel.PageSize;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Document {

    Context context;

    int paddingLeft;
    int paddingTop;
    int paddingRight;
    int paddingBottom;

    int columnWeight;

    BgImage bgImage;
    PageCount pageCount;

    final PageSize pageSize;

    final ArrayList<Cell> cells = new ArrayList<>();
    final ArrayList<Cell> headerCells = new ArrayList<>();
    final ArrayList<Cell> footerCells = new ArrayList<>();

    private final PdfGenerateFactory pdfGenerateFactory = new PdfGenerateFactory();

    public Document(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    public Document() {
        this.pageSize = PageSize.DEFAULT;
    }

    public Document init(Context context) {
        this.context = context;
        return this;
    }

    public void add(byte DocType, Cell cell) {
        addElement(DocType, cell);
    }

    public void add(Cell cell) {
        addElement(DocType.NORMAL, cell);
    }

    private void addElement(byte docType, Cell cell) {
        switch (docType) {
            case DocType.NORMAL:
                cells.add(cell);
                break;
            case DocType.HEADER:
                headerCells.add(cell);
                break;
            case DocType.FOOTER:
                footerCells.add(cell);
                break;
        }
    }

    public void setPadding(int padding) {
        setPadding(padding,padding,padding,padding);
    }

    public void setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.paddingRight = paddingRight;
        this.paddingBottom = paddingBottom;
    }

    public Context getContext() {
        return context;
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

    public int getColumnWeight() {
        return columnWeight;
    }

    public BgImage getBgImage() {
        return bgImage;
    }

    public PageCount getPageCount() {
        return pageCount;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public ArrayList<Cell> getHeaderCells() {
        return headerCells;
    }

    public ArrayList<Cell> getFooterCells() {
        return footerCells;
    }

    public void open(int columnWeight) {
        this.columnWeight = columnWeight;
    }

    public void setBackgroundImage(BgImage bgImage) {
        this.bgImage = bgImage;
    }

    public void setPageCount(PageCount pageCount) {
        this.pageCount = pageCount;
    }

    public void close() {

        pdfGenerateFactory.init(this);

    }

    public void finish(File file) throws IOException {

        pdfGenerateFactory.finish(file);

    }

}
