package android.pdf.layout;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import android.pdf.custom.Utils;

import java.util.ArrayList;

/**
 * The type Create area break.
 */
public class CreateAreaBreak {

    /**
     * Create view.
     *
     * @param context         the context
     * @param rowSpan         the row span
     * @param colSpan         the col span
     * @param header          the header
     * @param footer          the footer
     * @param gridLayout      the grid layout
     * @param pageCounterView the page counter view
     * @param pageHeight      the page height
     * @return the view
     */
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
