package android.pdf.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import android.pdf.core.Document;
import android.pdf.custom.Utils;
import android.pdf.io.Cell;
import android.pdf.io.Paragraph;
import android.pdf.io.Text;
import android.pdf.kernel.ElementType;
import android.pdf.kernel.PageSize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CreateContainer {

    private final View header;
    private final View footer;

    private final Document document;
    private final PdfDocument pdfDocument = new PdfDocument();

    private PageSize pageSize;
    private View pageCounterView;

    public CreateContainer(Document document, View header, View footer) {
        this.header = header;
        this.footer = footer;
        this.document = document;
    }

    public CreateContainer create() {

        pageSize = document.getPageSize();

        float singleColWeight = (float) pageSize.pageWidth / document.getColumnWeight();
        pageCounterView = createPageCounterView(0);

        LinearLayout container = new LinearLayout(document.getContext());
        container.setOrientation(LinearLayout.VERTICAL);
        container.setPadding(document.getPaddingLeft(), document.getPaddingTop(), document.getPaddingRight(), document.getPaddingBottom());

        container.addView(header);
        container.addView(footer);
        container.addView(pageCounterView);

        GridLayout gridLayout = new GridLayout(document.getContext());
        gridLayout.setColumnCount(document.getColumnWeight());

        for (Cell cell : document.getCells()) {

            if (cell.getCellType() == ElementType.PARAGRAPH) {

                gridLayout.addView(new CreateParagraph().create(document.getContext(), singleColWeight, ((Paragraph) cell).setRowSpan(1).setColSpan(document.getColumnWeight()), document.getColumnWeight()));

            }

            if (cell.getCellType() == ElementType.AREA_BREAK) {

                createPageBreakView(gridLayout);

            }

            ArrayList<View> mHeight = new ArrayList<>();
            mHeight.add(header);
            mHeight.add(footer);
            mHeight.add(gridLayout);
            mHeight.add(pageCounterView);

            if (Utils.getViewHeight(mHeight) > pageSize.pageHeight) {

                View view = overlapping((Paragraph) cell, gridLayout);

                createPageBreakView(gridLayout);

                container.addView(gridLayout, 1);

                createNewPage(container);

                gridLayout.removeAllViews();

                container.removeViews(1, (container.getChildCount() - 3));

                addGridAttribute(gridLayout, singleColWeight , view);
            }
        }

        createPageBreakView(gridLayout);

        container.addView(gridLayout, 1);

        createNewPage(container);

        return this;
    }

    private void addGridAttribute(GridLayout gridLayout, float singleColWeight, View view) {

        gridLayout.addView(new CreateText().create(document.getContext(), singleColWeight, new Text(1, document.getColumnWeight(), "").setTextSize(3)));

        gridLayout.addView(view);
    }

    private View overlapping(Paragraph paragraph, GridLayout gridLayout) {

        View view = gridLayout.getChildAt(gridLayout.getChildCount() - 1);
        gridLayout.removeViewAt(gridLayout.getChildCount() - 1);
        return view;

    }

    private void createPageBreakView(GridLayout gridLayout) {
        gridLayout.addView(new CreateAreaBreak().create(document.getContext(), 1, document.getColumnWeight(), header, footer, gridLayout, pageCounterView, pageSize.pageHeight));
    }

    private void createNewPage(LinearLayout view) {

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(pageSize.documentWidth, pageSize.documentHeight, (pdfDocument.getPages().size() + 1)).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);
        Canvas canvas = page.getCanvas();

        if (document.getBgImage() != null && document.getBgImage().getImage(pageSize.documentWidth, pageSize.documentHeight) != null) {
            canvas.drawBitmap(document.getBgImage().getImage(pageSize.documentWidth, pageSize.documentHeight), 0, 0, new Paint());
        }

        if (document.getPageCount() != null) {
            pageCounterView = createPageCounterView((pdfDocument.getPages().size() + 1));
            view.removeViewAt((view.getChildCount() - 1));
            view.addView(pageCounterView);
        }

        view.measure(0, 0);
        view.layout(0, 0, pageSize.documentWidth, pageSize.documentHeight);
        view.draw(canvas);

        pdfDocument.finishPage(page);
    }

    private View createPageCounterView(int currentPageCount) {

        if (document.getPageCount() == null) {

            return new LinearLayout(document.getContext());

        } else {

            return new CreatePageCount().create(document.getContext(), pageSize.pageWidth, currentPageCount, document.getPageCount());

        }
    }

    public void finish(File servicePdfFile) throws IOException {
        pdfDocument.writeTo(new FileOutputStream(servicePdfFile));
        pdfDocument.close();
    }

    public int getPageCount() {
        return pdfDocument.getPages().size();
    }
}
