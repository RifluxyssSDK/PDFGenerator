package com.pdf.mainView;

import android.content.Context;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.pdf.customView.CreateRepeatedView;
import com.pdf.customView.CreateView;
import com.pdf.image.ImageData;
import com.pdf.model.PageCounterModel;
import com.pdf.structure.Cell;
import com.pdf.structure.Table;

@SuppressWarnings("unused")
public class PdfGenerateFactory {

    CreateView createView;
    final int pageWidth;
    final int pageHeight;
    int marginLeft;
    int marginTop;
    int marginRight;
    int marginBottom;

    public PdfGenerateFactory(int pageWidth, int pageHeight) {
        this.pageWidth = pageWidth;
        this.pageHeight = pageHeight;
    }

    public void setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
    }

    public void create(Context context, ImageData imageData, Table table, PageCounterModel pageCounterModel) {

        int colWeight = table.getColWeight();
        int marginWidth = marginLeft + marginRight;
        int marginHeight = marginTop + marginBottom;
        int contentWidth = (pageWidth - marginWidth);
        int contentHeight = (pageHeight - marginHeight);

        CreateRepeatedView createHeaderView = new CreateRepeatedView(context);
        createHeaderView.setData(table.getHeaderCells(), contentWidth, colWeight);

        CreateRepeatedView createFooterView = new CreateRepeatedView(context);
        createFooterView.setData(table.getFooterCells(), contentWidth, colWeight);

        if (pageCounterModel != null) {
            int pageCount = getPageCount(context, createHeaderView.create(), createFooterView.create(), table.getCells(), imageData, pageCounterModel, colWeight, contentWidth, contentHeight);
            pageCounterModel.setPageCount(pageCount);
        }

        createView = new CreateView(context);
        createView.setMargin(marginLeft, marginTop, marginRight, marginBottom);
        createView.setData(createHeaderView.create(), createFooterView.create(), table.getCells(), imageData, pageCounterModel, colWeight, contentWidth, contentHeight);

    }

    private int getPageCount(Context context, View header, View footer, ArrayList<Cell> cells, ImageData imageData, PageCounterModel pageCounterModel, int colWeight, int contentWidth, int contentHeight) {
        CreateView pageCount = new CreateView(context);
        pageCount.setMargin(marginLeft, marginTop, marginRight, marginBottom);
        pageCount.setData(header, footer, cells, imageData, pageCounterModel, colWeight, contentWidth, contentHeight);
        return pageCount.create().getPageCount();
    }

    public void startCreatePDF(File filePath) throws IOException {
        createView.create();
        createView.startCreatePDF(filePath);
    }

}
