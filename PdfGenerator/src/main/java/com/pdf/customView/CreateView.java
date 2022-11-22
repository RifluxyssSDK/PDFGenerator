package com.pdf.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.pdf.Utils;
import com.pdf.constants.Draw;
import com.pdf.image.ImageData;
import com.pdf.model.PageCounterModel;
import com.pdf.structure.Cell;

public class CreateView {

    final Context context;

    ArrayList<Cell> cells;
    View headerView,
    footerView,
    pageCounterView;

    int colWeight,
    contentWidth,
    contentHeight;
    int marginLeft,
    marginTop,
    marginRight,
    marginBottom;

    ImageData imageData;
    PageCounterModel pageCounterModel;

    final PdfDocument pdfDocument = new PdfDocument();

    public CreateView(Context context) {
        this.context = context;
    }

    public void setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginBottom = marginBottom;
        this.marginRight = marginRight;
    }

    public void setData(View headerView, View footerView, ArrayList<Cell> cells, ImageData imageData, PageCounterModel pageCounterModel, int colWeight, int contentWidth, int contentHeight) {
        this.cells = cells;
        this.colWeight = colWeight;
        this.imageData = imageData;
        this.headerView = headerView;
        this.footerView = footerView;
        this.contentWidth = contentWidth;
        this.contentHeight = contentHeight;
        this.pageCounterModel = pageCounterModel;
    }

    public CreateView create() {

        float singleColWeight = (float) contentWidth / colWeight;
        pageCounterView = createPageCounterView(0);

        LinearLayout container = new LinearLayout(context);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setPadding(marginLeft, marginTop, marginRight, marginBottom);

        container.addView(headerView);
        container.addView(footerView);
        container.addView(pageCounterView);

        GridLayout gridLayout = new GridLayout(context);
        gridLayout.setColumnCount(colWeight);

        for (Cell cell : cells) {

            init(cell);

            double minMaxWidth = singleColWeight * cell.getColSpan();
            int cellWidth = (int) minMaxWidth - (cell.getMarginRight() + cell.getMarginLeft());

            if (cell.getDraw() == Draw.line) {

                CreateLineView createLineView = new CreateLineView(context);
                createLineView.setData(cell, cellWidth);
                gridLayout.addView(createLineView.create());

            } else if (cell.getDraw() == Draw.paragraph) {

                CreateParagraphView createParagraphView = new CreateParagraphView(context);
                createParagraphView.setData(cell, cellWidth, colWeight);
                gridLayout.addView(createParagraphView.create());

            } else if (cell.getDraw() == Draw.image) {

                CreateImageView createImageLayout = new CreateImageView(context);
                createImageLayout.setData(cell, cellWidth);
                gridLayout.addView(createImageLayout.create());

            } else if (cell.getDraw() == Draw.text || cell.getDraw() == Draw.empty_space) {

                View view = Utils.createGridTextView(context, cellWidth, cell);
                gridLayout.addView(view);

            } else if (cell.getDraw() == Draw.break_page) {

                createPageBreakView(gridLayout);

            }

            ArrayList<View> mHeight = new ArrayList<>();
            mHeight.add(headerView);
            mHeight.add(footerView);
            mHeight.add(gridLayout);
            mHeight.add(pageCounterView);

            if (Utils.getViewHeight(mHeight) > contentHeight) {

                View view = overlapping(cell, gridLayout);

                createPageBreakView(gridLayout);

                container.addView(gridLayout, 1);

                createNewPage(container);

                gridLayout.removeAllViews();

                container.removeViews(1, (container.getChildCount() - 3));

                gridLayout.addView(view);

            }

        }

        createPageBreakView(gridLayout);

        container.addView(gridLayout, 1);

        createNewPage(container);

        return this;

    }

    private void init(Cell cell) {

        cell.setRowSpan(1);

        if (cell.getColSpan() > colWeight) {
            throw new Error("column span mustn't exceed the column count. ( total column : " + colWeight + ", cell colSpan : " + cell.getColSpan() + " )");
        }

    }

    private View overlapping(Cell cell, GridLayout gridLayout) {

        View view = gridLayout.getChildAt(gridLayout.getChildCount() - 1);
        gridLayout.removeViewAt(gridLayout.getChildCount() - 1);

        if (cell.isBorder()) {

            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                    GridLayout.spec(GridLayout.UNDEFINED, cell.getRowSpan(), cell.getRowSpan()),
                    GridLayout.spec(GridLayout.UNDEFINED, cell.getColSpan(), cell.getColSpan()));

            layoutParams.setMargins(cell.getMarginLeft(), (cell.getMarginTop() + cell.getBorderWidth()), cell.getMarginRight(), cell.getMarginBottom());

            view.setLayoutParams(layoutParams);

        }

        return view;

    }

    private void createPageBreakView(GridLayout gridLayout) {
        CreatePageBreakView createPageBreakView = new CreatePageBreakView(context);
        createPageBreakView.setData(1, colWeight, headerView, footerView, gridLayout, pageCounterView, contentHeight);
        gridLayout.addView(createPageBreakView.create());
    }

    private void createNewPage(LinearLayout view) {

        int pdfWidth = contentWidth + marginLeft + marginRight;
        int pdfHeight = contentHeight + marginTop + marginBottom;
        int currentPageCount = pdfDocument.getPages().size() + 1;

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(pdfWidth, pdfHeight, currentPageCount).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);
        Canvas canvas = page.getCanvas();

        if (imageData != null) {
            canvas.drawBitmap(imageData.getImageBitmap(), 0, 0, new Paint());
        }

        if (pageCounterModel != null) {
            pageCounterView = createPageCounterView(currentPageCount);
            view.removeViewAt((view.getChildCount() - 1));
            view.addView(pageCounterView);
        }

        view.measure(0, 0);
        view.layout(0, 0, pdfWidth, pdfHeight);
        view.draw(canvas);

        pdfDocument.finishPage(page);

    }

    private View createPageCounterView(int currentPageCount) {

        if (pageCounterModel == null) {

            return new LinearLayout(context);

        } else {

            CreatePageCountView createPageCountView = new CreatePageCountView(context);
            createPageCountView.setData(contentWidth, currentPageCount, pageCounterModel);
            return createPageCountView.create();

        }
    }

    public void startCreatePDF(File servicePdfFile) throws IOException {
        pdfDocument.writeTo(new FileOutputStream(servicePdfFile));
        pdfDocument.close();
    }

    public int getPageCount() {
        return pdfDocument.getPages().size();
    }

}