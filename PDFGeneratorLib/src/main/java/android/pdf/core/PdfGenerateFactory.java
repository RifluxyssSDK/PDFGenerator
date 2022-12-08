package android.pdf.core;

import android.pdf.constant.PageSize;
import android.pdf.dimension.Dimension;
import android.pdf.io.PageCount;
import android.pdf.layout.CreateContainer;
import android.pdf.layout.CreateStatic;

import java.io.File;
import java.io.IOException;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PdfGenerateFactory {

    private Instance instance = Instance.getInstance();

    public void initialize() {
        initCustomDimension();
        initPageSize();
        initPageCount();
    }

    public void terminate() {
        initDefaultDimension();
        terminateInstance();
    }

    private void initPageSize() {
        PageSize pageSize = instance.getPageSize();
        pageSize.calculatePageSize();
    }

    private void initCustomDimension() {
        new Dimension().saveDefaultDisplayMetrics();
        new Dimension().setCustomDisplayMetrics();
    }

    private void initPageCount() {
        PageCount pageCount = instance.getPageCount();
        if (pageCount != null) {
            pageCount.setTotalPageCount(
                    new CreateContainer(
                            new CreateStatic().create(instance.getHeaderCells()),
                            new CreateStatic().create(instance.getFooterCells())
                    ).create().getPageCount()
            );
        }
    }

    public void finish(File file) throws IOException {
        new CreateContainer(
                new CreateStatic().create(instance.getHeaderCells()),
                new CreateStatic().create(instance.getFooterCells())
        ).create().finish(file);
    }

    private void terminateInstance() {
        instance = null;
    }

    private void initDefaultDimension() {
        new Dimension().setDefaultDisplayMetrics();
    }
}
