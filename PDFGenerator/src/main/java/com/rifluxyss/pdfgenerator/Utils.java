package com.rifluxyss.pdfgenerator;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.rifluxyss.pdfgenerator.constants.Draw;

import java.util.List;

import com.rifluxyss.pdfgenerator.constants.FontStyle;
import com.rifluxyss.pdfgenerator.structure.Cell;

@SuppressWarnings("unused")
public class Utils {

    public static Drawable createBorder(int backgroundColor, int borderColor, int width) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(width, borderColor);
        gradientDrawable.setColor(backgroundColor);
        return new LayerDrawable(new Drawable[]{gradientDrawable});
    }

    public static TextView createGridTextView(Context context, int minMaxWidth, Cell cell) {

        TextView textView = new TextView(context);
        if (cell.getDraw() == Draw.empty_space || cell.getMessage() != null) {
            textView.setText(cell.getDraw() == Draw.empty_space ? "" : cell.getMessage());
        } else if (cell.getSpannableStringBuilder() != null) {
            textView.setText(cell.getSpannableStringBuilder(), TextView.BufferType.SPANNABLE);
        }
        textView.setMinWidth(minMaxWidth);
        textView.setMaxWidth(minMaxWidth);
        textView.setTextColor(cell.getTextColor());
        textView.setGravity(cell.getGravity());
        textView.setTextSize(cell.getTextSize());
        textView.setTypeface(Utils.createGetFont(context, cell.getFontStyle()));
        textView.setPadding(cell.getPaddingLeft(), cell.getPaddingTop(), cell.getPaddingRight(), cell.getPaddingBottom());
        textView.setLineSpacing(cell.getLineSpacing(), cell.getLineSpacing());

        if (cell.getFontStyle() == FontStyle.HELVETICA_BOLD) {
            textView.setLetterSpacing(0.05f);
        }

        if (cell.isBorder()) {
            textView.setBackground(createBorder(cell.getBackgroundColor(), cell.getBorderColor(), cell.getBorderWidth()));
        } else {
            textView.setBackgroundColor(cell.getBackgroundColor());

        }

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, cell.getRowSpan(), cell.getRowSpan()),
                GridLayout.spec(GridLayout.UNDEFINED, cell.getColSpan(), cell.getColSpan()));
        layoutParams.setMargins(cell.getMarginLeft(), cell.getMarginTop(), cell.getMarginRight(), cell.getMarginBottom());

        textView.setLayoutParams(layoutParams);

        return textView;
    }

    public static Typeface createGetFont(Context context, int typeFace) {

        switch (typeFace) {
            default:
                return Typeface.createFromAsset(context.getAssets(), "font/Times-Roman.otf");
            case FontStyle.HELVETICA:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica.ttf");
            case FontStyle.HELVETICA_BOLD:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-Bold.ttf");
            case FontStyle.HELVETICA_BOLDOBLIQUE:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-BoldOblique.ttf");
            case FontStyle.HELVETICA_ROUNDED_BOLD:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-rounded-bold.otf");
            case FontStyle.HELVETICA_OBLIQUE:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-Oblique.ttf");
            case FontStyle.HELVETICA_LIGHT:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-light.ttf");
            case FontStyle.HELVETICA_COMPRESSED:
                return Typeface.createFromAsset(context.getAssets(), "font/Helvetica-compressed.otf");
        }
    }


    public static int getViewHeight(List<View> views) {

        int mHeight = 0;

        for (int i = 0; i < views.size(); i++) {

            views.get(i).measure(0, 0);
            mHeight += views.get(i).getMeasuredHeight();

        }

        return mHeight;
    }
}
