package android.pdf.layout;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import android.pdf.utility.Utils;
import android.pdf.element.Text;

/**
 * The type Create text.
 */
public class CreateText {

    /**
     * Create view.
     *
     * @param context         the context
     * @param singleColWeight the single col weight
     * @param text            the text
     * @return the view
     */
    public View create(Context context, float singleColWeight, Text text) {

        double minMaxWidth = singleColWeight * text.getColSpan();
        int elementWidth = (int) (minMaxWidth - (text.getMarginRight() + text.getMarginLeft()));

        TextView textView = new TextView(context);
        textView.setText(text.getTextBuilder() == null ? text.getMessage() : text.getTextBuilder().get());
        textView.setMinWidth(elementWidth);
        textView.setMaxWidth(elementWidth);
        textView.setTextColor(text.getTextColor());
        textView.setGravity(text.getGravity());
        textView.setTextSize(text.getTextSize());
        textView.setTypeface(Utils.createGetFont(context, text.getFontStyle()));
        textView.setPadding(text.getPaddingLeft(), text.getPaddingTop(), text.getPaddingRight(), text.getPaddingBottom());
        textView.setLineSpacing(text.getLineSpace(),text.getLineSpace());

        if (text.isBorder()) {
            textView.setBackground(Utils.createBorder(text.getBackgroundColor(), text.getBorderColor(), text.getBorderWidth()));
        } else {
            textView.setBackgroundColor(text.getBackgroundColor());
        }

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, text.getRowSpan(), text.getRowSpan()), GridLayout.spec(GridLayout.UNDEFINED, text.getColSpan(), text.getColSpan()));
        layoutParams.setMargins(text.getMarginLeft(), text.getMarginTop(), text.getMarginRight(), text.getMarginBottom());

        textView.setLayoutParams(layoutParams);

        return textView;
    }
}
