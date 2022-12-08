package android.pdf.core;

import android.content.Context;
import android.pdf.io.Cell;
import android.pdf.bgImage.BgImage;
import android.pdf.constant.DocType;
import android.pdf.constant.PageSize;
import android.pdf.io.PageCount;

import java.io.File;
import java.io.IOException;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Document {

    private final Instance instance = Instance.createInstance();

    private final PdfGenerateFactory pdfGenerateFactory = new PdfGenerateFactory();

    public Document(PageSize pageSize) {
        instance.setPageSize(pageSize);
    }

    public Document() {
        instance.setPageSize(PageSize.DEFAULT);
    }

    public Document init(Context context) {
        instance.setContext(context);
        return this;
    }

    public void add(byte DocType, Cell cell) {
        addElement(DocType, cell);
    }

    public void add(Cell cell) {
        addElement(DocType.NORMAL, cell);
    }

    public void setPadding(int padding) {
        setPadding(padding, padding, padding, padding);
    }

    public void setPageCount(PageCount pageCount) {
        instance.setPageCount(pageCount);
    }

    public void open(int columnWeight) {
        instance.setColumnWeight(columnWeight);
    }

    public void setBackgroundImage(BgImage bgImage) {
        instance.setBgImage(bgImage);
    }

    private void addElement(byte docType, Cell cell) {
        if (docType == DocType.NORMAL) {
            instance.getCells().add(cell);
        } else if (docType == DocType.HEADER) {
            instance.getHeaderCells().add(cell);
        } else if (docType == DocType.FOOTER) {
            instance.getFooterCells().add(cell);
        }
    }

    public void setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        instance.setPaddingLeft(paddingLeft);
        instance.setPaddingTop(paddingTop);
        instance.setPaddingRight(paddingRight);
        instance.setPaddingBottom(paddingBottom);
    }

    public void close() {
        if (authorization()) {
            pdfGenerateFactory.initialize();
        }
    }

    private boolean authorization() {
        if (instance.getColumnWeight() == 0) {
            throw new Error("You been must open the Document");
        } else if (instance.getContext() == null) {
            throw new Error("You been must call 'init' method to initialize library (or) Null Context");
        } else {
            return true;
        }
    }

    public void finish(File file) throws IOException {
        pdfGenerateFactory.finish(file);
        pdfGenerateFactory.terminate();
    }
}
