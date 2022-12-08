package android.pdf.layout;

import android.pdf.core.Instance;
import android.pdf.element.Text;
import android.pdf.io.PageCount;
import android.view.View;

public class CreatePageCount {

    private final Instance instance = Instance.getInstance();

    public View create(int currentPageCount) {

        PageCount pageCount = instance.getPageCount();
        String message = pageCount.getStartMessage() + currentPageCount + pageCount.getMiddleMessage() + pageCount.getTotalPageCount();

        Text text = new Text((1), Instance.getInstance().getColumnWeight(), message);

        text.setBorder(pageCount.isBorder());
        text.setGravity(pageCount.getGravity());
        text.setTextSize(pageCount.getTextSize());
        text.setTextColor(pageCount.getTextColor());
        text.setFontStyle(pageCount.getFontStyle());
        text.setMargin(pageCount.getMarginLeft(), pageCount.getMarginTop(), pageCount.getMarginRight(), pageCount.getMarginBottom());
        text.setPadding(pageCount.getPaddingLeft(), pageCount.getPaddingTop(), pageCount.getPaddingRight(), pageCount.getPaddingBottom());

        return new View(Instance.getInstance().getContext());
    }
}
