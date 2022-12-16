package android.pdf.layout;

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
 * The type Create sentence.
 */
public class CreateSentence extends Instance {

    private final GridLayout gridLayout = new GridLayout(getContext());

    /**
     * Create view.
     *
     * @param sentenceWidth the sentence width
     * @param sentence      the sentence
     * @return the view
     */
    public View create(float sentenceWidth, Sentence sentence) {

        float width = calculateSentenceWidth(sentenceWidth, sentence);

        initialization(sentence);
        initializeLayoutParam(sentence);

        for (Element element : sentence.getElements()) {

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
        } return gridLayout;
    }

    private void initializeLayoutParam(Sentence sentence) {
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, sentence.getRowSpan(), sentence.getRowSpan()),
                GridLayout.spec(GridLayout.UNDEFINED, sentence.getColSpan(), sentence.getColSpan())
        );

        layoutParams.setMargins(
                sentence.getMarginLeft(),
                sentence.getMarginTop(),
                sentence.getMarginRight(),
                sentence.getMarginBottom()
        );
        gridLayout.setLayoutParams(layoutParams);
    }

    private void initialization(Sentence sentence) {
        gridLayout.setColumnCount(getColumnWeight());
        gridLayout.setPadding(
                sentence.getPaddingLeft(),
                sentence.getPaddingTop(),
                sentence.getPaddingRight(),
                sentence.getPaddingBottom()
        );
        if (sentence.isBorder()) {
            gridLayout.setBackground(
                    Utils.createBorder(
                            sentence.getBackgroundColor(),
                            sentence.getBorderColor(),
                            sentence.getBorderWidth()
                    )
            );
        } else {
            gridLayout.setBackgroundColor(sentence.getBackgroundColor());
        }
    }

    private float calculateSentenceWidth(float sentenceWidth, Sentence sentence) {
        double minMaxWidth = sentenceWidth * sentence.getColSpan();
        int marginWidth = sentence.getMarginLeft() + sentence.getMarginRight();
        int paddingWidth = sentence.getPaddingLeft() + sentence.getPaddingRight();
        double contentWidth = minMaxWidth - (marginWidth + paddingWidth);
        return (float) contentWidth / getColumnWeight();
    }
}

