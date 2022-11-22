package com.pdfutil;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rifluxyss.pdfgenerator.constants.PageSize;
import com.rifluxyss.pdfgenerator.mainView.PdfWriter;
import com.rifluxyss.pdfgenerator.structure.Table;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PdfWriter pdfWriter = new PdfWriter(PageSize.A4);
        Table table = pdfWriter.createTable(20);
    }
}