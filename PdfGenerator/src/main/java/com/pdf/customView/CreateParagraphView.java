package com.pdf.customView;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;

import com.pdf.Utils;
import com.pdf.constants.Draw;
import com.pdf.structure.Cell;
import com.pdf.structure.Paragraph;

public class CreateParagraphView {

    final Context context;

    Cell cell;
    Paragraph paragraph;

    int pageWidth;
    int colWeight;

    public CreateParagraphView(Context context) {
        this.context = context;
    }

    public void setData(Cell cell, int pageWidth, int colWeight) {
        this.cell = cell;
        this.paragraph = cell.getParagraph();
        this.pageWidth = pageWidth;
        this.colWeight = colWeight;
    }

    public View create() {

        int marginWidth = cell.getMarginLeft() + cell.getMarginRight();
        int paddingWidth = cell.getPaddingLeft() + cell.getPaddingRight();
        int contentWidth = pageWidth - (marginWidth + paddingWidth);
        float singleColWeight = (float) contentWidth / colWeight;


        GridLayout gridLayout = createGrid();

        for (Cell cell : paragraph.getCells()) {

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
            }
        }

        return gridLayout;
    }


    private void init(Cell cell) {

        if (cell.getColSpan() > colWeight) {
            throw new Error("column span mustn't exceed the column count. ( total column : " + colWeight + ", cell colSpan : " + cell.getColSpan() + " )");
        }

    }

    private GridLayout createGrid() {

        GridLayout gridLayout = new GridLayout(context);
        gridLayout.setColumnCount(colWeight);
        gridLayout.setPadding(cell.getPaddingLeft(), cell.getPaddingTop(), cell.getPaddingRight(), cell.getPaddingBottom());

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, cell.getRowSpan(), cell.getRowSpan()),
                GridLayout.spec(GridLayout.UNDEFINED, cell.getColSpan(), cell.getColSpan())
        );
        layoutParams.setMargins(cell.getMarginLeft(), cell.getMarginTop(), cell.getMarginRight(), cell.getMarginBottom());
        gridLayout.setLayoutParams(layoutParams);

        if (cell.isBorder()) {
            gridLayout.setBackground(Utils.createBorder(cell.getBackgroundColor(), cell.getBorderColor(), cell.getBorderWidth()));
        }

        return gridLayout;
    }
}
