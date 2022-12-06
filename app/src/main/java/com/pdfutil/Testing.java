package com.pdfutil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Environment;
import android.pdf.cell.Paragraph;
import android.pdf.core.Document;
import android.pdf.element.Image;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Testing {

    private final Context context;
    private final File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

    public Testing(Context context) {

        this.context = context;

        try {

            this.init();

            Toast.makeText(context, "Document Created", Toast.LENGTH_SHORT).show();

        } catch (IOException error) {

            Toast.makeText(context, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    public void init() throws IOException {

        Document document = new Document().init(context);

        document.open(10);

        createDocument(document);

        document.close();

        document.finish(new File(path, "Document.pdf"));
    }

    private void createDocument(Document document) throws IOException {

        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.eight_wrinkle_free_shirt))));
        /*document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.eighteen_carhartt_fr_enhanced_visibility))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.eleven_pro_knit_argyle_polo))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.fifteen_women_workwear_b))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.five_ur_differentiator_page))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.forteen_women_workwear_a))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.four_cover))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.nine_performance_polo))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.ninteen_tecasafe))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.one_generic_uniform_cover))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.seven_comfort_shirt))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.seventeen_carhartt_fr))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.six_fs_differentiator_page))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.sixteen_carhartt))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.ten_oxford_exec_cargo))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thireteen_pro_knit_tee_cargo_shorts))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirty_chef_signature))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtyfive_kitchen_zone))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtyfour_restroom_zone))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtyone_outerwear))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtysix_shop_zone))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtythree_supply_closet))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtytwo_floor_zone))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.three_high_image_uniform_cover))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twelve_cargo_comfort_jeans))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twenty_fr_outerwear))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twenty_two_viz_tecasafe_b))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentyeight_culinary))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentyfive_enhanced_visibility))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentyfour_high_visibility_shirt))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentynine_chef_essential))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentyone_e_viz_tecasafe_a))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentyseven_food_pharma))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentysix_hundred_cotton))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentythree_e_viz_tecasafe_c))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.two_culinary_uniform_cover))));*/

    }

    private Bitmap compressBitmap(Bitmap bitmap) throws IOException {

        bitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() / 1.5), (int) (bitmap.getHeight() / 1.5), true);

        return bitmap;
    }


    private Bitmap decodeStream(int resPath) throws IOException {

        InputStream inputStream = context.getResources().openRawResource(resPath);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte[] bytes = new byte[1024];
        int len;

        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        inputStream.close();

        bytes = Base64.decode(outputStream.toString(), Base64.DEFAULT);

        inputStream = new ByteArrayInputStream(bytes);

        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

        bitmap = bitmap.copy(Bitmap.Config.RGB_565,true);

        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap1);
        canvas.drawBitmap(bitmap,0,0,new Paint());
        bitmap1 = bitmap1.copy(Bitmap.Config.RGB_565,true);

        return bitmap1;
    }
}
