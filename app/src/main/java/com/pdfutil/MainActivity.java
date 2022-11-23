package com.pdfutil;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import com.rifluxyss.pdfgenerator.constants.Draw;
import com.rifluxyss.pdfgenerator.constants.FontStyle;
import com.rifluxyss.pdfgenerator.constants.PageSize;
import com.rifluxyss.pdfgenerator.mainView.PdfWriter;
import com.rifluxyss.pdfgenerator.structure.Cell;
import com.rifluxyss.pdfgenerator.structure.Paragraph;
import com.rifluxyss.pdfgenerator.structure.Table;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PdfWriter pdfWriter = new PdfWriter(PageSize.A4).init(getApplicationContext());

        pdfWriter.setMargin(30,40,30,40);

        Table table = pdfWriter.createTable(14);

        Paragraph paragraph = new Paragraph();

        paragraph.add(new Cell(1,7,Draw.text).setMessage("Customer Name").setTextSize(6).setFontStyle(FontStyle.HELVETICA).setBorder(true).setBorderColor(Color.LTGRAY));
        paragraph.add(new Cell(4,7,Draw.text).setMessage("DBA Name").setTextSize(6).setFontStyle(FontStyle.HELVETICA).setBorder(true).setBorderColor(Color.LTGRAY));
        paragraph.add(new Cell(1,7,Draw.text).setMessage("DBA Name").setTextSize(6).setFontStyle(FontStyle.HELVETICA).setBorder(true).setBorderColor(Color.LTGRAY));

        table.addCell(new Cell(1,14,Draw.paragraph).setParagraph(paragraph));

        for (int i=0; i < 10; i++) {

            table.addCell(new Cell(1, 8, Draw.text).setMessage("Garment").setFontStyle(FontStyle.HELVETICA)
                    .setPadding(8, 3, 3, 3).setTextSize(6).setBackgroundColor(Color.rgb(243, 250, 253))
                    .setBorder(true).setBorderColor(Color.LTGRAY));
            table.addCell(new Cell(1, 2, Draw.text).setMessage("Frequency").setFontStyle(FontStyle.HELVETICA).setPadding(8, 3, 3, 3).setTextSize(6)
                    .setBackgroundColor(Color.rgb(243, 250, 253)).setBorder(true).setBorderColor(Color.LTGRAY));
            table.addCell(new Cell(1, 2, Draw.text).setMessage("Inventory").setFontStyle(FontStyle.HELVETICA)
                    .setPadding(8, 3, 3, 3).setTextSize(6).setBackgroundColor(Color.rgb(243, 250, 253))
                    .setBorder(true).setBorderColor(Color.LTGRAY));
            table.addCell(new Cell(1, 2, Draw.text).setMessage("Unit Price").setFontStyle(FontStyle.HELVETICA)
                    .setPadding(8, 3, 3, 3).setTextSize(6).setBackgroundColor(Color.rgb(243, 250, 253)).setBorder(true).setBorderColor(Color.LTGRAY));


        }

        try {

            File samplePDfFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"cintasPdf");

            if (!samplePDfFile.exists()) { samplePDfFile.mkdirs(); }

            File pdfFilePath = new File(samplePDfFile,"Sample.pdf");

            pdfWriter.createPDF(pdfFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}