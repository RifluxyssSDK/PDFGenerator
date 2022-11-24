package android.pdf.layout;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import android.pdf.io.Line;

/**
 * The type Create line.
 */
public class CreateLine {

    /**
     * Create view.
     *
     * @param context         the context
     * @param singleColWeight the single col weight
     * @param line            the line
     * @return the view
     */
    public View create(Context context, float singleColWeight, Line line) {

        double minMaxWidth =  singleColWeight * line.getColSpan();
        int elementWidth = (int) (minMaxWidth - (line.getMarginRight() + line.getMarginLeft()));

        LinearLayout lineOuter = new LinearLayout(context);
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, line.getRowSpan(), line.getRowSpan()),
                GridLayout.spec(GridLayout.UNDEFINED, line.getColSpan(), line.getColSpan())
        );

        layoutParams.setMargins(line.getMarginLeft(), line.getMarginTop(), line.getMarginRight(), line.getMarginBottom());
        lineOuter.setLayoutParams(layoutParams);

        View view = new View(context);
        view.setPadding(line.getPaddingLeft(), line.getPaddingTop(), line.getPaddingRight(), line.getPaddingBottom());
        view.setBackgroundColor(line.getLineColor());
        view.setMinimumWidth(elementWidth);

        lineOuter.addView(view, new LinearLayout.LayoutParams(elementWidth, line.getLineStrokeWidth()));

        return lineOuter;

    }
}
