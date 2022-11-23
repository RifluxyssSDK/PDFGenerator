package android.pdf.layout;

import android.content.Context;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import android.pdf.custom.Utils;
import android.pdf.io.Text;

public class CreateText {

    public View create(Context context, float singleColWeight, Text text) {

        double minMaxWidth =  singleColWeight * text.getColSpan();
        int elementWidth = (int) (minMaxWidth - (text.getMarginRight() + text.getMarginLeft()));

        TextView textView = new TextView(context);
        textView.setText(text.getMessage());
        textView.setMinWidth(elementWidth);
        textView.setMaxWidth(elementWidth);
        textView.setTextColor(text.getTextColor());
        textView.setGravity(text.getGravity());
        textView.setTextSize(text.getTextSize());
        textView.setTypeface(Utils.createGetFont(context, text.getFontStyle()));
        textView.setPadding(text.getPaddingLeft(), text.getPaddingTop(), text.getPaddingRight(), text.getPaddingBottom());

        if (text.isBorder()) {
            textView.setBackground(Utils.createBorder(text.getBackgroundColor(), text.getBorderColor(), text.getBorderWidth()));
        } else {
            textView.setBackgroundColor(text.getBackgroundColor());
        }

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, text.getRowSpan(), text.getRowSpan()),
                GridLayout.spec(GridLayout.UNDEFINED, text.getColSpan(), text.getColSpan()));
        layoutParams.setMargins(text.getMarginLeft(), text.getMarginTop(), text.getMarginRight(), text.getMarginBottom());

        textView.setLayoutParams(layoutParams);

        return textView;
    }
}
