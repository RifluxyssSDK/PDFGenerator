package android.pdf.layout;

import android.pdf.core.Instance;
import android.pdf.utility.Utils;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CreateAreaBreak {

    private final Instance instance = Instance.getInstance();

    public View create(View header, View footer, GridLayout gridLayout, View pageCounterView, int pageHeight) {

        ArrayList<View> views = new ArrayList<>();
        views.add(header);
        views.add(footer);
        views.add(gridLayout);
        views.add(pageCounterView);

        int currentViewHeight = Utils.getViewHeight(views);
        int additionalViewHeight = pageHeight - currentViewHeight;

        TextView additionalView = new TextView(instance.getContext());
        additionalView.setMinimumHeight(additionalViewHeight);
        additionalView.setMaxHeight(additionalViewHeight);

        additionalView.setLayoutParams(new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, (1), (1)),
                GridLayout.spec(GridLayout.UNDEFINED, instance.getColumnWeight(), instance.getColumnWeight())
        ));

        return additionalView;
    }
}
