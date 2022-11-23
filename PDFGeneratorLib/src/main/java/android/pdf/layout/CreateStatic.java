package android.pdf.layout;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import android.pdf.io.Cell;
import android.pdf.io.Paragraph;
import android.pdf.kernel.ElementType;
import android.pdf.kernel.PageSize;

import java.util.ArrayList;

public class CreateStatic {

    private final Context context;
    private final int columnWeight;
    private final PageSize pageSize;
    private final ArrayList<Cell> cells;

    public CreateStatic(Context context, ArrayList<Cell> cells, PageSize pageSize, int columnWeight) {
        this.cells = cells;
        this.context = context;
        this.pageSize = pageSize;
        this.columnWeight = columnWeight;
    }

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
