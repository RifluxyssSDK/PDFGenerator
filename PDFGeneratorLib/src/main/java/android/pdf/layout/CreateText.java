package android.pdf.layout;

import android.pdf.core.Instance;
import android.pdf.element.Text;
import android.pdf.utility.Utils;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

/**
 * The type Create text.
 */
public class CreateText {

    private final Instance instance = Instance.getInstance();
    private final TextView textView = new TextView(instance.getContext());

    /**
     * Create view.
     *
     * @param width the width
     * @param text  the text
     * @return the view
     */
    public View create(float width, Text text) {

        int actualWidth = calculateActualWidth(width, text);

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, text.getRowSpan(), text.getRowSpan()),
                GridLayout.spec(GridLayout.UNDEFINED, text.getColSpan(), text.getColSpan())
        );

        layoutParams.setMargins(
                text.getMarginLeft(),
                text.getMarginTop(),
                text.getMarginRight(),
                text.getMarginBottom()
        );

        if (text.isBorder()) {
            textView.setBackground(
                    Utils.createBorder(
                            text.getBackgroundColor(),
                            text.getBorderColor(),
                            text.getBorderWidth()
                    )
            );
        } else {
            textView.setBackgroundColor(text.getBackgroundColor());
        }

        textView.setMinWidth(actualWidth);
        textView.setMaxWidth(actualWidth);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(text.getGravity());
        textView.setTextSize(text.getTextSize());
        textView.setTextColor(text.getTextColor());
        textView.setTypeface(Utils.createGetFont(text.getFontStyle()));
        textView.setLineSpacing(text.getLineSpace(), text.getLineSpace());
        textView.setText(text.getTextBuilder() == null ? text.getMessage() : text.getTextBuilder().get());
        textView.setPadding(text.getPaddingLeft(), text.getPaddingTop(), text.getPaddingRight(), text.getPaddingBottom());
        return textView;
    }

    private int calculateActualWidth(float width, Text text) {
        double minMaxWidth = width * text.getColSpan();
        int marginWidth = text.getMarginLeft() + text.getMarginRight();
        return (int) minMaxWidth - marginWidth;
    }
}
