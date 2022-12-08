package com.pdfutil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Environment;
import android.pdf.bgImage.BgImage;
import android.pdf.cell.AreaBreak;
import android.pdf.cell.Paragraph;
import android.pdf.constant.DocType;
import android.pdf.core.Document;
import android.pdf.element.Image;
import android.pdf.element.Sentence;
import android.pdf.element.Text;
import android.pdf.io.PageCount;
import android.util.Base64;
import android.view.Gravity;
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

            this.init2();

            Toast.makeText(context, "Document Created", Toast.LENGTH_SHORT).show();

        } catch (IOException error) {

            Toast.makeText(context, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    private void init2() throws IOException {

        Document document = new Document().init(context);

        document.open(10);

        document.setPadding(10);

        createDocument_Two(document);

        document.close();

        document.finish(new File(path, "Document_Two.pdf"));

    }

    private void createDocument_Two(Document document) {

        document.add(DocType.HEADER, new Paragraph()
                .add(new Text(1,5,"HEADER").setGravity(Gravity.CENTER).setPadding(5).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE).setMarginBottom(5))
                .add(new Text(1,5,"HEADER").setGravity(Gravity.CENTER).setPadding(5).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE).setMarginBottom(5))
        );

        document.add(DocType.FOOTER, new Paragraph()
                .add(new Text(1,5,"FOOTER").setGravity(Gravity.CENTER).setPadding(5).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE).setMarginTop(5))
                .add(new Text(1,5,"FOOTER").setGravity(Gravity.CENTER).setPadding(5).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE).setMarginTop(5))
        );

        document.add(new Paragraph().add(new Text(1, 10, "Hello World").setBorder(true).setBackgroundColor(Color.GREEN).setPadding(10)));
    }

    public void init() throws IOException {

        Document document = new Document().init(context);

        document.open(10);

        document.setPadding(10);

        createDocument(document);

        document.close();

        document.finish(new File(path, "Document.pdf"));
    }

    private void createDocument(Document document) throws IOException {

        document.add(DocType.HEADER, new Paragraph()
                .add(new Text(1,5,"HEADER").setGravity(Gravity.CENTER).setPadding(5).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE).setMarginBottom(5))
                .add(new Text(1,5,"HEADER").setGravity(Gravity.CENTER).setPadding(5).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE).setMarginBottom(5))
        );

        document.add(DocType.FOOTER, new Paragraph()
                .add(new Text(1,5,"FOOTER").setGravity(Gravity.CENTER).setPadding(5).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE).setMarginTop(5))
                .add(new Text(1,5,"FOOTER").setGravity(Gravity.CENTER).setPadding(5).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE).setMarginTop(5))
        );

        document.setPageCount(new PageCount("Page "," / "));

        for (int i = 1; i <= 100; i++) {
            document.add(new Paragraph()
                    .add(new Text(1, 10, i+". Hello World").setBorder(true).setBackgroundColor(Color.GREEN).setPadding(10))
                    .setBorder(true)
            );
        }

        Sentence sentence = new Sentence(1,5);
        sentence.add(new Text(1, 5, "Hello World").setBorder(true).setBackgroundColor(Color.GREEN).setPadding(10));
        sentence.add(new Image(1, 5, decodeStream(R.raw.eleven_pro_knit_argyle_polo)).setBorder(true).setPadding(4));
        sentence.setPadding(10).setBorder(true).setBackgroundColor(Color.RED);


        document.add(new Paragraph().add(new Image(1, 9, decodeStream(R.raw.eleven_pro_knit_argyle_polo)).setBorder(true).setPadding(4)));


        document.add(new Paragraph().add(sentence).add(sentence).setBorder(true).setPadding(10).setBackgroundColor(Color.GRAY));

        /*document.add(new Paragraph().add(new Image(1, 10, decodeStream(R.raw.eleven_pro_knit_argyle_polo))));
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


    private Bitmap decodeStream(int resPath) throws IOException {
        InputStream inputStream = context.getResources().openRawResource(resPath);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        bytes = Base64.decode(bytes, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
