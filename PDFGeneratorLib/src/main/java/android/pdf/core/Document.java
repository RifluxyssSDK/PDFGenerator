package android.pdf.core;

import android.content.Context;
import android.pdf.bgImage.BgImage;
import android.pdf.constant.DocType;
import android.pdf.constant.PageSize;
import android.pdf.exception.Authorization;
import android.pdf.io.Cell;
import android.pdf.io.PageCount;

import java.io.File;
import java.io.IOException;

/**
 * The type Document.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Document {

    private final Instance instance = Instance.createInstance();
    private final PdfGenerateFactory pdfGenerateFactory = new PdfGenerateFactory();

    /**
     * Instantiates a new Document.
     *
     * @param pageSize the page size
     */
    public Document(PageSize pageSize) {
        instance.setPageSize(pageSize);
    }

    /**
     * Instantiates a new Document.
     */
    public Document() {
        instance.setPageSize(PageSize.DEFAULT);
    }

    /**
     * Init document.
     *
     * @param context the context
     * @return the document
     */
    public Document init(Context context) {
        instance.setContext(context);
        return this;
    }

    /**
     * Add.
     *
     * @param DocType the doc type
     * @param cell    the cell
     */
    public void add(byte DocType, Cell cell) {
        addElement(DocType, cell);
    }

    /**
     * Add.
     *
     * @param cell the cell
     */
    public void add(Cell cell) {
        addElement(DocType.NORMAL, cell);
    }

    /**
     * Sets padding.
     *
     * @param padding the padding
     */
    public void setPadding(int padding) {
        setPadding(padding, padding, padding, padding);
    }

    /**
     * Sets page count.
     *
     * @param pageCount the page count
     */
    public void setPageCount(PageCount pageCount) {
        instance.setPageCount(pageCount);
    }

    /**
     * Open.
     *
     * @param columnWeight the column weight
     */
    public void open(int columnWeight) {
        instance.setColumnWeight(columnWeight);
    }

    /**
     * Sets background image.
     *
     * @param bgImage the bg image
     */
    public void setBackgroundImage(BgImage bgImage) {
        instance.setBgImage(bgImage);
    }

    private void addElement(byte docType, Cell cell) {
        if (Authorization.documentAuthenticate()) {
            if (docType == DocType.NORMAL) {
                instance.getCells().add(cell);
            } else if (docType == DocType.HEADER) {
                instance.getHeaderCells().add(cell);
            } else if (docType == DocType.FOOTER) {
                instance.getFooterCells().add(cell);
            }
        }
    }

    /**
     * Sets padding.
     *
     * @param paddingLeft   the padding left
     * @param paddingTop    the padding top
     * @param paddingRight  the padding right
     * @param paddingBottom the padding bottom
     */
    public void setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        instance.setPaddingLeft(paddingLeft);
        instance.setPaddingTop(paddingTop);
        instance.setPaddingRight(paddingRight);
        instance.setPaddingBottom(paddingBottom);
    }

    /**
     * Close.
     */
    public void close() {
        if (Authorization.documentAuthenticate()) {
            pdfGenerateFactory.initialize();
        }
    }

    /**
     * Finish.
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public void finish(File file) throws IOException {
        if (Authorization.documentCloseAuthenticate()) {
            pdfGenerateFactory.finish(file);
            pdfGenerateFactory.terminate();
        }
    }
}
