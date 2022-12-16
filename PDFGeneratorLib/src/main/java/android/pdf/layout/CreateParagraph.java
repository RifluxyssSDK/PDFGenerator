package android.pdf.layout;

import android.pdf.cell.Paragraph;
import android.pdf.constant.ElementType;
import android.pdf.core.Instance;
import android.pdf.element.Image;
import android.pdf.element.Line;
import android.pdf.element.Sentence;
import android.pdf.element.Text;
import android.pdf.io.Element;
import android.pdf.utility.Utils;
import android.view.View;
import android.widget.GridLayout;

/**
 * The type Create paragraph.
 */
public class CreateParagraph extends Instance {

    private final GridLayout gridLayout = new GridLayout(getContext());

    /**
     * Create view.
     *
     * @param paragraph the paragraph
     * @return the view
     */
    public View create(Paragraph paragraph) {

        float width = calculateParagraphWidth(paragraph);

        initialization(paragraph);
        initializeLayoutParam(paragraph);

        for (Element element : paragraph.getElements()) {

            switch (element.getElementType()) {
                case ElementType.LINE:
                    gridLayout.addView(new CreateLine().create(width, (Line) element));
                    break;
                case ElementType.TEXT:
                    gridLayout.addView(new CreateText().create(width, (Text) element));
                    break;
                case ElementType.IMAGE:
                    gridLayout.addView(new CreateImage().create(width, (Image) element));
                    break;
                case ElementType.SENTENCE:
                    gridLayout.addView(new CreateSentence().create(width, (Sentence) element));
                    break;
            }
        }
        return gridLayout;
    }

    private void initialization(Paragraph paragraph) {
        gridLayout.setColumnCount(getColumnWeight());
        gridLayout.setPadding(
                paragraph.getPaddingLeft(),
                paragraph.getPaddingTop(),
                paragraph.getPaddingRight(),
                paragraph.getPaddingBottom()
        );
        if (paragraph.isBorder()) {
            gridLayout.setBackground(
                    Utils.createBorder(
                            paragraph.getBackgroundColor(),
                            paragraph.getBorderColor(),
                            paragraph.getBorderWidth()
                    )
            );
        } else {
            gridLayout.setBackgroundColor(paragraph.getBackgroundColor());
        }
    }

    private void initializeLayoutParam(Paragraph paragraph) {
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, (1), (1)),
                GridLayout.spec(GridLayout.UNDEFINED, getColumnWeight(), getColumnWeight())
        );

        layoutParams.setMargins(
                paragraph.getMarginLeft(),
                paragraph.isBorder() ? (paragraph.getMarginTop() - paragraph.getBorderWidth()) : paragraph.getMarginTop(),
                paragraph.getMarginRight(),
                paragraph.getMarginBottom()
        );
        gridLayout.setLayoutParams(layoutParams);
    }

    private float calculateParagraphWidth(Paragraph paragraph) {
        int marginWidth = paragraph.getMarginLeft() + paragraph.getMarginRight();
        int paddingWidth = paragraph.getPaddingLeft() + paragraph.getPaddingRight();
        double width = getPageSize().getPageWidth() - marginWidth - paddingWidth;
        return (float) width / getColumnWeight();
    }
}
