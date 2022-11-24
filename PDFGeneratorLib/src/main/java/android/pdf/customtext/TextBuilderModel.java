package android.pdf.customtext;

/**
 * The type Text builder model.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class TextBuilderModel {

    /**
     * Initialize the empty int of the variable {@code length}
     */
    private final int length;
    /**
     * Initialize the empty string of the variable {@code text}
     */
    private final String text;
    /**
     * Initialize the empty byte of the variable {@code fontStyle}
     */
    private final byte fontStyle;

    /**
     * Instantiates a new Text builder model.
     *
     * @param text      the text initialized the value of the text
     * @param length    the length initialized the value of the length
     * @param fontStyle the font style initialized the object of the fontStyle
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
