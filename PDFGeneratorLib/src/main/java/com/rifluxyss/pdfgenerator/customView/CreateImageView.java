package com.rifluxyss.pdfgenerator.customView;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.rifluxyss.pdfgenerator.structure.Cell;


public class CreateImageView {

    final Context context;

    Cell cell;
    int minMaxWidth;

    public CreateImageView(Context context) {
        this.context = context;
    }

    public void setData(Cell cell, int minMaxWidth) {
        this.cell = cell;
        this.minMaxWidth = minMaxWidth;
    }

    public View create() {

        if (cell.getBitmap() != null) {

            ImageView imageView = new ImageView(context);

            imageView.setImageBitmap(Bitmap.createScaledBitmap(cell.getBitmap(), cell.getBitmapWidth(), cell.getBitmapHeight(), (true)));

            imageView.setMaxWidth(minMaxWidth);

            imageView.setMaxHeight(cell.getBitmapHeight());

            imageView.setAdjustViewBounds(true);

            imageView.setScaleType(cell.getScaleType());

            imageView.setBackgroundColor(cell.getBackgroundColor());

            imageView.setPadding(cell.getPaddingLeft(), cell.getPaddingTop(), cell.getPaddingRight(), cell.getPaddingBottom());

            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                    GridLayout.spec(GridLayout.UNDEFINED, cell.getRowSpan(), cell.getRowSpan()),
                    GridLayout.spec(GridLayout.UNDEFINED, cell.getColSpan(), cell.getColSpan()));

            layoutParams.setMargins(cell.getMarginLeft(), cell.getMarginTop(), cell.getMarginRight(), cell.getMarginBottom());

            imageView.setLayoutParams(layoutParams);

            return imageView;

        } else {

            View view = new View(context);
            view.setMinimumWidth(minMaxWidth);

            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                    GridLayout.spec(GridLayout.UNDEFINED, cell.getRowSpan(), cell.getRowSpan()),
                    GridLayout.spec(GridLayout.UNDEFINED, cell.getColSpan(), cell.getColSpan()));
            layoutParams.setMargins(cell.getMarginLeft(), cell.getMarginTop(), cell.getMarginRight(), cell.getMarginBottom());
            view.setLayoutParams(layoutParams);

            return view;
        }
    }
}
