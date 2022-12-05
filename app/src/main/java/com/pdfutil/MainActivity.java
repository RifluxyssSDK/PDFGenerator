package com.pdfutil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ImageWriter;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.pdf.core.Document;
import android.pdf.cell.Paragraph;
import android.pdf.element.Image;
import android.pdf.element.Text;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            init();

            Toast.makeText(getBaseContext(), ("Successfully Generated"), Toast.LENGTH_SHORT).show();

        } catch (IOException e) {

            Toast.makeText(getBaseContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();

        }
    }

    private void init() throws IOException {

        ArrayList<Bitmap> bitmaps = new ArrayList<>();

        Bitmap bitmap = compress(getBitmap(R.raw.thirtyone_outerwear));

        bitmaps.add(bitmap);

        createDocument(bitmaps);

    }

    private Bitmap compress(Bitmap bitmap) {


        return bitmap;
    }

    private void createDocument(ArrayList<Bitmap> bitmaps) throws IOException {

        Document document = new Document().init(getBaseContext());

        document.open(10);

        document.setPadding(20);

        for (Bitmap bitmap : bitmaps) {

            document.add(new Paragraph().add(new Image(1, 10, bitmap)));

        }

        document.close();

        document.finish(new File(path, "Normal.pdf"));

    }

    private Bitmap getBitmap(int resPath) throws IOException {

        InputStream inputStream = getResources().openRawResource(resPath);
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

        return BitmapFactory.decodeStream(inputStream);
    }
}