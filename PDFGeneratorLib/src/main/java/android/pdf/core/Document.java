package android.pdf.core;

import android.content.Context;

import android.pdf.bgImage.BgImage;
import android.pdf.io.Cell;
import android.pdf.io.PageCount;
import android.pdf.kernel.DocType;
import android.pdf.kernel.PageSize;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Document {

    /**
     * It used to create document on custom size. ( Ex : A4, A3 , etc.. ) {@link PageSize}.
     */
    final PageSize pageSize;
    /**
     * It used to store the Cell to create Non-repeated View's {@link Cell}.
     */
    final ArrayList<Cell> cells = new ArrayList<>();
    /**
     * It used to store the Cell to create repeated ( HEADER ) View's {@link Cell}.
     */
    final ArrayList<Cell> headerCells = new ArrayList<>();
    /**
     * It used to store the Cell to create repeated ( FOOTER ) View's {@link Cell}.
     */
    final ArrayList<Cell> footerCells = new ArrayList<>();
    /**
     * This class used to create View.
     */
    private final PdfGenerateFactory pdfGenerateFactory = new PdfGenerateFactory();
    /**
     * It used to creating View.
     */
    Context context;
    /**
     * It used to set paddingLeft for every single page.
     */
    int paddingLeft;
    /**
     * It used to set paddingTop for every single page.
     */
    int paddingTop;
    /**
     * It used to set paddingRight for every single page.
     */
    int paddingRight;
    /**
     * It used to set paddingBottom for every single page.
     */
    int paddingBottom;
    /**
     * It used to set weight of single column.
     */
    int columnWeight;
    /**
     * It used to set BackgroundImage for each page.
     */
    BgImage bgImage;
    /**
     * It used to set PageCount for each page.
     */
    PageCount pageCount;

    /**
     * @param pageSize This constructor assign PageSize from the given input. ( EX : A4, A3, etc ) {@link PageSize}.
     */
    public Document(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * This constructor assign Default PageSize ( A4 ) for pdf document {@link PageSize}.
     */
    public Document() {
        this.pageSize = PageSize.DEFAULT;
    }

    /**
     * @param context This parameter used to creating View.
     * @return Document
     */
    public Document init(Context context) {
        this.context = context;
        return this;
    }

    /**
     * @param DocType This parameter used to find cell type. ( EX : NORMAL, HEADER, FOOTER ) {@link DocType} {@link Cell}.
     * @param cell    This parameter contains data for our pdf document.
     */
    public void add(byte DocType, Cell cell) {
        addElement(DocType, cell);
    }

    /**
     * @param cell This parameter contains data for our pdf document {@link DocType} {@link Cell}.
     */
    public void add(Cell cell) {
        addElement(DocType.NORMAL, cell);
    }

    /**
     * @param docType Store cell on ArrayList based on the DocType {@link DocType}.
     * @param cell    This parameter contains data for our pdf document.
     */
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

    /**
     * @param padding This parameter used to set padding for every single page.
     */
    public void setPadding(int padding) {
        setPadding(padding, padding, padding, padding);
    }

    /**
     * @param paddingLeft   This parameter used to set paddingLeft for every single page.
     * @param paddingTop    This parameter used to set paddingTop for every single page.
     * @param paddingRight  This parameter used to set paddingRight for every single page.
     * @param paddingBottom This parameter used to set paddingBottom for every single page.
     */
    public void setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.paddingRight = paddingRight;
        this.paddingBottom = paddingBottom;
    }

    /**
     * @return This context used on hole library to create View.
     */
    public Context getContext() {
        return context;
    }

    /**
     * @return paddingLeft
     */
    public int getPaddingLeft() {
        return paddingLeft;
    }

    /**
     * @return paddingTop
     */
    public int getPaddingTop() {
        return paddingTop;
    }

    /**
     * @return paddingRight
     */
    public int getPaddingRight() {
        return paddingRight;
    }

    /**
     * @return paddingBottom
     */
    public int getPaddingBottom() {
        return paddingBottom;
    }

    /**
     * @return columnWeight
     */
    public int getColumnWeight() {
        return columnWeight;
    }

    /**
     * @return bgImage {@link BgImage}
     */
    public BgImage getBgImage() {
        return bgImage;
    }

    /**
     * @return pageCount
     */
    public PageCount getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount This parameter used to set PageCount for each page {@link PageCount}.
     */
    public void setPageCount(PageCount pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return pageSize {@link PageSize}
     */
    public PageSize getPageSize() {
        return pageSize;
    }

    /**
     * @return This cells used to create Non-Repeated Views {@link Cell}.
     */
    public ArrayList<Cell> getCells() {
        return cells;
    }

    /**
     * @return This cells used to create repeated ( HEADER ) Views {@link Cell}.
     */
    public ArrayList<Cell> getHeaderCells() {
        return headerCells;
    }

    /**
     * @return This cells used to create repeated ( FOOTER ) Views {@link Cell}.
     */
    public ArrayList<Cell> getFooterCells() {
        return footerCells;
    }

    /**
     * @param columnWeight This parameter used to set weight of single column.
     */
    public void open(int columnWeight) {
        this.columnWeight = columnWeight;
    }

    /**
     * @param bgImage This parameter used to set BackgroundImage for each page {@link BgImage}.
     */
    public void setBackgroundImage(BgImage bgImage) {
        this.bgImage = bgImage;
    }

    /**
     * This method initiate to create view and pdf document
     */
    public void close() {

        if (context == null) {
            throw new Error("You been must call 'init' method to initialize library.");
        }

        if (columnWeight == 0) {
            throw new Error("You been must open the Document");
        }

        pdfGenerateFactory.init((this));

    }

    /**
     * @param file This parameter used to store pdf on local storage.
     * @throws IOException Exception throws by FileOutputStream.
     */
    public void finish(File file) throws IOException {

        pdfGenerateFactory.finish(file);

    }

}
