package android.pdf.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.pdf.utility.Utils;
import android.pdf.io.PageCount;


/**
 * The type Create page count.
 */
public class CreatePageCount {

    /**
     * Create view.
     *
     * @param context          the context
     * @param pageWidth        the page width
     * @param currentPageCount the current page count
     * @param pageCount        the page count
     * @return the view
     */
    @SuppressLint("SetTextI18n")
    public View create(Context context, int pageWidth, int currentPageCount, PageCount pageCount) {

        int cellWidth = pageWidth - (pageCount.getMarginLeft() + pageCount.getMarginRight());

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(pageCount.getMarginLeft(), pageCount.getMarginTop(), pageCount.getMarginRight(), pageCount.getMarginBottom());

        TextView textView = new TextView(context);
        textView.setMaxWidth(cellWidth);
        textView.setMinimumWidth(cellWidth);
        textView.setText(pageCount.getStartMessage() + currentPageCount + pageCount.getMiddleMessage() + pageCount.getTotalPageCount());
        textView.setTextColor(pageCount.getTextColor());
        textView.setGravity(pageCount.getGravity());
        textView.setTextSize(pageCount.getTextSize());
        textView.setTypeface(Utils.createGetFont(context, pageCount.getFontStyle()));
        textView.setPadding(pageCount.getPaddingLeft(), pageCount.getPaddingTop(), pageCount.getPaddingRight(), pageCount.getPaddingBottom());

        if (pageCount.isBorder()) {
            textView.setBackground(Utils.createBorder(pageCount.getBackgroundColor(), pageCount.getBorderColor(), pageCount.getBorderWidth()));
        } else {
            textView.setBackgroundColor(pageCount.getBackgroundColor());
        }

        linearLayout.addView(textView);

        return linearLayout;

    }
}
