package com.pdf.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pdf.Utils;
import com.pdf.model.PageCounterModel;


public class CreatePageCountView {

    final Context context;

    int pageWidth,currentPageCount;
    PageCounterModel pageCounterModel;

    public CreatePageCountView(Context context) {
        this.context = context;
    }

    public void setData(int pageWidth, int currentPageCount, PageCounterModel pageCounterModel) {
        this.pageWidth = pageWidth;
        this.currentPageCount = currentPageCount;
        this.pageCounterModel = pageCounterModel;
    }

    public View create() {

        int cellWidth = pageWidth - (pageCounterModel.getMarginLeft() + pageCounterModel.getMarginRight());

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(pageCounterModel.getMarginLeft(), pageCounterModel.getMarginTop(), pageCounterModel.getMarginRight(), pageCounterModel.getMarginBottom());

        String pageCountText = pageCounterModel.getStart() + currentPageCount + pageCounterModel.getMiddle() + pageCounterModel.getPageCount();
        TextView textView = new TextView(context);
        textView.setMaxWidth(cellWidth);
        textView.setMinimumWidth(cellWidth);
        textView.setText(pageCountText);
        textView.setTextColor(pageCounterModel.getTextColor());
        textView.setGravity(pageCounterModel.getGravity());
        textView.setTextSize(pageCounterModel.getTextSize());
        textView.setTypeface(pageCounterModel.getFontStyle() == 0 ? Typeface.DEFAULT : Utils.createGetFont(context, pageCounterModel.getFontStyle()));
        textView.setPadding(pageCounterModel.getPaddingLeft(), pageCounterModel.getPaddingTop(), pageCounterModel.getPaddingRight(), pageCounterModel.getPaddingBottom());

        if (pageCounterModel.isBorder()) {
            textView.setBackground(Utils.createBorder(pageCounterModel.getBackgroundColor(), pageCounterModel.getBorderColor(), pageCounterModel.getBorderWidth()));
        } else {
            textView.setBackgroundColor(pageCounterModel.getBackgroundColor());
        }

        linearLayout.addView(textView);

        return linearLayout;

    }
}
