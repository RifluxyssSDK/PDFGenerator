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

    /**
     * @param pageSize This constructor assign PageSize from the given input. ( EX : A4, A3, etc ).
     */
    public Document(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * This constructor assign Default PageSize ( A4 ) for pdf document.
     */
    public Document() {
        this.pageSize = PageSize.DEFAULT;
    }

    /**
     * @param context This parameter used to creating View.
     * @return
     */
    public Document init(Context context) {
        this.context = context;
        return this;
    }

    /**
     * @param DocType This parameter used to find cell type. ( EX : NORMAL, HEADER, FOOTER )
     * @param cell This parameter contains data for our pdf document.
     */
    public void add(byte DocType, Cell cell) {
        addElement(DocType, cell);
    }

    /**
     * @param cell This parameter contains data for our pdf document.
     */
    public void add(Cell cell) {
        addElement(DocType.NORMAL, cell);
    }

    /**
     * @param docType Store cell on ArrayList based on the DocType.
     * @param cell This parameter contains data for our pdf document.
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
        setPadding(padding,padding,padding,padding);
    }

    /**
     * @param paddingLeft This parameter used to set paddingLeft for every single page.
     * @param paddingTop This parameter used to set paddingTop for every single page.
     * @param paddingRight This parameter used to set paddingRight for every single page.
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

    /**
     * @return This cells used to create Non-Repeated Views.
     */
    public ArrayList<Cell> getCells() {
        return cells;
    }

    /**
     * @return This cells used to create repeated ( HEADER ) Views.
     */
    public ArrayList<Cell> getHeaderCells() {
        return headerCells;
    }

    /**
     * @return This cells used to create repeated ( FOOTER ) Views.
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
     * @param bgImage This parameter used to set BackgroundImage for each page.
     */
    public void setBackgroundImage(BgImage bgImage) {
        this.bgImage = bgImage;
    }

    /**
     * @param pageCount This parameter used to set PageCount for each page.
     */
    public void setPageCount(PageCount pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * This method initiate to create view and pdf document
     */
    public void close() {

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
