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
import android.graphics.pdf.PdfDocument;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.pdf.cell.Paragraph;
import android.pdf.constant.FontStyle;
import android.pdf.constant.PageSize;
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
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Document document;

    private Long fileSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        document = new Document(PageSize.A4).init(this);

        document.open(20);

        document.setPadding(20, 10, 20, 10);

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

            Toast.makeText(this, "Doc Created", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {

            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

        }
    }


    private void addPageNumbers() {

       // document.setPageCount(new PageCount("Page ", " / ").setTextColor(Color.GRAY).setGravity(Gravity.CENTER).setTextSize(5).setPadding(5));

    }

    private void verifySDK() {

        document.add(new Paragraph().add(new Image(1, 20, R.raw.four_cover).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.five_ur_differentiator_page).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.six_fs_differentiator_page).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.seven_comfort_shirt).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.eight_wrinkle_free_shirt).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.eight_wrinkle_free_shirt).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.nine_performance_polo).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.ten_oxford_exec_cargo).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.eleven_pro_knit_argyle_polo).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twelve_cargo_comfort_jeans).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.thireteen_pro_knit_tee_cargo_shorts).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.forteen_women_workwear_a).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.fifteen_women_workwear_b).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.sixteen_carhartt).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.seventeen_carhartt_fr).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.seventeen_carhartt_fr).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.eighteen_carhartt_fr_enhanced_visibility).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.eighteen_carhartt_fr_enhanced_visibility).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.ninteen_tecasafe).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twenty_fr_outerwear).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twentyone_e_viz_tecasafe_a).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twenty_two_viz_tecasafe_b).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twentythree_e_viz_tecasafe_c).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twentyfour_high_visibility_shirt).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twentyfour_high_visibility_shirt).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twentyfive_enhanced_visibility).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twentysix_hundred_cotton).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twentyseven_food_pharma).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twentyeight_culinary).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.twentynine_chef_essential).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.thirty_chef_signature).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.thirtyone_outerwear).setImageWidth(900).setImageHeight(1150)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.thirtytwo_floor_zone).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.thirtythree_supply_closet).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.thirtyfour_restroom_zone).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.thirtyfive_kitchen_zone).setImageWidth(650).setImageHeight(825)));
        document.add(new Paragraph().add(new Image(1, 20, R.raw.thirtysix_shop_zone).setImageWidth(650).setImageHeight(825)));
    }

    public Bitmap compressImage(int resourceUri) {

        Bitmap scaledBitmap = null;
        byte[] decodedString;

        File compressImageFile = null;

        try {

            InputStream XmlFileInputStream = getResources().openRawResource(resourceUri);

            byte[] b = new byte[XmlFileInputStream.available()];
            XmlFileInputStream.read(b);

            decodedString = Base64.decode(new String(b), Base64.DEFAULT);
            scaledBitmap =  BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

          /*  Bitmap bitmapCopy = scaledBitmap.copy(Bitmap.Config.RGB_565,true);
            bitmapCopy.setDensity(DisplayMetrics.DENSITY_HIGH);

            File imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "images");
            if (!imageFile.exists()) { imageFile.mkdirs(); }

            String fileName = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
            File imageResourceFile = new File(imageFile,fileName + ".png");

            //Convert bitmap to byte array
            bitmapCopy.compress(Bitmap.CompressFormat.WEBP, 30, new FileOutputStream(imageResourceFile)); // YOU can also save it in JPEG

            compressImageFile = compressImageFile(imageResourceFile,fileName);*/

            //scaledBitmap = BitmapFactory.decodeFile(compressImageFile.getAbsolutePath());

            //scaledBitmap = BitmapFactory.decodeStream(new FileInputStream(compressImageFile),null,null);

           // if (compressImageFile.exists()) { compressImageFile.delete(); imageResourceFile.delete(); }


            //scaledBitmap = compressImageBitmap(imageFile.getAbsolutePath(),originalBitmap);


            /*Bitmap createdBitmap
            scaledBitmap = createdBitmap.copy(Bitmap.Config.ARGB_8888,true);*/

           /* Bitmap createdBitmap = Bitmap.createScaledBitmap(originalBitmap,150,150,true);

            String filePath = getRealPathFromURI(imageFile.getAbsolutePath());
            BitmapFactory.Options options1 = new BitmapFactory.Options();
            Bitmap decodeFileBitmap = BitmapFactory.decodeFile(filePath, options1);*/


        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return scaledBitmap;

    }

    private File compressImageFile(File imageFile,String fileName) {

        File compressFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Compress");
        if (!compressFile.exists()) { compressFile.mkdirs(); }

        String compressFilename = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        File imageResourceFile = new File(compressFile,compressFilename + ".png");

        try {
            // write the compressed bitmap at the destination specified by destinationPath.
            decodeSampledBitmapFromFile(imageFile, 150,150).compress( Bitmap.CompressFormat.WEBP, 30, new FileOutputStream(imageResourceFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageResourceFile;

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