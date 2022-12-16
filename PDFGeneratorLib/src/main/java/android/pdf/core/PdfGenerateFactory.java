package android.pdf.core;

import android.pdf.constant.PageSize;
import android.pdf.dimension.Dimension;
import android.pdf.io.PageCount;
import android.pdf.layout.CreateContainer;
import android.pdf.layout.CreateStatic;

import java.io.File;
import java.io.IOException;

/**
 * The type Pdf generate factory.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PdfGenerateFactory extends Instance {

//    private Instance instance = Instance.getInstance();

    /**
     * Initialize.
     */
    public void initialize() {
        initCustomDimension();
        initPageSize();
        initPageCount();
    }

    /**
     * Terminate.
     */
    public void terminate() {
        initDefaultDimension();
        terminateInstance();
    }

    private void initPageSize() {
        PageSize pageSize = getPageSize();
        pageSize.calculatePageSize();
    }

    private void initCustomDimension() {
        new Dimension().saveDefaultDisplayMetrics();
        new Dimension().setCustomDisplayMetrics();
    }

    private void initPageCount() {
        PageCount pageCount = getPageCount();
        if (pageCount != null) {
            pageCount.setTotalPageCount(
                    new CreateContainer(
                            new CreateStatic().create(getHeaderCells()),
                            new CreateStatic().create(getFooterCells())
                    ).create().getTotalPageCount()
            );
        }
    }

    /**
     * Finish.
     *
     * @param file the file
     * @throws IOException the io exception
     */
    public void finish(File file) throws IOException {
        new CreateContainer(
                new CreateStatic().create(getHeaderCells()),
                new CreateStatic().create(getFooterCells())
        ).create().finish(file);
    }

    private void terminateInstance() {
        Instance.setInstance(null);
    }

    private void initDefaultDimension() {
        new Dimension().setDefaultDisplayMetrics();
    }
}
