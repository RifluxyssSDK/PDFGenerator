package android.pdf.customtext;

import android.content.Context;
import android.pdf.utility.Utils;
import android.text.Spannable;
import android.text.SpannableString;

import java.util.ArrayList;

/**
 * The type Text builder.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class TextBuilder {

    /**
     * Initialize the empty string of the variable {@code message}
     */
    private String message = "";

    /**
     * Initialize the empty Arraylist of the variable {@code textBuilderList}
     */
    private final ArrayList<TextBuilderModel> textBuilderList = new ArrayList<>();

    /**
     * Append.
     *
     * @param text      the text
     * @param FontStyle the font style
     */
    public void append(String text, byte FontStyle) {
        message += text;
        textBuilderList.add(new TextBuilderModel(text,text.length(),FontStyle));
    }

    /**
     * Get spannable.
     *
     * @return the spannable
     */
    public Spannable get() {

        StringBuilder stringBuilder = new StringBuilder();
        Spannable spannable = new SpannableString(message);

        for (int i = 0; i < textBuilderList.size(); i++) {

            TextBuilderModel textBuilderModel = textBuilderList.get(i);
            spannable.setSpan(new CustomTypefaceSpan(textBuilderModel.getText(), Utils.createGetFont(textBuilderModel.getFontStyle())), stringBuilder.length(), (stringBuilder.length() + textBuilderModel.getLength()), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            stringBuilder.append(textBuilderModel.getText());
        }

        return spannable;
    }
}
