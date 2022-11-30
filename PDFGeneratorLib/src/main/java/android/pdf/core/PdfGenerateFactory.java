package android.pdf.core;

import android.pdf.dimension.Dimension;
import android.pdf.io.PageCount;
import android.pdf.kernel.PageSize;
import android.pdf.layout.CreateContainer;
import android.pdf.layout.CreateStatic;

import java.io.File;
import java.io.IOException;

/**
 * The type Pdf generate factory.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PdfGenerateFactory {

    private Dimension dimension;
    private CreateStatic staticHeader;
    private CreateStatic staticFooter;
    private CreateContainer container;

    /**
     * Init.
     *
     * @param document the document
     */
    public void init(Document document) {

        initCustomDimension(document);

        initPageSize(document);

        initStaticLayout(document);

        initPageCount(document);

        initContainer(document);

        initDefaultDimension();
    }

    /**
     * It used to create Non-repeated View's
     *
     * @param document {@link Document}
     */
    private void initContainer(Document document) {

        container = new CreateContainer(document, staticHeader.create(), staticFooter.create());

        container.create();

    }

    /**
     * Calculate no of pages
     *
     * @param document {@link Document}
     */
    private void initPageCount(Document document) {

        PageCount pageCount = document.getPageCount();

        if (pageCount != null) {

            CreateContainer calculatePageCount = new CreateContainer(document, staticHeader.create(), staticFooter.create());

            pageCount.setTotalPageCount(calculatePageCount.create().getPageCount());

        }
    }

    /**
     * Create repeated View ( HEADER & FOOTER ).
     *
     * @param document {@link Document}
     */
    private void initStaticLayout(Document document) {

        staticHeader = new CreateStatic(document.getContext(), document.getHeaderCells(), document.getPageSize(), document.getColumnWeight());

        staticFooter = new CreateStatic(document.getContext(), document.getFooterCells(), document.getPageSize(), document.getColumnWeight());

    }

    /**
     * initDimension {@link Dimension}
     */
    private void initCustomDimension(Document document) {

        dimension = new Dimension(document);

        dimension.init();

    }

    /**
     * initDefaultDimension {@link Dimension}
     */
    private void initDefaultDimension() {

        dimension.setDefault();

    }

    /**
     * It used to calculate actual size for main content.
     *
     * @param document {@link Document}
     */
    private void initPageSize(Document document) {

        int paddingWidth = document.getPaddingLeft() + document.getPaddingRight();
        int paddingHeight = document.getPaddingTop() + document.getPaddingBottom();

        PageSize pageSize = document.getPageSize();
        pageSize.decreasePadding(paddingWidth, paddingHeight);

    }

    /**
     * Finish.
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public void finish(File file) throws IOException {

        container.finish(file);

    }
}
