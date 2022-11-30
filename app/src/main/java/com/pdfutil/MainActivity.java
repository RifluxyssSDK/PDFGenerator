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
import android.pdf.core.Document;
import android.pdf.customtext.TextBuilder;
import android.pdf.io.Sentence;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.pdf.io.Image;
import android.pdf.io.Line;
import android.pdf.io.Paragraph;
import android.pdf.io.Text;
import android.pdf.kernel.FontStyle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Document document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        document = new Document().init(this);

        document.open(20);

        document.setPadding(20, 10, 20, 10);

//        createDocument();

//        create();

//        checkSentence();

        verifySDK();

        document.close();

        try {

            document.finish(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Doc.pdf"));

            Toast.makeText(this, "Doc Created", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {

            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    private void verifySDK() {

        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.four_cover, "four_cover"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.five_ur_differentiator_page, "five_ur_differentiator_page"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.six_fs_differentiator_page, "six_fs_differentiator_page"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.seven_comfort_shirt, "six_fs_differentiator_page"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.eight_wrinkle_free_shirt, "eight_wrinkle_free_shirt"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.eight_wrinkle_free_shirt, "eight_wrinkle_free_shirt1"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.nine_performance_polo, "nine_performance_polo"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.ten_oxford_exec_cargo, "ten_oxford_exec_cargo"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.eleven_pro_knit_argyle_polo, "eleven_pro_knit_argyle_polo"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twelve_cargo_comfort_jeans, "twelve_cargo_comfort_jeans"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thireteen_pro_knit_tee_cargo_shorts, "thireteen_pro_knit_tee_cargo_shorts"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.forteen_women_workwear_a, "forteen_women_workwear_a"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.fifteen_women_workwear_b, "fifteen_women_workwear_b"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.sixteen_carhartt, "sixteen_carhartt"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.seventeen_carhartt_fr, "seventeen_carhartt_fr"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.seventeen_carhartt_fr, "seventeen_carhartt_fr1"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.eighteen_carhartt_fr_enhanced_visibility, "eighteen_carhartt_fr_enhanced_visibility"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.eighteen_carhartt_fr_enhanced_visibility, "eighteen_carhartt_fr_enhanced_visibility1"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.ninteen_tecasafe, "ninteen_tecasafe"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twenty_fr_outerwear, "twenty_fr_outerwear"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyone_e_viz_tecasafe_a, "twentyone_e_viz_tecasafe_a"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twenty_two_viz_tecasafe_b, "twenty_two_viz_tecasafe_b"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentythree_e_viz_tecasafe_c, "twentythree_e_viz_tecasafe_c"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyfour_high_visibility_shirt, "twentyfour_high_visibility_shirt"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyfour_high_visibility_shirt, "twentyfour_high_visibility_shirt1"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyfive_enhanced_visibility, "twentyfive_enhanced_visibility"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentysix_hundred_cotton, "twentysix_hundred_cotton"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyseven_food_pharma, "twentyseven_food_pharma"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentyeight_culinary, "twentyeight_culinary"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.twentynine_chef_essential, "twentynine_chef_essential"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirty_chef_signature, "thirty_chef_signature"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtyone_outerwear, "thirtyone_outerwear"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtytwo_floor_zone, "thirtytwo_floor_zone"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtythree_supply_closet, "thirtythree_supply_closet"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtyfour_restroom_zone, "thirtyfour_restroom_zone"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtyfive_kitchen_zone, "thirtyfive_kitchen_zone"))));
        document.add(new Paragraph().add(new Image(1, 20, compressImage(R.raw.thirtysix_shop_zone, "thirtysix_shop_zone"))));

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

        try {

            InputStream XmlFileInputStream = getResources().openRawResource(resourceUri);

            byte[] b = new byte[XmlFileInputStream.available()];
            XmlFileInputStream.read(b);

            byte[] decodedString = Base64.decode(new String(b), Base64.DEFAULT);

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            options.inScaled = false;
            options.inTempStorage = new byte[16 * 1024];

            Bitmap originalBitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length, options);

            File file = new File(getFilesDir(), "Images");
            if (!file.exists()) {
                file.mkdirs();
            }
            File imageFile = new File(file, fileName + ".png");
            imageFile.createNewFile();

//Convert bitmap to byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            originalBitmap.compress(Bitmap.CompressFormat.PNG, 100, bos); // YOU can also save it in JPEG
            byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
            FileOutputStream fos = new FileOutputStream(imageFile);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();


            String filePath = getRealPathFromURI(imageFile.getAbsolutePath());


            BitmapFactory.Options options1 = new BitmapFactory.Options();

            options1.inJustDecodeBounds = true;
            Bitmap bmp = BitmapFactory.decodeFile(filePath, options1);

            int actualHeight = options.outHeight;
            int actualWidth = options.outWidth;

            float maxHeight = 816.0f;
            float maxWidth = 612.0f;
            float imgRatio = actualWidth / actualHeight;
            float maxRatio = maxWidth / maxHeight;

            if (actualHeight > maxHeight || actualWidth > maxWidth) {
                if (imgRatio < maxRatio) {
                    imgRatio = maxHeight / actualHeight;
                    actualWidth = (int) (imgRatio * actualWidth);
                    actualHeight = (int) maxHeight;
                } else if (imgRatio > maxRatio) {
                    imgRatio = maxWidth / actualWidth;
                    actualHeight = (int) (imgRatio * actualHeight);
                    actualWidth = (int) maxWidth;
                } else {
                    actualHeight = (int) maxHeight;
                    actualWidth = (int) maxWidth;

                }
            }

            options.inSampleSize = calculateInSampleSize(options, actualWidth, actualHeight);
            options.inTempStorage = new byte[16 * 1024];

            try {
                bmp = BitmapFactory.decodeFile(filePath, options);
            } catch (OutOfMemoryError exception) {
                exception.printStackTrace();

            }
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.RGBA_1010102);
                } else {
                    scaledBitmap = Bitmap.createBitmap(actualWidth, actualHeight, Bitmap.Config.ARGB_8888);
                }
            } catch (OutOfMemoryError exception) {
                exception.printStackTrace();
            }

            float ratioX = actualWidth / (float) options.outWidth;
            float ratioY = actualHeight / (float) options.outHeight;
            float middleX = actualWidth / 2.0f;
            float middleY = actualHeight / 2.0f;

            Matrix scaleMatrix = new Matrix();
            scaleMatrix.setScale(ratioX, ratioY, middleX, middleY);

            Canvas canvas = new Canvas(scaledBitmap);
            canvas.setMatrix(scaleMatrix);
            canvas.drawBitmap(bmp, middleX - bmp.getWidth() / 2, middleY - bmp.getHeight() / 2, new Paint(Paint.FILTER_BITMAP_FLAG));

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return scaledBitmap;

    }


    private String getRealPathFromURI(String contentURI) {
        Uri contentUri = Uri.parse(contentURI);
        Cursor cursor = getContentResolver().query(contentUri, null, null, null, null);
        if (cursor == null) {
            return contentUri.getPath();
        } else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(index);
        }
    }

    public int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        final float totalPixels = width * height;
        final float totalReqPixelsCap = reqWidth * reqHeight * 2;
        while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
            inSampleSize++;
        }

        return inSampleSize;
    }

}