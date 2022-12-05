package com.pdfutil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.pdf.cell.Paragraph;
import android.pdf.core.Document;
import android.pdf.element.Image;
import android.util.Base64;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Testing {

    private final Context context;
    private final File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

    public Testing(Context context) {

        this.context = context;

        try {

            this.init();

            Toast.makeText(context, "Document Created", Toast.LENGTH_SHORT).show();

        } catch (IOException error) {

            Toast.makeText(context, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    public void init() throws IOException {

        Document document = new Document().init(context);

        document.open(10);

        createDocument(document);

        document.close();

        document.finish(new File(path, "Document.pdf"));
    }

    private void createDocument(Document document) throws IOException {

        Bitmap bitmap = decodeStream(R.raw.thirtyone_outerwear);

        bitmap = compressBitmap(bitmap);

        document.add(new Paragraph().add(new Image(1, 10, bitmap)));

    }

    private Bitmap compressBitmap(Bitmap bitmap) {

        bitmap = bitmap.copy(Bitmap.Config.RGB_565,true);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, 100, out);
        bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));

        return bitmap;
    }

    private Bitmap decodeStream(int resPath) throws IOException {

        InputStream inputStream = context.getResources().openRawResource(resPath);
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
