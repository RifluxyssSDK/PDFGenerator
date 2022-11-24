package android.pdf.core;

import android.content.Context;

import android.pdf.custom.Dimension;
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

    private CreateStatic staticHeader;
    private CreateStatic staticFooter;
    private CreateContainer container;

    /**
     * Init.
     *
     * @param document the document
     */
    public void init(Document document) {

        initDimension(document.context);

        initPageSize(document);

        initStaticLayout(document);

        initPageCount(document);

        initContainer(document);

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
    private void initDimension(Context context) {

        if (context == null) {

            throw new Error("You been must call 'init' method to initialize library. or Null Context");

        } else {

            new Dimension(context);

        }

    }

    /**
     * It used to calculate actual size for main content.
     *
     * @param document {@link Document}
     */
    private void initPageSize(Document document) {

        int paddingWidth = document.paddingLeft + document.paddingRight;
        int paddingHeight = document.paddingTop + document.paddingBottom;

        PageSize pageSize = document.pageSize;
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
