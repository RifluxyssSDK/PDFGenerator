package android.pdf.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
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

import androidx.core.graphics.BitmapCompat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

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

        if (image.getImage() != null || image.getResourceUri() != 0) {

            ImageView imageView = new ImageView(context);

            imageView.setMinimumWidth(image.getImageWidth());

            imageView.setMaxWidth(elementWidth);

            if (image.getResourceUri() != 0) {

                InputStream XmlFileInputStream = context.getResources().openRawResource(image.getResourceUri());

                byte[] b = new byte[XmlFileInputStream.available()];
                XmlFileInputStream.read(b);

                FileOutputStream fos = context.openFileOutput(String.format("%s %s", image.getResourceUri(), Utils.fileExtension), Context.MODE_PRIVATE);
                byte[] decodedString = Base64.decode(new String(b), Base64.DEFAULT);
                fos.write(decodedString);
                fos.flush();
                fos.close();

                DisplayMetrics metrics = context.getResources().getDisplayMetrics();

                // set options to resize the image
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inDensity = new Utils().getDensity(context);
                opts.inScreenDensity = metrics.densityDpi;
                opts.inTargetDensity = metrics.densityDpi;
                opts.inPreferredConfig = image.getConfig() != null ? image.getConfig() : Bitmap.Config.RGB_565;

                InputStream in = context.openFileInput(String.format("%s %s", image.getResourceUri(), Utils.fileExtension));

                // bmp is the resized bitmap
                Bitmap decodeStream = BitmapFactory.decodeStream(in, null, opts);
               // Bitmap updatedBitmap = Bitmap.createScaledBitmap(decodeStream,image.getImageWidth(),image.getImageHeight(),true);

                long bitmapByteCount = BitmapCompat.getAllocationByteCount(decodeStream);
                Log.e("status","check bitmapByteCount ===> " + bitmapByteCount);
                String fileSize = getStringSizeLengthFile(bitmapByteCount);
                Log.e("status","check Size ===> " + fileSize);

                int width = decodeStream.getWidth();
                int height = decodeStream.getHeight();
                float scaleWidth = ((float) image.getImageWidth()) / width;
                float scaleHeight = ((float) image.getImageHeight()) / height;
                // CREATE A MATRIX FOR THE MANIPULATION
                Matrix matrix = new Matrix();
                // RESIZE THE BIT MAP
                matrix.postScale(scaleWidth, scaleHeight);

                // "RECREATE" THE NEW BITMAP
                Bitmap resizedBitmap = Bitmap.createBitmap(decodeStream, 0, 0, width, height, matrix, true);

                Log.e("status","check bitmapByteCount Width ===> " + width + " ===> Height : ===> " + height);
                Log.e("status","check bitmapByteCount resizedBitmap Width ===> " + resizedBitmap.getWidth() + " ===> resizedBitmap Height : ===> " + resizedBitmap.getHeight());

                decodeStream.recycle();

                imageView.setImageBitmap(resizedBitmap);


            } else {

                imageView.setImageBitmap(image.getImage());
            }

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

    public static String getStringSizeLengthFile(long size) {

        DecimalFormat df = new DecimalFormat("0.00");

        float sizeKb = 1024.0f;
        float sizeMb = sizeKb * sizeKb;
        float sizeGb = sizeMb * sizeKb;
        float sizeTerra = sizeGb * sizeKb;

        if(size < sizeMb)
            return df.format(size / sizeKb)+ " Kb";
        else if(size < sizeGb)
            return df.format(size / sizeMb) + " Mb";
        else if(size < sizeTerra)
            return df.format(size / sizeGb) + " Gb";

        return "";
    }

}
