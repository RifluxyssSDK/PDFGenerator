package android.pdf.customtext;

import android.content.Context;
import android.pdf.custom.Utils;
import android.text.Spannable;
import android.text.SpannableString;

import java.util.ArrayList;

/**
 * The type Text builder.
 */
public class TextBuilder {

    /**
     * It used to Context of the parent {@link Context}.
     */
    private final Context context;


    /**
     * Initialize the empty string of the variable {@code message}
     */
    private String message = "";

    /**
     * Initialize the empty Arraylist of the variable {@code textBuilderList}
     */
    private final ArrayList<TextBuilderModel> textBuilderList = new ArrayList<>();

    /**
     * Instantiates a new Text builder.
     *
     * @param context the context
     */
    public TextBuilder(Context context) {
        this.context = context;
    }

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

            spannable.setSpan( new CustomTypefaceSpan(textBuilderModel.getText(), Utils.createGetFont(context, textBuilderModel.getFontStyle())),
                    stringBuilder.length(), (stringBuilder.length() + textBuilderModel.getLength()), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            stringBuilder.append(textBuilderModel.getText());

        }

        return spannable;

    }
}
