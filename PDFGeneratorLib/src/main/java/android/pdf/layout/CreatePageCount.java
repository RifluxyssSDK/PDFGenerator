package android.pdf.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.pdf.custom.Utils;
import android.pdf.io.PageCount;

import java.util.List;


/**
 * The type Create page count.
 */
public class CreatePageCount {

    /**
     * Create view.
     *
     * @param context          the context
     * @param pageWidth        the page width
     * @param pageCountText        the page count
     * @return the view
     */
    @SuppressLint("SetTextI18n")
    public View create(Context context, int pageWidth, PageCount pageCountText) {

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        int cellWidth = pageWidth - (pageCountText.getMarginLeft() + pageCountText.getMarginRight());

        linearLayout.setPadding(pageCountText.getMarginLeft(), pageCountText.getMarginTop(), pageCountText.getMarginRight(), pageCountText.getMarginBottom());

        TextView textView = new TextView(context);
        textView.setMaxWidth(cellWidth);
        textView.setMinimumWidth(cellWidth);
        textView.setText(pageCountText.getMessage());
        textView.setTextColor(pageCountText.getTextColor());
        textView.setGravity(pageCountText.getGravity());
        textView.setTextSize(pageCountText.getTextSize());
        textView.setTypeface(Utils.createGetFont(context, pageCountText.getFontStyle()));
        textView.setPadding(pageCountText.getPaddingLeft(), pageCountText.getPaddingTop(), pageCountText.getPaddingRight(), pageCountText.getPaddingBottom());

        if (pageCountText.isBorder()) {
            textView.setBackground(Utils.createBorder(pageCountText.getBackgroundColor(), pageCountText.getBorderColor(), pageCountText.getBorderWidth()));
        } else {
            textView.setBackgroundColor(pageCountText.getBackgroundColor());
        }

        linearLayout.addView(textView);

        return linearLayout;

    }
}
