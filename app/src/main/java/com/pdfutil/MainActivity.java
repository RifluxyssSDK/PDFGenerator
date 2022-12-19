package com.pdfutil;

import android.os.Bundle;
import android.os.Environment;
import android.pdf.core.Document;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.pdfutil.databinding.ActivityMainBinding;

import java.io.File;
import java.io.IOException;

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

    private void addStaticDocument(Document document) {



    }
}