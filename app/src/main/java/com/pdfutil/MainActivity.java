package com.pdfutil;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.android.core.Document;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Document document = new Document().init(this);

    }
}