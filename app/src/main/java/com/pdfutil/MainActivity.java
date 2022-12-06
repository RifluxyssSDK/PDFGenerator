package com.pdfutil;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.pdf.cell.Paragraph;
import android.pdf.constant.FontStyle;
import android.pdf.core.Document;
import android.pdf.customtext.TextBuilder;
import android.pdf.element.Image;
import android.pdf.element.Line;
import android.pdf.element.Sentence;
import android.pdf.element.Text;
import android.pdf.io.PageCount;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Document document;

    private Long fileSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        document = new Document().init(this);

        document.open(20);

        document.setPadding(20, 10, 20, 10);

        String  currentDateTimeString = DateFormat.getDateTimeInstance()
                .format(new Date());

        Log.e("status","check Duration ===> " +currentDateTimeString);

        verifySDK();

        addPageNumbers();

        document.close();

        try {

            File fileCompress = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "document");
            if (!fileCompress.exists()) {
                fileCompress.mkdirs();
            }
            File imageFileCom = new File(fileCompress, "Document.pdf");

            document.finish(imageFileCom);

            String  currentDateTimeString1 = DateFormat.getDateTimeInstance()
                    .format(new Date());

            Log.e("status","check Duration ===> " +currentDateTimeString1);

            Toast.makeText(this, "Doc Created", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {

            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

        }
    }


    private void addPageNumbers() {

        document.setPageCount(new PageCount("Page ", " / ").setTextColor(Color.GRAY).setGravity(Gravity.CENTER).setTextSize(5).setPadding(5));

    }

    private void verifySDK() {

        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.four_cover, "four_cover")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.five_ur_differentiator_page, "five_ur_differentiator_page")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.six_fs_differentiator_page, "six_fs_differentiator_page")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.seven_comfort_shirt, "six_fs_differentiator_page")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.eight_wrinkle_free_shirt, "eight_wrinkle_free_shirt")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.eight_wrinkle_free_shirt, "eight_wrinkle_free_shirt1")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.nine_performance_polo, "nine_performance_polo")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.ten_oxford_exec_cargo, "ten_oxford_exec_cargo")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.eleven_pro_knit_argyle_polo, "eleven_pro_knit_argyle_polo")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twelve_cargo_comfort_jeans, "twelve_cargo_comfort_jeans")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thireteen_pro_knit_tee_cargo_shorts, "thireteen_pro_knit_tee_cargo_shorts")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.forteen_women_workwear_a, "forteen_women_workwear_a")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.fifteen_women_workwear_b, "fifteen_women_workwear_b")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.sixteen_carhartt, "sixteen_carhartt")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.seventeen_carhartt_fr, "seventeen_carhartt_fr")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.seventeen_carhartt_fr, "seventeen_carhartt_fr1")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.eighteen_carhartt_fr_enhanced_visibility, "eighteen_carhartt_fr_enhanced_visibility")).setCompressImage(true).setImageWidth(631).setImageHeight(832).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.eighteen_carhartt_fr_enhanced_visibility, "eighteen_carhartt_fr_enhanced_visibility1")).setCompressImage(true).setImageWidth(631).setImageHeight(832).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.ninteen_tecasafe, "ninteen_tecasafe")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twenty_fr_outerwear, "twenty_fr_outerwear")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyone_e_viz_tecasafe_a, "twentyone_e_viz_tecasafe_a")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twenty_two_viz_tecasafe_b, "twenty_two_viz_tecasafe_b")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentythree_e_viz_tecasafe_c, "twentythree_e_viz_tecasafe_c")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyfour_high_visibility_shirt, "twentyfour_high_visibility_shirt")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyfour_high_visibility_shirt, "twentyfour_high_visibility_shirt1")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyfive_enhanced_visibility, "twentyfive_enhanced_visibility")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentysix_hundred_cotton, "twentysix_hundred_cotton")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyseven_food_pharma, "twentyseven_food_pharma")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyeight_culinary, "twentyeight_culinary")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentynine_chef_essential, "twentynine_chef_essential")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirty_chef_signature, "thirty_chef_signature")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtyone_outerwear, "thirtyone_outerwear")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtytwo_floor_zone, "thirtytwo_floor_zone")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtythree_supply_closet, "thirtythree_supply_closet")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtyfour_restroom_zone, "thirtyfour_restroom_zone")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtyfive_kitchen_zone, "thirtyfive_kitchen_zone")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtysix_shop_zone, "thirtysix_shop_zone")).setImageWidth(631).setImageHeight(832).setCompressImage(true).setCompressLevel(80)));
    }

    private void checkSentence() {

        document.add(new Paragraph()
                .add(new Sentence(1, 10)
                        .add(new Text(1, 20, "HELLO WORLD").setBackgroundColor(Color.GREEN).setPadding(5).setTextColor(Color.WHITE))
                        .setBorder(true).setBorderColor(Color.RED).setPadding(10).setMargin(10)
                )
                .add(new Sentence(1, 10)
                        .add(new Text(1, 20, "HELLO WORLD").setBackgroundColor(Color.GREEN).setPadding(5).setTextColor(Color.WHITE))
                        .setBorder(true).setBorderColor(Color.RED).setPadding(10).setMarginLeft(-1).setMargin(10)
                )
                .add(new Sentence(1, 6)
                        .add(new Text(1, 20, "HELLO WORLD").setBackgroundColor(Color.GREEN).setPadding(5).setTextColor(Color.WHITE))
                        .setBorder(true).setBorderColor(Color.RED).setPadding(10).setMargin(10)
                )
                .add(new Sentence(1, 8)
                        .add(new Text(1, 20, "HELLO WORLD").setBackgroundColor(Color.GREEN).setPadding(5).setTextColor(Color.WHITE))
                        .setBorder(true).setBorderColor(Color.RED).setPadding(10).setMarginLeft(-1).setMargin(10)
                )
                .add(new Sentence(1, 6)
                        .add(new Text(1, 20, "HELLO WORLD").setBackgroundColor(Color.GREEN).setPadding(5).setTextColor(Color.WHITE))
                        .setBorder(true).setBorderColor(Color.RED).setPadding(10).setMargin(10)
                )
                .setBackgroundColor(Color.GRAY).setBorder(true)
        );
    }

    private void create() {

        TextBuilder textBuilder = new TextBuilder(this);

        textBuilder.append("HELVETICA\n", FontStyle.HELVETICA);
        textBuilder.append("HELVETICA_BOLD\n", FontStyle.HELVETICA_BOLD);
        textBuilder.append("HELVETICA_LIGHT\n", FontStyle.HELVETICA_LIGHT);
        textBuilder.append("HELVETICA_OBLIQUE\n", FontStyle.HELVETICA_OBLIQUE);
        textBuilder.append("HELVETICA_COMPRESSED\n", FontStyle.HELVETICA_COMPRESSED);

        document.add(new Paragraph()
                .add(new Text(1, 20, "textBuilder").setTextColor(Color.BLUE).setBorder(true).setPadding(5))
        );

        for (int i = 0; i < 30; i++) {
            document.add(new Paragraph()
                    .add(new Text(1, 20, textBuilder).setTextColor(Color.BLUE).setBorder(true).setPadding(5))
            );
        }

    }

    private void createDocument() {

        addHeader();
        addInfo();
        addCustomerInfo();
        addGarments();

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void addGarments() {

        addHeaderText("Garments");

        document.add(new Paragraph()
                .add(new Text(1, 11, "Garments").setTextSize(5).setFontStyle(FontStyle.HELVETICA).setPadding(5, 3, 3, 3).setBackgroundColor(Color.rgb(243, 250, 253)).setBorder(true).setBorderColor(Color.LTGRAY))
                .add(new Text(1, 3, "Frequency").setTextSize(5).setMarginLeft(-1).setFontStyle(FontStyle.HELVETICA).setPadding(5, 3, 3, 3).setBackgroundColor(Color.rgb(243, 250, 253)).setBorder(true).setBorderColor(Color.LTGRAY))
                .add(new Text(1, 3, "Inventory").setTextSize(5).setMarginLeft(-1).setFontStyle(FontStyle.HELVETICA).setPadding(5, 3, 3, 3).setBackgroundColor(Color.rgb(243, 250, 253)).setBorder(true).setBorderColor(Color.LTGRAY))
                .add(new Text(1, 3, "Unit Price").setTextSize(5).setMarginLeft(-1).setFontStyle(FontStyle.HELVETICA).setPadding(5, 3, 3, 3).setBackgroundColor(Color.rgb(243, 250, 253)).setBorder(true).setBorderColor(Color.LTGRAY))
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

            document.add(new Paragraph().add(new Image(2, 2, bitmap).setPadding(5).setImageWidth(50).setImageHeight(50)).add(new Text(1, 9, "X10081").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setTextColor(Color.GRAY).setMarginTop(5)).add(new Text(2, 3, "Weekly").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setGravity(Gravity.CENTER_VERTICAL).setPaddingLeft(5)).add(new Text(2, 3, "11").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setGravity(Gravity.CENTER_VERTICAL).setPaddingLeft(5)).add(new Text(2, 1, "$").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setTextColor(Color.GRAY).setGravity(Gravity.CENTER_VERTICAL).setPaddingLeft(5)).add(new Text(2, 2, "0.00").setFontStyle(FontStyle.HELVETICA).setTextSize(6).setGravity(Gravity.END | Gravity.CENTER_VERTICAL).setPaddingRight(5)).add(new Text(1, 9, "X10081-GLENGUARD FR PANT").setFontStyle(FontStyle.HELVETICA).setTextSize(6)).setBorder(true).setBorderColor(Color.LTGRAY).setMarginTop(-1));

        }

    }

    private void addHeaderText(String message) {

        document.add(new Paragraph().add(new Text(1, 20, message).setTextSize(8).setFontStyle(FontStyle.HELVETICA).setMarginTop(5)));

    }

    private void addCustomerInfo() {

        document.add(new Paragraph()
                .add(new Text(1, 10, "Customer Name").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1, 10, "DBA Name").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1, 10, "A Jazz Trio Ned Kentar Prdctns").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1, 10, "A Jazz Trio Ned Kentar Prdctns").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1, 10, "Delivery Address :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1, 10, "Delivery Address 2 :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1, 10, "3430 Saint Paul Ave12-test").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1, 10, "3430 Saint Paul Ave12-test").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1, 5, "City :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1, 5, "State / Province :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1, 5, "Zip / Postal Code :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1, 5, "Phone :").setFontStyle(FontStyle.HELVETICA).setTextSize(5))
                .add(new Text(1, 5, "MINNEAPOLIS").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1, 5, "MN").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1, 5, "55438").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .add(new Text(1, 5, "6129265655").setFontStyle(FontStyle.HELVETICA_BOLD).setTextSize(5))
                .setPadding(10, 5, 10, 5).setBorder(true).setBorderColor(Color.GRAY).setMarginTop(15)
        );

        addSmallText("*This agreement is effective as of the date of execution for a term of 80 months from the date of installation.");

    }

    private void addSmallText(String message) {

        document.add(new Paragraph().add(new Text(1, 20, message).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(5)));

    }

    private void addInfo() {

        document.add(new Paragraph()

                .add(new Text(1, 16, "Service Location No :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA)).add(new Text(1, 4, "0009").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA)).add(new Text(1, 16, "").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA)).add(new Line(1, 4).setLineColor(Color.GRAY).setMarginTop(-2))

                .add(new Text(1, 4, "")).add(new Text(1, 4, "MLRA/NA :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2)).add(new Text(1, 4, "").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2)).add(new Text(1, 4, "Account Number :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2)).add(new Text(1, 4, "").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))

                .add(new Text(1, 8, "")).add(new Line(1, 4).setLineColor(Color.GRAY).setMarginTop(-2)).add(new Text(1, 4, "")).add(new Line(1, 4).setLineColor(Color.GRAY).setMarginTop(-2))

                .add(new Text(1, 4, "")).add(new Text(1, 4, "Contract No :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2)).add(new Text(1, 4, "").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2)).add(new Text(1, 4, "Date :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2)).add(new Text(1, 4, "").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))

                .add(new Text(1, 8, "")).add(new Line(1, 4).setLineColor(Color.GRAY).setMarginTop(-2)).add(new Text(1, 4, "")).add(new Line(1, 4).setLineColor(Color.GRAY).setMarginTop(-2))

                .add(new Text(1, 4, "")).add(new Text(1, 4, "Business Index :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2)).add(new Text(1, 4, "").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2)).add(new Text(1, 4, "Dynamics ID :").setGravity(Gravity.END).setTextSize(5).setFontStyle(FontStyle.HELVETICA).setMarginTop(2)).add(new Text(1, 4, "2b7ab1c0 -5820 -e811 -a836 -000d3a13a101").setGravity(Gravity.END).setTextSize(3).setFontStyle(FontStyle.HELVETICA).setMarginTop(2))

                .add(new Text(1, 8, "")).add(new Line(1, 4).setLineColor(Color.GRAY).setMarginTop(-2)).add(new Text(1, 4, "")).add(new Line(1, 4).setLineColor(Color.GRAY).setMarginTop(-2)));
    }

    private void addHeader() {

        @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = getDrawable(R.drawable.logo_print);
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();

        document.add(new Paragraph().add(new Text(1, 15, "RENTAL SERVICE AGREEMENT").setTextColor(Color.rgb(0, 153, 204)).setTextSize(9).setFontStyle(FontStyle.HELVETICA_BOLD)).add(new Image(2, 5, bitmap).setPadding(10)).add(new Text(1, 15, "").setTextColor(Color.rgb(0, 153, 204)).setTextSize(9).setFontStyle(FontStyle.HELVETICA_BOLD)).setMarginBottom(15));

    }


    public Bitmap compressImage(int resourceUri, String fileName) {

        Bitmap scaledBitmap = null;
        byte[] decodedString;

        try {

            InputStream XmlFileInputStream = getResources().openRawResource(resourceUri);

            byte[] b = new byte[XmlFileInputStream.available()];
            XmlFileInputStream.read(b);

            decodedString = Base64.decode(new String(b), Base64.DEFAULT);
            scaledBitmap =  BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);



           /* File imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "images");
            if (!imageFile.exists()) { imageFile.mkdirs(); }

            File imageResourceFile = new File(imageFile,fileName + ".jpeg");

            //Convert bitmap to byte array
            originalBitmap.compress(Bitmap.CompressFormat.WEBP, 80, new FileOutputStream(imageResourceFile)); // YOU can also save it in JPEG

            File compressImageFile = compressImageFile(imageResourceFile,fileName);

            BitmapFactory.Options optionsImage = new BitmapFactory.Options();
            // explicitly state everything so the configuration is clear
            optionsImage.inPreferredConfig = Bitmap.Config.RGB_565;

            scaledBitmap = BitmapFactory.decodeStream(new FileInputStream(compressImageFile),null,optionsImage);*/


            /*  if (compressImageFile.exists()) { compressImageFile.delete(); imageResourceFile.delete(); }*/


            //scaledBitmap = compressImageBitmap(imageFile.getAbsolutePath(),originalBitmap);


            /*Bitmap createdBitmap
            scaledBitmap = createdBitmap.copy(Bitmap.Config.ARGB_8888,true);*/

           /* Bitmap createdBitmap = Bitmap.createScaledBitmap(originalBitmap,631,832,true);

            String filePath = getRealPathFromURI(imageFile.getAbsolutePath());
            BitmapFactory.Options options1 = new BitmapFactory.Options();
            Bitmap decodeFileBitmap = BitmapFactory.decodeFile(filePath, options1);*/


        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return scaledBitmap;

    }

    private File compressImageFile(File imageFile,String fileName) {

        try {
            // write the compressed bitmap at the destination specified by destinationPath.
            decodeSampledBitmapFromFile(imageFile, 579,771).compress( Bitmap.CompressFormat.WEBP, 80, new FileOutputStream(imageFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageFile;

    }

    private Bitmap decodeSampledBitmapFromFile(File imageFile, int reqWidth, int reqHeight) throws IOException {
        // First decode with inJustDecodeBounds=true to check dimensions
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        Bitmap scaledBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);

        //check the rotation of the image and display it properly
        Matrix matrix = new Matrix();

        scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, false);
        return scaledBitmap;
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}