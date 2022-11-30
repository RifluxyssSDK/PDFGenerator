package android.pdf.layout;

import android.content.Context;
import android.pdf.io.Sentence;
import android.view.View;
import android.widget.GridLayout;

import android.pdf.custom.Utils;
import android.pdf.io.Element;
import android.pdf.io.Image;
import android.pdf.io.Line;
import android.pdf.io.Paragraph;
import android.pdf.io.Text;
import android.pdf.kernel.ElementType;

/**
 * The type Create paragraph.
 */
public class CreateParagraph {

    /**
     * Create view.
     *
     * @param context         the context
     * @param singleColWeight the single col weight
     * @param paragraph       the paragraph
     * @param columnWeight    the column weight
     * @return the view
     */
    public View create(Context context, float singleColWeight, Paragraph paragraph, int columnWeight) {

        singleColWeight = initCalc(singleColWeight, paragraph, columnWeight);

        GridLayout gridLayout = createGrid(context, paragraph, columnWeight);

        for (Element element : paragraph.getElements()) {

            if (element.getElementType() == ElementType.LINE) {

                init(((Line) element).getColSpan(), columnWeight);
                gridLayout.addView(new CreateLine().create(context, singleColWeight, (Line) element));

            }

            if (element.getElementType() == ElementType.TEXT) {

                init(((Text) element).getColSpan(), columnWeight);
                gridLayout.addView(new CreateText().create(context, singleColWeight, (Text) element));

            }

            if (element.getElementType() == ElementType.IMAGE) {

                init(((Image) element).getColSpan(), columnWeight);
                gridLayout.addView(new CreateImage().create(context, singleColWeight, (Image) element));

            }

            if (element.getElementType() == ElementType.SENTENCE) {

                init(((Sentence) element).getColSpan(), columnWeight);
                gridLayout.addView(new CreateSentence().create(context, singleColWeight, (Sentence) element, columnWeight));

            }
        }

        return gridLayout;
    }

    /**
     * It throws error while colSpan less then columnWeight.
     *
     * @param colSpan      Current cell colSpan
     * @param columnWeight Maximum colCount
     */
    private void init(int colSpan, int columnWeight) {
        if (colSpan > columnWeight)
            throw new Error("column span mustn't exceed the column count. ( total column : " + columnWeight + ", cell colSpan : " + colSpan + " )");
    }

    /**
     * @param context      Context
     * @param paragraph    Paragraph
     * @param columnWeight Total columnCount
     * @return Basic GridLayout
     */
    private GridLayout createGrid(Context context, Paragraph paragraph, int columnWeight) {

        GridLayout gridLayout = new GridLayout(context);
        gridLayout.setColumnCount(columnWeight);
        gridLayout.setPadding(paragraph.getPaddingLeft(), paragraph.getPaddingTop(), paragraph.getPaddingRight(), paragraph.getPaddingBottom());
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, paragraph.getRowSpan(), paragraph.getRowSpan()), GridLayout.spec(GridLayout.UNDEFINED, paragraph.getColSpan(), paragraph.getColSpan()));


        if (paragraph.isBorder()) {

            layoutParams.setMargins(paragraph.getMarginLeft(), (paragraph.getMarginTop() - paragraph.getBorderWidth()), paragraph.getMarginRight(), paragraph.getMarginBottom());

            gridLayout.setBackground(Utils.createBorder(paragraph.getBackgroundColor(), paragraph.getBorderColor(), paragraph.getBorderWidth()));

        } else {

            layoutParams.setMargins(paragraph.getMarginLeft(), paragraph.getMarginTop(), paragraph.getMarginRight(), paragraph.getMarginBottom());

            gridLayout.setBackgroundColor(paragraph.getBackgroundColor());

        }

        gridLayout.setLayoutParams(layoutParams);

        return gridLayout;

    }

    /**
     * @param singleColWeight singleColWeight
     * @param paragraph       {@link Paragraph}
     * @param columnWeight    Maximum colCount
     * @return singleColumnWeight
     */
    private float initCalc(float singleColWeight, Paragraph paragraph, int columnWeight) {

        double minMaxWidth = singleColWeight * paragraph.getColSpan();
        int elementWidth = (int) (minMaxWidth - (paragraph.getMarginRight() + paragraph.getMarginLeft()));

        int marginWidth = paragraph.getMarginLeft() + paragraph.getMarginRight();
        int paddingWidth = paragraph.getPaddingLeft() + paragraph.getPaddingRight();
        int contentWidth = elementWidth - (marginWidth + paddingWidth);
        return (float) contentWidth / columnWeight;

    }
}
