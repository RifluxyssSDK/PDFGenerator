package android.pdf.customtext;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class TextBuilderModel {

    private final int length;
    private final String text;
    private final byte fontStyle;

    public TextBuilderModel(String text, int length, byte fontStyle) {
        this.text = text;
        this.length = length;
        this.fontStyle = fontStyle;
    }

    public int getLength() {
        return length;
    }

    public byte getFontStyle() {
        return fontStyle;
    }

    public String getText() {
        return text;
    }
}
