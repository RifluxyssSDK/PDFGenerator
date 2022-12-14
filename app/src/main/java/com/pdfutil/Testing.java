package com.pdfutil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfRenderer;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.pdf.cell.AreaBreak;
import android.pdf.cell.Paragraph;
import android.pdf.constant.PageSize;
import android.pdf.core.Document;
import android.pdf.element.Image;
import android.pdf.element.Line;
import android.pdf.element.Sentence;
import android.pdf.element.Text;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

public class Testing {

    private final Context context;
    private final File path = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Document.pdf");
    private final File compress = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Compress.pdf");

    public Testing(Context context) {

        this.context = context;

        try {

            this.init();

            Toast.makeText(context, "Document Created", Toast.LENGTH_SHORT).show();

        } catch (IOException error) {

            Toast.makeText(context, error.getLocalizedMessage(), Toast.LENGTH_LONG).show();

        }
    }

    public void init() throws IOException {

        Document document = new Document().init(context);

//        document.open(10);

        document.setPadding(10);

        document.add(new Paragraph().add(new Line(1,10)));
//        document.add(new Paragraph().add(new Text(1,11,"")));
//        document.add(new Paragraph().add(new Image(1,11,null)));
//        document.add(new Paragraph().add(new Sentence(1,11)));

        createDocument(document);

        document.close();

        document.finish(path);
    }


    private void createDocument(Document document) throws IOException {

        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.re_size))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.five_ur_differentiator_page))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.forteen_women_workwear_a))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.eleven_pro_knit_argyle_polo))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.fifteen_women_workwear_b))));
        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.four_cover))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.nine_performance_polo))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.ninteen_tecasafe))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.one_generic_uniform_cover))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.seven_comfort_shirt))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.seventeen_carhartt_fr))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.six_fs_differentiator_page))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.sixteen_carhartt))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.ten_oxford_exec_cargo))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thireteen_pro_knit_tee_cargo_shorts))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirty_chef_signature))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtyfive_kitchen_zone))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtyfour_restroom_zone))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtyone_outerwear))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtysix_shop_zone))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtythree_supply_closet))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.thirtytwo_floor_zone))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.three_high_image_uniform_cover))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twelve_cargo_comfort_jeans))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twenty_fr_outerwear))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twenty_two_viz_tecasafe_b))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentyeight_culinary))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentyfive_enhanced_visibility))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentyfour_high_visibility_shirt))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentynine_chef_essential))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentyone_e_viz_tecasafe_a))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentyseven_food_pharma))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentysix_hundred_cotton))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.twentythree_e_viz_tecasafe_c))));
//        document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.two_culinary_uniform_cover))));
    }

    private Bitmap decodeStream(int resPath) throws IOException {
        InputStream inputStream = context.getResources().openRawResource(resPath);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        bytes = Base64.decode(bytes, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length).copy(Bitmap.Config.ARGB_8888, true);

//        bitmap = Bitmap.createScaledBitmap(bitmap,579,771,true);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(new File(path.getParentFile(), getTime() + ".jpeg")));

//        bitmap = compressIMG(bitmap);
        return bitmap;
    }

    private Bitmap compressIMG(Bitmap bitmap) throws IOException {

        ImageView imageView = new ImageView(context);
        imageView.setMaxWidth(579);
        imageView.setMaxHeight(771);
        imageView.setImageBitmap(bitmap);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.measure(0, 0);
        imageView.layout(0, 0, 579, 771);

        Bitmap bmp = Bitmap.createBitmap(579, 771, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmp);
        imageView.draw(c);

        return bitmap;
    }

    String getTime() {
        Calendar rightNow = Calendar.getInstance();
        long offset = rightNow.get(Calendar.ZONE_OFFSET) + rightNow.get(Calendar.DST_OFFSET);
        String sinceMidnight = Long.toString((rightNow.getTimeInMillis() + offset) % (24 * 60 * 60 * 1000));
        return sinceMidnight;
    }
}
