package android.pdf.customtext;

/**
 * The type Text builder model.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class TextBuilderModel {

    private final int length;
    private final String text;
    private final byte fontStyle;

    /**
     * Instantiates a new Text builder model.
     *
     * @param text      the text
     * @param length    the length
     * @param fontStyle the font style
     */
    public TextBuilderModel(String text, int length, byte fontStyle) {
        this.text = text;
        this.length = length;
        this.fontStyle = fontStyle;
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * Gets font style.
     *
     * @return the font style
     */
    public byte getFontStyle() {
        return fontStyle;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }
}
