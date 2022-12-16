package com.pdfutil;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.pdf.bgImage.BgImage;
import android.pdf.cell.AreaBreak;
import android.pdf.cell.Paragraph;
import android.pdf.constant.DocType;
import android.pdf.core.Document;
import android.pdf.element.Sentence;
import android.pdf.element.Text;
import android.pdf.io.PageCount;
import android.view.Gravity;
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

        Bitmap border = BitmapFactory.decodeResource(getResources(), R.drawable.print);

        BgImage bgImage = new BgImage(border);

        bgImage.setMargin(10,0,10,10);

        document.setBgImage(bgImage);

//        document.add(DocType.HEADER, new Paragraph().add(new Text(1,10,"HEADER").setGravity(Gravity.CENTER).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE).setPadding(5)));
//
//        document.add(DocType.FOOTER,new Paragraph().add(new Text(1,10,"FOOTER").setGravity(Gravity.CENTER).setBackgroundColor(Color.GRAY).setTextColor(Color.WHITE).setPadding(5)));
//
//        document.setPageCount(new PageCount("Page "," / "));
//
//        document.add(new Paragraph().add(new Text(1,10,"1 Hello Document...")));
//        document.add(new Paragraph().add(new Text(1,10,"2 Hello Document...")));
//        document.add(new Paragraph().add(new Text(1,10,"3 Hello Document...")));
//        document.add(new AreaBreak());
//
//        document.add(new Paragraph().add(new Text(1,10,"Paragraph").setGravity(Gravity.CENTER).setMargin(10)));
//
//        document.add(new Paragraph()
//                .add(new Text(1,5,"Row 1 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//                .add(new Text(2,5,"Row 2 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//                .add(new Text(1,5,"Row 1 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//                .setBorder(true).setPadding(10).setBackgroundColor(Color.LTGRAY)
//        );
//
//        document.add(new Paragraph()
//                .add(new Text(1,5,"Row 1 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//                .add(new Text(2,5,"Row 2 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//                .add(new Text(1,5,"Row 1 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//                .setBorder(true).setPadding(10).setBackgroundColor(Color.LTGRAY)
//        );
//
//        document.add(new Paragraph().add(new Text(1,10,"Sentence").setGravity(Gravity.CENTER).setMargin(10)));
//
//        Sentence sentence = new Sentence(1,5);
//        sentence.add(new Text(1,5,"Row 1 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//        .add(new Text(2,5,"Row 2 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//        .add(new Text(1,5,"Row 1 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//        .setPadding(10).setBackgroundColor(Color.LTGRAY);
//
//        Sentence sentence1 = new Sentence(1,5);
//        sentence1.add(new Text(1,5,"Row 1 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//                .add(new Text(2,5,"Row 2 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//                .add(new Text(1,5,"Row 1 Col 5").setGravity(Gravity.CENTER).setBorder(true).setPadding(5).setBackgroundColor(Color.RED))
//                .setPadding(10).setBackgroundColor(Color.LTGRAY).setMarginLeft(-1);
//
//        document.add(new Paragraph().add(sentence).add(sentence1).setBorder(true).setPadding(1));

        document.close();

        document.finish(path);
    }
}