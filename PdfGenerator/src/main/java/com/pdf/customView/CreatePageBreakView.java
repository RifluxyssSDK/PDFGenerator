package com.pdf.customView;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

import com.pdf.Utils;


public class CreatePageBreakView {

    final Context context;

    int rowSpan;
    int colSpan;
    int additionalViewHeight;

    public CreatePageBreakView(Context context) {
        this.context = context;
    }

    public void setData(int rowSpan, int colSpan, View headerView, View footerView, View gridLayout, View pageCounterView, int contentHeight) {

        ArrayList<View> views= new ArrayList<>();
        views.add(headerView);
        views.add(footerView);
        views.add(gridLayout);
        views.add(pageCounterView);

        int currentViewHeight = Utils.getViewHeight(views);
        additionalViewHeight = contentHeight - currentViewHeight ;

        this.rowSpan = rowSpan;
        this.colSpan = colSpan;

    }

    public View create() {

        TextView additionalView = new TextView(context);
        additionalView.setMinimumHeight(additionalViewHeight);
        additionalView.setMaxHeight(additionalViewHeight);

        additionalView.setLayoutParams(new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, rowSpan, rowSpan),
                GridLayout.spec(GridLayout.UNDEFINED, colSpan, colSpan)
        ));

        return additionalView;

    }
}
