package com.pdfutil;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;
import android.view.Gravity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.android.core.Document;
import com.android.custom.Utils;
import com.android.io.Image;
import com.android.io.Line;
import com.android.io.Paragraph;
import com.android.io.Text;
import com.android.kernel.DocType;
import com.android.kernel.FontStyle;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Document document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        document = new Document().init(this);

        document.open(20);

        document.setPadding(20,10,20,20);

//        createDocument();

        create();

        document.close();

        try {
            document.finish(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"Doc.pdf"));
            Toast.makeText(this, "Doc Created", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void create() {

        Typeface helveticaLight = Utils.createGetFont(this, FontStyle.HELVETICA_LIGHT);
        TypefaceSpan helveticaLightSpan = new CustomTypefaceSpan("", helveticaLight);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        String txt1="Customer certifies it  ";
        SpannableString txtSpannableNew = new SpannableString(txt1);
        txtSpannableNew.setSpan(helveticaLightSpan, 0, txtSpannableNew.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(txtSpannableNew);

        Typeface helveticaBold = Utils.createGetFont(this,FontStyle.HELVETICA_BOLD);
        TypefaceSpan helveticaBoldSpan = new CustomTypefaceSpan("", helveticaBold);

        SpannableString txtSpannable= new SpannableString("customerCertified");
        txtSpannable.setSpan(helveticaBoldSpan, 0, txtSpannable.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(txtSpannable);

        String txt2="  a federal, state or local government branch or agency";
        SpannableString txtSpannableLast = new SpannableString(txt2);
        txtSpannableNew.setSpan(helveticaLightSpan, 0, txtSpannableNew.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.append(txtSpannableLast);

    }

    private void createDocument() {

        addHeader();
        addInfo();
        addCustomerInfo();
        addGarments();
    }

    private void addGarments() {

        addHeaderText("Garments");

        document.add(new Paragraph()
                .add(new Text(1,11,"Garments").setTextSize(5).setFontStyle(FontStyle.HELVETICA).setPadding(5,3,3,3).setBackgroundColor(Color.rgb(243, 250, 253)).setBorder(true).setBorderColor(Color.LTGRAY))
                .add(new Text(1,3,"Frequency").setTextSize(5).setMarginLeft(-1).setFontStyle(FontStyle.HELVETICA).setPadding(5,3,3,3).setBackgroundColor(Color.rgb(243, 250, 253)).setBorder(true).setBorderColor(Color.LTGRAY))
                .add(new Text(1,3,"Inventory").setTextSize(5).setMarginLeft(-1).setFontStyle(FontStyle.HELVETICA).setPadding(5,3,3,3).setBackgroundColor(Color.rgb(243, 250, 253)).setBorder(true).setBorderColor(Color.LTGRAY))
                .add(new Text(1,3,"Unit Price").setTextSize(5).setMarginLeft(-1).setFontStyle(FontStyle.HELVETICA).setPadding(5,3,3,3).setBackgroundColor(Color.rgb(243, 250, 253)).setBorder(true).setBorderColor(Color.LTGRAY))
                .setMarginTop(5)
        );

        Drawable drawable = getDrawable(R.drawable.ic_garment);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

        for (int i = 0; i < 10; i++) {

            document.add(new Paragraph()
                    .add(new Image(2, 2, bitmap).setPadding(5).setImageWidth(50).setImageHeight(50))
                    .add(new Text(1, 9, "X10081").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setTextColor(Color.GRAY).setMarginTop(5))
                    .add(new Text(2, 3, "Weekly").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setGravity(Gravity.CENTER_VERTICAL).setPaddingLeft(5))
                    .add(new Text(2, 3, "11").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setGravity(Gravity.CENTER_VERTICAL).setPaddingLeft(5))
                    .add(new Text(2, 1, "$").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setTextColor(Color.GRAY).setGravity(Gravity.CENTER_VERTICAL).setPaddingLeft(5))
                    .add(new Text(2, 2, "0.00").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setGravity(Gravity.END | Gravity.CENTER_VERTICAL).setPaddingRight(5))
                    .add(new Text(1, 9, "X10081-GLENGUARD FR PANT").setFontStyle(FontStyle.HELVETICA).setTextSize(6))
                    .setBorder(true).setBorderColor(Color.LTGRAY).setMarginTop(-1)
            );

        }

        addHeaderText("Non - Garments");

        drawable = getDrawable(R.drawable.ic_nongarment);
        bitmap = ((BitmapDrawable) drawable).getBitmap();

        for (int i = 0; i < 10; i++) {

            document.add(new Paragraph()
                    .add(new Image(2, 2, bitmap).setPadding(5).setImageWidth(50).setImageHeight(50))
                    .add(new Text(1, 9, "X10081").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setTextColor(Color.GRAY).setMarginTop(5))
                    .add(new Text(2, 3, "Weekly").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setGravity(Gravity.CENTER_VERTICAL).setPaddingLeft(5))
                    .add(new Text(2, 3, "11").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setGravity(Gravity.CENTER_VERTICAL).setPaddingLeft(5))
                    .add(new Text(2, 1, "$").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setTextColor(Color.GRAY).setGravity(Gravity.CENTER_VERTICAL).setPaddingLeft(5))
                    .add(new Text(2, 2, "0.00").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setGravity(Gravity.END | Gravity.CENTER_VERTICAL).setPaddingRight(5))
                    .add(new Text(1, 9, "X10081-GLENGUARD FR PANT").setFontStyle(FontStyle.HELVETICA).setTextSize(6))
                    .setBorder(true).setBorderColor(Color.LTGRAY).setMarginTop(-1)
            );

        }

    }

    private void addHeaderText(String message) {

        document.add(new Paragraph()
                .add(new Text(1,20,message).setTextSize(8).setFontStyle(FontStyle.HELVETICA).setMarginTop(5))
        );

    }

    private void addCustomerInfo() {

        document.add(new Paragraph()
                .add(new Text(1,10,"Customer Name").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1,10,"DBA Name").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1,10,"A Jazz Trio Ned Kentar Prdctns").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1,10,"A Jazz Trio Ned Kentar Prdctns").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1,10,"Delivery Address :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1,10,"Delivery Address 2 :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1,10,"3430 Saint Paul Ave12-test").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1,10,"3430 Saint Paul Ave12-test").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1,5,"City :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1,5,"State / Province :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1,5,"Zip / Postal Code :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1,5,"Phone :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1,5,"MINNEAPOLIS").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1,5,"MN").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1,5,"55438").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1,5,"6129265655").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .setPadding(10,5,10,5).setBorder(true).setBorderColor(Color.GRAY).setMarginTop(15)
        );

        addSmallText("*This agreement is effective as of the date of execution for a term of 80 months from the date of installation.");

    }

    private void addSmallText(String message) {

        document.add(new Paragraph()
                .add(new Text(1,20,message).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(5))
        );

    }

    private void addInfo() {

        document.add(new Paragraph()

                .add(new Text(1,16,"Service Location No :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA))
                .add(new Text(1,4,"0009").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA))
                .add(new Text(1,16,"").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA))
                .add(new Line(1,4).setLineColor(Color.GRAY).setMarginTop(-2))

                .add(new Text(1,4,""))
                .add(new Text(1,4,"MLRA/NA :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))
                .add(new Text(1,4,"").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))
                .add(new Text(1,4,"Account Number :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))
                .add(new Text(1,4,"").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))

                .add(new Text(1,8,""))
                .add(new Line(1,4).setLineColor(Color.GRAY).setMarginTop(-2))
                .add(new Text(1,4,""))
                .add(new Line(1,4).setLineColor(Color.GRAY).setMarginTop(-2))

                .add(new Text(1,4,""))
                .add(new Text(1,4,"Contract No :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))
                .add(new Text(1,4,"").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))
                .add(new Text(1,4,"Date :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))
                .add(new Text(1,4,"").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))

                .add(new Text(1,8,""))
                .add(new Line(1,4).setLineColor(Color.GRAY).setMarginTop(-2))
                .add(new Text(1,4,""))
                .add(new Line(1,4).setLineColor(Color.GRAY).setMarginTop(-2))

                .add(new Text(1,4,""))
                .add(new Text(1,4,"Business Index :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))
                .add(new Text(1,4,"").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))
                .add(new Text(1,4,"Dynamics ID :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))
                .add(new Text(1,4,"2b7ab1c0 -5820 -e811 -a836 -000d3a13a101").setGravity(Gravity.END).setTextSize(3).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))

                .add(new Text(1,8,""))
                .add(new Line(1,4).setLineColor(Color.GRAY).setMarginTop(-2))
                .add(new Text(1,4,""))
                .add(new Line(1,4).setLineColor(Color.GRAY).setMarginTop(-2))
        );
    }

    private void addHeader() {

        Drawable drawable = getDrawable(R.drawable.logo_print);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

        document.add(new Paragraph()
                .add(new Text(1,15,"RENTAL SERVICE AGREEMENT").setTextColor(Color.rgb(0, 153, 204)).setTextSize(9).setFontStyle(FontStyle.HELVETICA_BOLD))
                .add(new Image(2,5,bitmap).setPadding(10))
                .add(new Text(1,15,"").setTextColor(Color.rgb(0, 153, 204)).setTextSize(9).setFontStyle(FontStyle.HELVETICA_BOLD))
                .setMarginBottom(15)
        );

    }
}