package android.pdf.layout;

import android.pdf.cell.Paragraph;
import android.pdf.constant.ElementType;
import android.pdf.core.Instance;
import android.pdf.io.Cell;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class CreateStatic {

    private final Instance instance = Instance.getInstance();

    public View create(ArrayList<Cell> cells) {

        LinearLayout linearLayout = new LinearLayout(instance.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        if (cells.size() != 0) {

            float width = (float) instance.getPageSize().getPageWidth() / instance.getColumnWeight();

            for (Cell cell : cells) {
                if (cell.getCellType() == ElementType.PARAGRAPH) {
                    linearLayout.addView(new CreateParagraph().create(((Paragraph) cell)));
                }
            }
        }
        return linearLayout;
    }
}
