package android.pdf.layout;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.pdf.cell.Paragraph;
import android.pdf.constant.ElementType;
import android.pdf.core.Instance;
import android.pdf.element.Text;
import android.pdf.io.Cell;
import android.pdf.utility.Utils;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.rifluxyss.pdfgenerator.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Create container.
 */
public class CreateContainer extends Instance {
    
    private final PdfDocument pdfDocument = new PdfDocument();

    private final View header;
    private final View footer;
    private View pageCounterView;

    /**
     * Instantiates a new Create container.
     *
     * @param header the header
     * @param footer the footer
     */
    public CreateContainer(View header, View footer) {
        this.header = header;
        this.footer = footer;
        this.pageCounterView = createPageCounterView(1);
    }

    /**
     * Create create container.
     *
     * @return the create container
     */
    public CreateContainer create() {

        LinearLayout container = new LinearLayout(getContext());
        container.setOrientation(LinearLayout.VERTICAL);
        container.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());

        container.addView(header);
        container.addView(footer);
        container.addView(pageCounterView);

        GridLayout gridLayout = new GridLayout(getContext());
        gridLayout.setColumnCount(getColumnWeight());
        gridStretchable(gridLayout);

        for (Cell cell : getCells()) {

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

            if (Utils.getViewHeight(mHeight) > getPageSize().getPageHeight()) {

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
        gridLayout.addView(new CreateText().create(getPageSize().getPageWidth(), new Text(1, 1, "").setTextSize(1)));
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
                        getPageSize().getPageHeight()
                )
        );
    }

    private void createNewPage(LinearLayout view) {

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(
                getPageSize().getDocumentWidth(),
                getPageSize().getDocumentHeight(),
                pdfDocument.getPages().size()
        ).create();

        PdfDocument.Page page = pdfDocument.startPage(pageInfo);

        Canvas canvas = page.getCanvas();

        if (getBgImage() != null && getBgImage().getImage() != null) {
            canvas.drawBitmap(getBgImage().getImage(), 0, 0, new Paint());
        }

        if (getPageCount() != null) {
            pageCounterView = createPageCounterView((pdfDocument.getPages().size() + 1));
            view.removeViewAt((view.getChildCount() - 1));
            view.addView(pageCounterView);
        }

        view.measure(0, 0);
        view.layout(0, 0, getPageSize().getDocumentWidth(), getPageSize().getDocumentHeight());
        view.draw(canvas);

        pdfDocument.finishPage(page);
    }

    private View createPageCounterView(int pageCount) {
        return (getPageCount() == null) ?
                new View(getContext()) :
                new CreatePageCount().create(pageCount);
    }

    /**
     * Finish.
     *
     * @param file the service pdf file
     * @throws IOException the io exception
     */
    public void finish(File file) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pdfDocument.writeTo(byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bytes);
        fileOutputStream.close();

        pdfDocument.close();
    }

    /**
     * Gets page count.
     *
     * @return the page count
     */
    public int getTotalPageCount() {
        return pdfDocument.getPages().size();
    }
}
