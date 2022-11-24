package android.pdf.customtext;

import android.content.Context;
import android.pdf.custom.Utils;
import android.text.Spannable;
import android.text.SpannableString;

import java.util.ArrayList;

public class TextBuilder {

    private final Context context;

    private String message = "";
    private final ArrayList<TextBuilderModel> textBuilderList = new ArrayList<>();

    public TextBuilder(Context context) {
        this.context = context;
    }

    public void append(String text, byte FontStyle) {
        message += text;
        textBuilderList.add(new TextBuilderModel(text,text.length(),FontStyle));
    }

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
