package com.android.layout;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;

import com.android.custom.Utils;
import com.android.io.Element;
import com.android.io.Image;
import com.android.io.Line;
import com.android.io.Paragraph;
import com.android.io.Text;
import com.android.kernel.ElementType;

public class CreateParagraph {

    public View create(Context context, float singleColWeight, Paragraph paragraph, int columnWeight) {

        singleColWeight = initCalc(singleColWeight, paragraph, columnWeight);

        GridLayout gridLayout = createGrid(context, paragraph, columnWeight);

        for (Element element : paragraph.getElements()) {

            if (element.getElementType() == ElementType.LINE) {

                gridLayout.addView(new CreateLine().create(context, singleColWeight, (Line) element));

            }

            if (element.getElementType() == ElementType.TEXT) {

                gridLayout.addView(new CreateText().create(context, singleColWeight, (Text) element));

            }

            if (element.getElementType() == ElementType.IMAGE) {

                gridLayout.addView(new CreateImage().create(context, singleColWeight, (Image) element));

            }
        }

        return gridLayout;
    }

    private GridLayout createGrid(Context context, Paragraph paragraph, int columnWeight) {

        GridLayout gridLayout = new GridLayout(context);
        gridLayout.setColumnCount(columnWeight);
        gridLayout.setPadding(paragraph.getPaddingLeft(), paragraph.getPaddingTop(), paragraph.getPaddingRight(), paragraph.getPaddingBottom());
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, paragraph.getRowSpan(), paragraph.getRowSpan()),
                GridLayout.spec(GridLayout.UNDEFINED, paragraph.getColSpan(), paragraph.getColSpan())
        );
        layoutParams.setMargins(paragraph.getMarginLeft(), paragraph.getMarginTop(), paragraph.getMarginRight(), paragraph.getMarginBottom());
        gridLayout.setLayoutParams(layoutParams);

        if (paragraph.isBorder()) {
            gridLayout.setBackground(Utils.createBorder(paragraph.getBackgroundColor(), paragraph.getBorderColor(), paragraph.getBorderWidth()));
        }

        return gridLayout;

    }

    private float initCalc(float singleColWeight, Paragraph paragraph, int columnWeight) {

        double minMaxWidth = singleColWeight * paragraph.getColSpan();
        int elementWidth = (int) (minMaxWidth - (paragraph.getMarginRight() + paragraph.getMarginLeft()));

        int marginWidth = paragraph.getMarginLeft() + paragraph.getMarginRight();
        int paddingWidth = paragraph.getPaddingLeft() + paragraph.getPaddingRight();
        int contentWidth = elementWidth - (marginWidth + paddingWidth);
        return  (float) contentWidth / columnWeight;

    }
}
