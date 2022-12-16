package android.pdf.layout;

import android.pdf.core.Instance;
import android.pdf.utility.Utils;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * The type Create area break.
 */
public class CreateAreaBreak extends Instance {

    /**
     * Create view.
     *
     * @param header          the header
     * @param footer          the footer
     * @param gridLayout      the grid layout
     * @param pageCounterView the page counter view
     * @param pageHeight      the page height
     * @return the view
     */
    public View create(View header, View footer, GridLayout gridLayout, View pageCounterView, int pageHeight) {

        ArrayList<View> views = new ArrayList<>();
        views.add(header);
        views.add(footer);
        views.add(gridLayout);
        views.add(pageCounterView);

        int currentViewHeight = Utils.getViewHeight(views);
        int additionalViewHeight = pageHeight - currentViewHeight;

        TextView additionalView = new TextView(getContext());
        additionalView.setMinimumHeight(additionalViewHeight);
        additionalView.setMaxHeight(additionalViewHeight);

        additionalView.setLayoutParams(new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, (1), (1)),
                GridLayout.spec(GridLayout.UNDEFINED, getColumnWeight(), getColumnWeight())
        ));

        return additionalView;
    }
}
