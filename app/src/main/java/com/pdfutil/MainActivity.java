package com.pdfutil;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.android.core.Document;
import com.android.io.AreaBreak;
import com.android.io.Paragraph;
import com.android.io.Text;
import com.android.kernel.DocType;
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

        document.add(DocType.HEADER,new Paragraph()
                .add(new Text(1,10,"HEADER").setGravity(Gravity.CENTER)
                        .setMarginBottom(10)
                        .setFontStyle(FontStyle.HELVETICA).setBackgroundColor(Color.BLACK).setTextColor(Color.WHITE))
        );

        document.add(DocType.FOOTER,new Paragraph()
                .add(new Text(1,10,"FOOTER").setGravity(Gravity.CENTER).setFontStyle(FontStyle.HELVETICA)
                        .setMarginTop(10)
                        .setBackgroundColor(Color.BLACK).setTextColor(Color.WHITE))
        );

        document.add(new Paragraph()
                .add(new Text(1,3,"Hello World").setFontStyle(FontStyle.HELVETICA).setBorder(true).setGravity(Gravity.CENTER))
                .add(new Text(1,3,"Hello World").setFontStyle(FontStyle.HELVETICA).setBorder(true).setGravity(Gravity.CENTER).setMarginLeft(-1))
                .add(new Text(1,4,"Hello World").setFontStyle(FontStyle.HELVETICA).setBorder(true).setGravity(Gravity.CENTER).setMarginLeft(-1))
        );

        for (int i = 1; i <= 50 ; i++) {

            document.add(new Paragraph()
                    .add(new Text(1,3,i+". Hello World").setFontStyle(FontStyle.HELVETICA).setBorder(true).setGravity(Gravity.CENTER))
                    .add(new Text(1,3,i+". Hello World").setFontStyle(FontStyle.HELVETICA).setBorder(true).setGravity(Gravity.CENTER).setMarginLeft(-1))
                    .add(new Text(1,4,i+". Hello World").setFontStyle(FontStyle.HELVETICA).setBorder(true).setGravity(Gravity.CENTER).setMarginLeft(-1))
                    .setMarginTop(-1)
            );

        }

        document.close();

        try {
            document.finish(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"Doc.pdf"));
            Toast.makeText(this, "Doc Created", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}