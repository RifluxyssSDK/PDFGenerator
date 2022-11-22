package com.pdf.customView;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.pdf.structure.Cell;

public class CreateLineView {

    final Context context;

    Cell cell;
    int minMaxWidth;

    public CreateLineView(Context context) {
        this.context = context;
    }

    public void setData(Cell cell, int minMaxWidth) {
        this.cell = cell;
        this.minMaxWidth = minMaxWidth;
    }

    public View create() {

        LinearLayout lineOuter = new LinearLayout(context);
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, cell.getRowSpan(), cell.getRowSpan()),
                GridLayout.spec(GridLayout.UNDEFINED, cell.getColSpan(), cell.getColSpan())
        );
        layoutParams.setMargins(cell.getMarginLeft(), cell.getMarginTop(), cell.getMarginRight(), cell.getMarginBottom());
        lineOuter.setLayoutParams(layoutParams);

        View view = new View(context);
        view.setPadding(cell.getPaddingLeft(), cell.getPaddingTop(), cell.getPaddingRight(), cell.getPaddingBottom());
        view.setBackgroundColor(cell.getBorderColor());
        view.setMinimumWidth(minMaxWidth);

        lineOuter.addView(view, new LinearLayout.LayoutParams(minMaxWidth, cell.getBorderWidth()));

        return lineOuter;
    }
}
