package android.pdf.customtext;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/**
 * The type Custom typeface span.
 */
public class CustomTypefaceSpan extends TypefaceSpan {

    private final Typeface newType;

    /**
     * Instantiates a new Custom typeface span.
     *
     * @param family the family
     * @param type   the type
     */
    public CustomTypefaceSpan(String family, Typeface type) {
        super(family);
        this.newType = type;
    }


    /**
     * @param ds
     * Passes ds through to the underlying CharacterStyle.
     */
    @Override
    public void updateDrawState(TextPaint ds) {
        applyCustomTypeFace(ds, newType);
    }

    /**
     * @param paint
     * Passes paint through to the bold, italic of the CharacterStyle.
     */
    @Override
    public void updateMeasureState(TextPaint paint) {
        applyCustomTypeFace(paint, newType);
    }

    /**
     * Returns an Typeface Object that can then be painted on the screen.
     * The typeFace argument must specify an absolute {@link Typeface}. The name
     * argument is a specifier that is relative to the typeFace argument.
     * <p>
     * This method always returns immediately, whether or not the
     * text exists.
     *
     * @param  typeFace  an absolute typeFace font giving the base location of the text
     * @param  paint the typeFace of the font & bold text & italic text of the text
     * @see    TypefaceSpan
     */
    private void applyCustomTypeFace(Paint paint, Typeface typeFace) {

        Typeface old = paint.getTypeface();
        int oldStyle = old == null ? 0 : old.getStyle();

        int fake = oldStyle & typeFace.getStyle();
        boolean boldText = (fake & Typeface.BOLD) != 0;
        paint.setFakeBoldText(boldText);

        float skewX = (fake & Typeface.ITALIC) != 0 ? -0.25f : 0f;
        paint.setTextSkewX(skewX);

        paint.setTypeface(typeFace);

    }
}