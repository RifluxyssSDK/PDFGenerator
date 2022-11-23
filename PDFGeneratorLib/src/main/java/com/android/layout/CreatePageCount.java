package com.android.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.custom.Utils;
import com.android.io.PageCount;


public class CreatePageCount {

    @SuppressLint("SetTextI18n")
    public View create(Context context, int pageWidth, int currentPageCount, PageCount pageCount) {

        int cellWidth = pageWidth - (pageCount.getMarginLeft() + pageCount.getMarginRight());

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(pageCount.getMarginLeft(), pageCount.getMarginTop(), pageCount.getMarginRight(), pageCount.getMarginBottom());

        TextView textView = new TextView(context);
        textView.setMaxWidth(cellWidth);
        textView.setMinimumWidth(cellWidth);
        textView.setText(pageCount.getStartMessage() + currentPageCount + pageCount.getMiddleMessage() + pageCount.getTotalPageCount());
        textView.setTextColor(pageCount.getTextColor());
        textView.setGravity(pageCount.getGravity());
        textView.setTextSize(pageCount.getTextSize());
        textView.setTypeface(Utils.createGetFont(context, pageCount.getFontStyle()));
        textView.setPadding(pageCount.getPaddingLeft(), pageCount.getPaddingTop(), pageCount.getPaddingRight(), pageCount.getPaddingBottom());

        if (pageCount.isBorder()) {
            textView.setBackground(Utils.createBorder(pageCount.getBackgroundColor(), pageCount.getBorderColor(), pageCount.getBorderWidth()));
        } else {
            textView.setBackgroundColor(pageCount.getBackgroundColor());
        }

        linearLayout.addView(textView);

        return linearLayout;

    }
}
