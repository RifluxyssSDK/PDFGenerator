package android.pdf.layout;

import android.pdf.core.Instance;
import android.pdf.io.PageCount;
import android.pdf.utility.Utils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CreatePageCount {

    private final Instance instance = Instance.getInstance();
    private final TextView textView = new TextView(instance.getContext());

    public View create(int currentPageCount) {

        PageCount pageCount = instance.getPageCount();
        int actualWidth = calculateActualWidth(pageCount);
        String message = pageCount.getStartMessage() + currentPageCount + pageCount.getMiddleMessage() + pageCount.getTotalPageCount();

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        layoutParams.setMargins(
                pageCount.getMarginLeft(),
                pageCount.getMarginTop(),
                pageCount.getMarginRight(),
                pageCount.getMarginBottom()
        );

        if (pageCount.isBorder()) {
            textView.setBackground(
                    Utils.createBorder(
                            pageCount.getBackgroundColor(),
                            pageCount.getBorderColor(),
                            pageCount.getBorderWidth()
                    )
            );
        } else {
            textView.setBackgroundColor(pageCount.getBackgroundColor());
        }

        textView.setText(message);
        textView.setMaxWidth(actualWidth);
        textView.setMinimumWidth(actualWidth);
        textView.setGravity(pageCount.getGravity());
        textView.setTextSize(pageCount.getTextSize());
        textView.setTextColor(pageCount.getTextColor());
        textView.setTypeface(Utils.createGetFont(pageCount.getFontStyle()));
        textView.setPadding(pageCount.getPaddingLeft(), pageCount.getPaddingTop(), pageCount.getPaddingRight(), pageCount.getPaddingBottom());
        return textView;
    }

    private int calculateActualWidth(PageCount pageCount) {
        return instance.getPageSize().getPageWidth() - (pageCount.getMarginLeft() + pageCount.getMarginRight());
    }
}
