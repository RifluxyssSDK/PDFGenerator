package com.pdfutil;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.pdf.core.Document;
import android.pdf.cell.Paragraph;
import android.pdf.element.Text;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final int STORAGE_PERMISSION = 101;
    Document document;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        document = new Document().init(this);

        document.open(20);

        document.setPadding(20);

        createDocument();

        document.close();

        storagePermission();

        try {

            File file = new File((Environment.getExternalStorageDirectory() + "/PDF Generator"));

            if (file.exists() || file.mkdirs()) {

                document.finish(new File(file, "Document.pdf"));

                Toast.makeText(getBaseContext(), "Document Created Successfully", Toast.LENGTH_SHORT).show();

            }

        } catch (IOException e) {

            Toast.makeText(getBaseContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    private void storagePermission() {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R && !Environment.isExternalStorageManager()) {

            startActivity(new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, Uri.parse("package:" + BuildConfig.APPLICATION_ID)));

        }
    }

    private void createDocument() {

        document.add(new Paragraph().add(new Text(1, 20, "Hello World...").setPadding(10).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE)));

    }
}