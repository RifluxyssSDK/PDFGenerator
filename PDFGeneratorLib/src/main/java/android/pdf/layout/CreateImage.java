package android.pdf.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.pdf.element.Image;
import android.pdf.utility.Utils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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

                FileOutputStream fos = context.openFileOutput("imageName" + Utils.fileExtension, Context.MODE_PRIVATE);
                byte[] decodedString = Base64.decode(new String(b), Base64.DEFAULT);
                fos.write(decodedString);
                fos.flush();
                fos.close();

                File file = new File(context.getFilesDir() + File.separator + "imageName" + Utils.fileExtension);

                DisplayMetrics metrics = context.getResources().getDisplayMetrics();

                // set options to resize the image
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inDensity = new Utils().getDensity(context);
                opts.inScreenDensity = metrics.densityDpi;
                opts.inTargetDensity = metrics.densityDpi;
                opts.inPreferredConfig = image.getConfig() != null ? image.getConfig() : Bitmap.Config.RGB_565;

                // bmp is the resized bitmap
                Bitmap decodeStream = BitmapFactory.decodeStream(new FileInputStream(file), null, opts);

                // File using Create Drawable images
                //Drawable imageDrawable = Drawable.createFromResourceStream(context.getResources(), null, context.openFileInput(file.getName()), null, opts);

                Bitmap bitmapNew = Bitmap.createScaledBitmap(decodeStream, image.getImageWidth(), image.getImageHeight(), true);

                imageView.setImageBitmap(bitmapNew);

                //imageView.setImageDrawable(imageDrawable);

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

}
