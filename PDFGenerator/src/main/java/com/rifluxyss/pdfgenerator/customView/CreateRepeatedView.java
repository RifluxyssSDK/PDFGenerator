package com.rifluxyss.pdfgenerator.customView;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;

import com.rifluxyss.pdfgenerator.Utils;
import com.rifluxyss.pdfgenerator.constants.Draw;
import com.rifluxyss.pdfgenerator.structure.Cell;

/**
 * The type Create repeated view.
 */
@SuppressWarnings("unused")
public class CreateRepeatedView {

    /**
     * The Context.
     */
    final Context context;
    /**
     * The Cells.
     */
    ArrayList<Cell> cells;
    /**
     * The Page width.
     */
    int pageWidth, /**
     * The Col weight.
     */
    colWeight;

    /**
     * Instantiates a new Create repeated view.
     *
     * @param context the context
     */
    public CreateRepeatedView(Context context) {
        this.context = context;
    }

    /**
     * Sets data.
     *
     * @param cells     the cells
     * @param pageWidth the page width
     * @param colWeight the col weight
     */
    public void setData(ArrayList<Cell> cells, int pageWidth, int colWeight) {
        this.cells = cells;
        this.pageWidth = pageWidth;
        this.colWeight = colWeight;
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

        int singleColWeight = pageWidth / colWeight;

        GridLayout gridLayout = new GridLayout(context);
        gridLayout.setColumnCount(colWeight);

        for (Cell cell : cells) {

            if (cell.getColSpan() > colWeight) {
                throw new Error("column span mustn't exceed the column count. ( total column : " + colWeight + ", cell colSpan : " + cell.getColSpan() + " )");
            }

            int minMaxWidth = singleColWeight * cell.getColSpan();
            int cellWidth = minMaxWidth - (cell.getMarginRight() + cell.getMarginLeft());

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

}
