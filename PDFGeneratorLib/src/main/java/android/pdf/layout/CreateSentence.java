package android.pdf.layout;

import android.content.Context;
import android.pdf.io.Sentence;
import android.view.View;
import android.widget.GridLayout;

import android.pdf.custom.Utils;
import android.pdf.io.Element;
import android.pdf.io.Image;
import android.pdf.io.Line;
import android.pdf.io.Text;
import android.pdf.kernel.ElementType;

/**
 * The type Create paragraph.
 */
public class CreateSentence {

    /**
     * Create view.
     *
     * @param context         the context
     * @param singleColWeight the singleCol weight
     * @param sentence        the sentence
     * @return the view
     */
    public View create(Context context, float singleColWeight, Sentence sentence, int columnWeight) {

        singleColWeight = initCalc(singleColWeight, sentence, columnWeight);

        GridLayout gridLayout = createGrid(context, sentence, columnWeight);

        for (Element element : sentence.getElements()) {

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

                init(((Image) element).getColSpan(), columnWeight);
                gridLayout.addView(new CreateImage().create(context, singleColWeight, (Image) element));

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
     * @param sentence     Paragraph
     * @param columnWeight Total columnCount
     * @return Basic GridLayout
     */
    private GridLayout createGrid(Context context, Sentence sentence, int columnWeight) {

        GridLayout gridLayout = new GridLayout(context);
        gridLayout.setColumnCount(columnWeight);
        gridLayout.setPadding(sentence.getPaddingLeft(), sentence.getPaddingTop(), sentence.getPaddingRight(), sentence.getPaddingBottom());
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, sentence.getRowSpan(), sentence.getRowSpan()), GridLayout.spec(GridLayout.UNDEFINED, sentence.getColSpan(), sentence.getColSpan()));
        layoutParams.setMargins(sentence.getMarginLeft(), sentence.getMarginTop(), sentence.getMarginRight(), sentence.getMarginBottom());
        gridLayout.setLayoutParams(layoutParams);

        if (sentence.isBorder()) {
            gridLayout.setBackground(Utils.createBorder(sentence.getBackgroundColor(), sentence.getBorderColor(), sentence.getBorderWidth()));
        }

        return gridLayout;

    }

    /**
     * @param singleColWeight singleColWeight
     * @param sentence        {@link Sentence}
     * @param columnWeight    Maximum colCount
     * @return singleColumnWeight
     */
    private float initCalc(float singleColWeight, Sentence sentence, int columnWeight) {

        double minMaxWidth = singleColWeight * sentence.getColSpan();
        int elementWidth = (int) (minMaxWidth - (sentence.getMarginRight() + sentence.getMarginLeft()));

        int marginWidth = sentence.getMarginLeft() + sentence.getMarginRight();
        int paddingWidth = sentence.getPaddingLeft() + sentence.getPaddingRight();
        int contentWidth = elementWidth - (marginWidth + paddingWidth);
        return (float) contentWidth / columnWeight;

    }
}

