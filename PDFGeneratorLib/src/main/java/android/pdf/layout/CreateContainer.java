package android.pdf.layout;

import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.pdf.cell.Paragraph;
import android.pdf.constant.ElementType;
import android.pdf.constant.PageSize;
import android.pdf.core.Instance;
import android.pdf.element.Text;
import android.pdf.io.Cell;
import android.pdf.utility.Utils;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CreateContainer {

    private final Instance instance = Instance.getInstance();
    private final PageSize pageSize = instance.getPageSize();

    private final PdfDocument pdfDocument = new PdfDocument();

    private final View header;
    private final View footer;
    private View pageCounterView;

    public CreateContainer(View header, View footer) {
        this.header = header;
        this.footer = footer;
    }

    public CreateContainer create() {

        pageCounterView = createPageCounterView(0);

        LinearLayout container = new LinearLayout(instance.getContext());
        container.setOrientation(LinearLayout.VERTICAL);
        container.setPadding(instance.getPaddingLeft(), instance.getPaddingTop(), instance.getPaddingRight(), instance.getPaddingBottom());

        container.addView(header);
        container.addView(footer);
        container.addView(pageCounterView);

        GridLayout gridLayout = new GridLayout(instance.getContext());
        gridLayout.setColumnCount(instance.getColumnWeight());
        gridStretchable(gridLayout);

        for (Cell cell : instance.getCells()) {

            switch (cell.getCellType()) {
                case ElementType.PARAGRAPH:
                    gridLayout.addView(new CreateParagraph().create(((Paragraph) cell)));
                    break;
                case ElementType.AREA_BREAK:
                    createPageBreakView(gridLayout);
                    break;
            }

            ArrayList<View> mHeight = new ArrayList<>();
            mHeight.add(header);
            mHeight.add(footer);
            mHeight.add(gridLayout);
            mHeight.add(pageCounterView);

            if (Utils.getViewHeight(mHeight) > pageSize.getPageHeight()) {

                View view = overlapping(gridLayout);

                createPageBreakView(gridLayout);

                container.addView(gridLayout, 1);

                createNewPage(container);

                gridLayout.removeAllViews();

                container.removeViews(1, (container.getChildCount() - 3));

                gridStretchable(gridLayout);

                gridLayout.addView(view);
            }
        }

        createPageBreakView(gridLayout);

        container.addView(gridLayout, 1);

        createNewPage(container);

        return this;
    }

    private void gridStretchable(GridLayout gridLayout) {
        gridLayout.addView(new CreateText().create(pageSize.getPageWidth(), new Text(1, 1, "").setTextSize(1)));
    }

    private View overlapping(GridLayout gridLayout) {
        View view = gridLayout.getChildAt(gridLayout.getChildCount() - 1);
        gridLayout.removeViewAt(gridLayout.getChildCount() - 1);
        return view;
    }

    private void createPageBreakView(GridLayout gridLayout) {
        gridLayout.addView(
                new CreateAreaBreak().create(
                        header,
                        footer,
                        gridLayout,
                        pageCounterView,
                        pageSize.getPageHeight()
                )
        );
    }

    private void createNewPage(LinearLayout view) {

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(
                pageSize.getDocumentWidth(),
                pageSize.getDocumentHeight(),
                pdfDocument.getPages().size()
        ).create();

        PdfDocument.Page page = pdfDocument.startPage(pageInfo);

        if (instance.getBgImage() != null && instance.getBgImage().getImage() != null) {
            page.getCanvas().drawBitmap(instance.getBgImage().getImage(), 0, 0, new Paint());
        }

        if (instance.getPageCount() != null) {
            pageCounterView = createPageCounterView((pdfDocument.getPages().size() + 1));
            view.removeViewAt((view.getChildCount() - 1));
            view.addView(pageCounterView);
        }

        view.measure(0, 0);
        view.layout(0, 0, pageSize.getDocumentWidth(), pageSize.getDocumentHeight());
        view.draw(page.getCanvas());

        pdfDocument.finishPage(page);
    }

    private View createPageCounterView(int pageCount) {
        return (instance.getPageCount() == null) ?
                new View(instance.getContext()) :
                new CreatePageCount().create(pageCount);
    }

    public void finish(File servicePdfFile) throws IOException {
        pdfDocument.writeTo(new FileOutputStream(servicePdfFile));
        pdfDocument.close();
    }

    public int getPageCount() {
        return pdfDocument.getPages().size();
    }

}
