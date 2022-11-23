package com.pdfutil;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.android.core.Document;
import com.android.io.AreaBreak;
import com.android.io.Paragraph;
import com.android.io.Text;
import com.android.kernel.FontStyle;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Document document = new Document().init(this);

        document.open(10);

        document.setPadding(20);

        document.add(new Paragraph()
                .add(new Text(1,10,"Hello World").setFontStyle(FontStyle.HELVETICA))
        );

        document.add(new AreaBreak());

        document.add(new Paragraph()
                .add(new Text(1,10,"Hello World").setFontStyle(FontStyle.HELVETICA))
        );

        document.close();

        try {
            document.finish(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"Doc.pdf"));
            Toast.makeText(this, "Doc Created", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}