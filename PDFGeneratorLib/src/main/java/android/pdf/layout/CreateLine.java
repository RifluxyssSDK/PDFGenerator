package android.pdf.layout;

import android.pdf.core.Instance;
import android.pdf.element.Line;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

/**
 * The type Create line.
 */
public class CreateLine extends Instance {

    private final LinearLayout lineOuter = new LinearLayout(getContext());

    /**
     * Create view.
     *
     * @param width the width
     * @param line  the line
     * @return the view
     */
    public View create(float width, Line line) {

        int actualWidth = calculateActualWidth(width, line);

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, line.getRowSpan(), line.getRowSpan()),
                GridLayout.spec(GridLayout.UNDEFINED, line.getColSpan(), line.getColSpan())
        );

        layoutParams.setMargins(
                line.getMarginLeft(),
                line.getMarginTop(),
                line.getMarginRight(),
                line.getMarginBottom()
        );

        View view = new View(getContext());
        view.setMinimumWidth(actualWidth);
        view.setBackgroundColor(line.getLineColor());
        view.setPadding(line.getPaddingLeft(), line.getPaddingTop(), line.getPaddingRight(), line.getPaddingBottom());

        lineOuter.setLayoutParams(layoutParams);
        lineOuter.addView(view, new LinearLayout.LayoutParams(actualWidth, line.getLineStrokeWidth()));
        return lineOuter;
    }

    private int calculateActualWidth(float width, Line line) {
        double minMaxWidth = width * line.getColSpan();
        int marginWidth = line.getMarginLeft() + line.getMarginRight();
        return (int) minMaxWidth - marginWidth;
    }
}
