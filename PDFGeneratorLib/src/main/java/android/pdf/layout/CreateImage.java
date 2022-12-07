package android.pdf.layout;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Environment;
import android.pdf.element.Image;
import android.pdf.utility.Utils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    public View create(Context context, float singleColWeight, Image image) throws FileNotFoundException {

        double minMaxWidth = singleColWeight * image.getColSpan();
        int elementWidth = (int) (minMaxWidth - (image.getMarginRight() + image.getMarginLeft()));

        if (image.getImage() != null) {

            ImageView imageView = new ImageView(context);

            /*if (image.isCompressImage()) {*/


            /*} else {

                imageView.setImageBitmap(image.getImage());
            }*/

            if (image.getCompressLevel() > 0) {

                File imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "images");
                if (!imageFile.exists()) {
                    imageFile.mkdirs();
                }

                String fileName = String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
                File imageResourceFile = new File(imageFile, fileName + Utils.fileExtension);

                // YOU can also save it in WEBP
                image.getImage().compress(Bitmap.CompressFormat.WEBP, image.getCompressLevel(), new FileOutputStream(imageResourceFile));

                File compressImageFile = new Utils().compressImageFile(imageResourceFile, image.getImageWidth(), image.getImageHeight(), image.getCompressLevel());

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.RGB_565;
                // explicitly state everything so the configuration is clear
                DisplayMetrics metrics = context.getApplicationContext().getResources().getDisplayMetrics();
                options.inScreenDensity = metrics.densityDpi;
                options.inTargetDensity = metrics.densityDpi;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    options.inDensity = DisplayMetrics.DENSITY_DEVICE_STABLE;
                }

                Bitmap bm = BitmapFactory.decodeStream(new FileInputStream(compressImageFile), null, options);

                if (imageResourceFile.exists()) { imageResourceFile.delete(); }
                if (imageFile.isDirectory()) { imageFile.delete(); }

                imageView.setImageBitmap(bm);

            } else {

                imageView.setImageBitmap(image.getImage());
            }

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
