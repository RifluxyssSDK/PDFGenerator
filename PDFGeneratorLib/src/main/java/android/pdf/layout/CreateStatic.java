package android.pdf.layout;

import android.pdf.cell.Paragraph;
import android.pdf.constant.ElementType;
import android.pdf.core.Instance;
import android.pdf.io.Cell;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * The type Create static.
 */
public class CreateStatic extends Instance {

    /**
     * Create view.
     *
     * @param cells the cells
     * @return the view
     */
    public View create(ArrayList<Cell> cells) {

        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        if (cells.size() != 0) {
            for (Cell cell : cells) {
                if (cell.getCellType() == ElementType.PARAGRAPH) {
                    linearLayout.addView(new CreateParagraph().create(((Paragraph) cell)));
                }
            }
        }
        return linearLayout;
    }
}
