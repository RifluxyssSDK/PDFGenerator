package android.pdf.layout;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import android.pdf.custom.Utils;

import java.util.ArrayList;

public class CreateAreaBreak {

    public View create(Context context, int rowSpan, int colSpan, View header, View footer, GridLayout gridLayout, View pageCounterView, int pageHeight) {

        ArrayList<View> views= new ArrayList<>();
        views.add(header);
        views.add(footer);
        views.add(gridLayout);
        views.add(pageCounterView);

        int currentViewHeight = Utils.getViewHeight(views);
        int additionalViewHeight = pageHeight - currentViewHeight ;

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
