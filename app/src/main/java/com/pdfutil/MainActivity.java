package com.pdfutil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.pdf.cell.Paragraph;
import android.pdf.core.Document;
import android.pdf.element.Image;
import android.util.Base64;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.pdfutil.databinding.ActivityMainBinding;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final File path = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Document.pdf");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

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

        document.add(new Paragraph().add(new Image(1,20,getResource(R.raw.five_ur_differentiator_page))));

    }

    Bitmap getResource(int resPath) throws IOException {
        InputStream inputStream = getResources().openRawResource(resPath);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        return compressImage(Base64.decode(new String(bytes), Base64.DEFAULT));
    }

    private Bitmap compressImage(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes,0, bytes.length);
    }
}