package android.pdf.layout;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import android.pdf.io.Cell;
import android.pdf.io.Paragraph;
import android.pdf.kernel.ElementType;
import android.pdf.kernel.PageSize;

import java.util.ArrayList;

/**
 * The type Create static.
 */
public class CreateStatic {

    private final Context context;
    private final int columnWeight;
    private final PageSize pageSize;
    private final ArrayList<Cell> cells;

    /**
     * Instantiates a new Create static.
     *
     * @param context      the context
     * @param cells        the cells
     * @param pageSize     the page size
     * @param columnWeight the column weight
     */
    public CreateStatic(Context context, ArrayList<Cell> cells, PageSize pageSize, int columnWeight) {
        this.cells = cells;
        this.context = context;
        this.pageSize = pageSize;
        this.columnWeight = columnWeight;
    }

    /**
     * Create view.
     *
     * @return the view
     */
    public View create() {

        if (cells.size() == 0) {
            return new View(context);
        }

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        float singleColWeight = (float) pageSize.pageWidth / columnWeight;

        for (Cell cell : cells) {

            if (cell.getCellType() == ElementType.PARAGRAPH) {

                linearLayout.addView(new CreateParagraph().create(context, singleColWeight, ((Paragraph) cell).setRowSpan(1).setColSpan(columnWeight), columnWeight));

            }
        }

        return linearLayout;
    }
}
