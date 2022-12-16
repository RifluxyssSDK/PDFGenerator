package android.pdf.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Environment;
import android.pdf.element.Image;
import android.pdf.utility.Utils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * The type Create image.
 */
public class CreateImage {

    /**
     * Create view.
     *
     * @param context         the context
     * @param singleColWeight the single col weight
     * @param image           the image
     * @return the view
     */
    public View create(Context context, float singleColWeight, Image image) throws IOException {

        double minMaxWidth = singleColWeight * image.getColSpan();
        int elementWidth = (int) (minMaxWidth - (image.getMarginRight() + image.getMarginLeft()));

        if (image.getResourceUri() != 0) {

            ImageView imageView = new ImageView(context);

            InputStream XmlFileInputStream = context.getResources().openRawResource(image.getResourceUri());
            byte[] b = new byte[XmlFileInputStream.available()];
            XmlFileInputStream.read(b);

            FileOutputStream fos = context.openFileOutput("imageName" + Utils.fileExtension, Context.MODE_PRIVATE);
            byte[] decodedString = Base64.decode(new String(b), Base64.DEFAULT);
            fos.write(decodedString);
            fos.flush();
            fos.close();

            File file = new File(context.getFilesDir() + File.separator + "imageName" + Utils.fileExtension);

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inScaled = true;
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options);

            bitmap = Bitmap.createScaledBitmap(bitmap, image.getImageWidth(), image.getImageHeight(), true);

            imageView.setImageBitmap(bitmap.copy(image.getConfig() != null ? image.getConfig() : Bitmap.Config.RGB_565, true));

            imageView.setMinimumWidth(image.getImageWidth());

            imageView.setMaxWidth(elementWidth);

            imageView.setAdjustViewBounds(true);

            imageView.setScaleType(image.getScaleType());

            imageView.setBackgroundColor(image.getBackgroundColor());

            imageView.setPadding(image.getPaddingLeft(), image.getPaddingTop(), image.getPaddingRight(), image.getPaddingBottom());

            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                    GridLayout.spec(GridLayout.UNDEFINED, image.getRowSpan(), image.getRowSpan()),
                    GridLayout.spec(GridLayout.UNDEFINED, image.getColSpan(), image.getColSpan())
            );

            layoutParams.setMargins(image.getMarginLeft(), image.getMarginTop(), image.getMarginRight(), image.getMarginBottom());

            imageView.setLayoutParams(layoutParams);

            return imageView;

        } else {

            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setMinimumWidth(elementWidth);

            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, image.getRowSpan(), image.getRowSpan()), GridLayout.spec(GridLayout.UNDEFINED, image.getColSpan(), image.getColSpan()));
            layoutParams.setMargins(image.getMarginLeft(), image.getMarginTop(), image.getMarginRight(), image.getMarginBottom());
            linearLayout.setLayoutParams(layoutParams);

            return linearLayout;
        }

    }

}
