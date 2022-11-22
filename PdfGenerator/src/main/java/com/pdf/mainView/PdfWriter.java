package com.pdf.mainView;

import android.content.Context;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.IOException;

import com.pdf.constants.PageSize;
import com.pdf.image.ImageData;
import com.pdf.model.PageCounterModel;
import com.pdf.structure.Table;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PdfWriter {

    Context context;

    Table table;
    ImageData imageData;
    PageCounterModel pageCounterModel;

    final int pageWidth;
    final int pageHeight;
    int marginLeft = 0;
    int marginTop = 0;
    int marginRight = 0;
    int marginBottom = 0;

    public PdfWriter(PageSize pageSize) {
        pageWidth = pageSize.getWidth();
        pageHeight = pageSize.getHeight();
    }

    public PdfWriter(int pageWidth, int pageHeight) {
        this.pageWidth = pageWidth;
        this.pageHeight = pageHeight;
    }

    public PdfWriter init(@NonNull Context context) {
        this.context = context;
        initDpi(context);
        return this;
    }

    private void initDpi(@NonNull Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        metrics.density = 1.5f;
        metrics.densityDpi = 240;
        metrics.heightPixels = 1104;
        metrics.widthPixels = 1920;
        metrics.scaledDensity = 1.5f;
        metrics.xdpi = 254.0f;
        metrics.ydpi = 254.0f;
        context.getResources().getDisplayMetrics().setTo(metrics);
    }

    public PdfWriter setBackgroundImage(ImageData imageData) {
        this.imageData = imageData.init(pageWidth, pageHeight);
        return this;
    }

    public Table createTable(int colWeight) {
        table = new Table(colWeight);
        return table;
    }

    public PdfWriter setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
        return this;
    }

    public PdfWriter setMargin(int margin) {
        this.marginLeft = margin;
        this.marginTop = margin;
        this.marginRight = margin;
        this.marginBottom = margin;
        return this;
    }

    public void setPageCounter(PageCounterModel pageCounterModel) {
        this.pageCounterModel = pageCounterModel;
    }

    public PdfWriter createPDF(File file) throws IOException {

        if (context == null) {

            throw new Error("You been must call 'init' method to initialize library.");

        }

        PdfGenerateFactory pdfGenerateFactory = new PdfGenerateFactory(pageWidth, pageHeight);
        pdfGenerateFactory.setMargin(marginLeft, marginTop, marginRight, marginBottom);
        pdfGenerateFactory.create(context, imageData, table, pageCounterModel);
        pdfGenerateFactory.startCreatePDF(file);
        return this;

    }
}
