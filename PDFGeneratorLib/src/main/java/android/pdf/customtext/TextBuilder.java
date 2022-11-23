package android.pdf.customtext;

import android.content.Context;
import android.pdf.custom.Utils;
import android.pdf.kernel.FontStyle;
import android.text.Spannable;
import android.text.SpannableString;

import java.util.ArrayList;

public class TextBuilder {

    private final Context context;

    private String message = "";
    private final ArrayList<Integer> length = new ArrayList<>();
    private final ArrayList<String> strings = new ArrayList<>();
    private final ArrayList<Byte> fontStyles = new ArrayList<>();



    public TextBuilder(Context context) {
        this.context = context;
    }

    public void append(String text, byte FontStyle) {
        message += text;
        strings.add(text);
        length.add(text.length());
        fontStyles.add(FontStyle);
    }

    public Spannable get() {

        StringBuilder temp = new StringBuilder();

        Spannable spannable = new SpannableString(message);

        for (int i = 0; i < fontStyles.size(); i++) {

            spannable.setSpan( new CustomTypefaceSpan(strings.get(i), Utils.createGetFont(context, fontStyles.get(i))),
                    temp.length(), temp.length() + strings.get(i).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            temp.append(strings.get(i));

        }

        return spannable;

    }
}
