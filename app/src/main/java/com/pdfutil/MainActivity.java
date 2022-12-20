package com.pdfutil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.pdf.cell.Paragraph;
import android.pdf.core.Document;
import android.pdf.element.Image;
import android.pdf.element.Text;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.pdfutil.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final File path = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Document.pdf");
    private final File compress = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Compress.pdf");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        try {

            this.init();

            Toast.makeText(getBaseContext(), "Document Created", Toast.LENGTH_SHORT).show();

        } catch (IOException error) {

            Toast.makeText(getBaseContext(), error.getLocalizedMessage(), Toast.LENGTH_LONG).show();

        }
    }

    public void init() throws IOException {

        Document document = new Document().init(getBaseContext());

        document.open(10);

        document.setPadding(10);

        addStaticDocument(document);

        document.close();

        document.finish(path);
    }

    private void addStaticDocument(Document document) throws IOException {

        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.five_ur_differentiator_page))));

//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.four_cover))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.six_fs_differentiator_page))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.seven_comfort_shirt))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.eight_wrinkle_free_shirt))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.eight_wrinkle_free_shirt))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.nine_performance_polo))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.ten_oxford_exec_cargo))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.eleven_pro_knit_argyle_polo))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twelve_cargo_comfort_jeans))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.thireteen_pro_knit_tee_cargo_shorts))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.forteen_women_workwear_a))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.fifteen_women_workwear_b))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.sixteen_carhartt))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.seventeen_carhartt_fr))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.seventeen_carhartt_fr))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.eighteen_carhartt_fr_enhanced_visibility))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.eighteen_carhartt_fr_enhanced_visibility))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.ninteen_tecasafe))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twenty_fr_outerwear))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twentyone_e_viz_tecasafe_a))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twenty_two_viz_tecasafe_b))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twentythree_e_viz_tecasafe_c))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twentyfour_high_visibility_shirt))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twentyfour_high_visibility_shirt))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twentyfive_enhanced_visibility))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twentysix_hundred_cotton))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twentyseven_food_pharma))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twentyeight_culinary))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.twentynine_chef_essential))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.thirty_chef_signature))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.thirtyone_outerwear))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.thirtytwo_floor_zone))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.thirtythree_supply_closet))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.thirtyfour_restroom_zone))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.thirtyfive_kitchen_zone))));
//        document.add(new Paragraph().add(new Image(1, 10, getResource(R.raw.thirtysix_shop_zone))));
    }

    Bitmap getResource(int resPath) throws IOException {

        // Decode Raw File To Byte Array
        InputStream inputStream = getResources().openRawResource(resPath);
        byte[] bytes = new byte[inputStream.available()];
        if (inputStream.read(bytes) > 0) {
            bytes = Base64.decode(new String(bytes), Base64.DEFAULT);
        }

        // Store Byte Array As Image On Local Storage **Reference**
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path.getParent(), "image.jpeg"));
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();

        // Create Bitmap Without Any Optimization
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        // Change bitmap Config
        // bitmap = bitmap.copy(Bitmap.Config.RGB_565,true); // 12mb
        bitmap = bitmap.copy(Bitmap.Config.ARGB_4444,true); // 6mp

        return bitmap;
    }
}