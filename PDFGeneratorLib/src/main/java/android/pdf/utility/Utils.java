package android.pdf.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.media.ExifInterface;
import android.os.Environment;
import android.view.View;

import android.pdf.constant.FontStyle;

import androidx.core.content.res.ResourcesCompat;

import com.rifluxyss.pdfgenerator.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Utility's
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Utils {

    /**
     * The constant fileExtension.
     */
    public static String fileExtension = ".jpeg";

    /**
     * Create border drawable.
     *
     * @param backgroundColor the background color
     * @param borderColor     the border color
     * @param width           the width of border
     * @return the drawable
     */
    public static Drawable createBorder(int backgroundColor, int borderColor, int width) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(width, borderColor);
        gradientDrawable.setColor(backgroundColor);
        return new LayerDrawable(new Drawable[]{gradientDrawable});
    }

    /**
     * Create get font typeface.
     *
     * @param context  the context
     * @param typeFace the type face
     * @return the typeface
     */
    public static Typeface createGetFont(Context context, int typeFace) {

        switch (typeFace) {
            default:
                return ResourcesCompat.getFont(context, R.font.helvetica);
            case FontStyle.HELVETICA_BOLD:
                return ResourcesCompat.getFont(context, R.font.helvetica_bold);
            case FontStyle.HELVETICA_BOLD_OBLIQUE:
                return ResourcesCompat.getFont(context, R.font.helvetica_bold_oblique);
            case FontStyle.HELVETICA_ROUNDED_BOLD:
                return ResourcesCompat.getFont(context, R.font.helvetica_rounded_bold);
            case FontStyle.HELVETICA_OBLIQUE:
                return  ResourcesCompat.getFont(context, R.font.helvetica_oblique);
            case FontStyle.HELVETICA_LIGHT:
                return  ResourcesCompat.getFont(context, R.font.helvetica_light);
            case FontStyle.HELVETICA_COMPRESSED:
                return  ResourcesCompat.getFont(context, R.font.helvetica_compressed);
        }
    }


    /**
     * Gets view height.
     *
     * @param views the views
     * @return the view height
     */
    public static int getViewHeight(List<View> views) {

        int mHeight = 0;

        for (int i = 0; i < views.size(); i++) {

            views.get(i).measure(0, 0);
            mHeight += views.get(i).getMeasuredHeight();

        }

        return mHeight;
    }


    /**
     * Compress image file file.
     *
     * @param imageFile     the image file
     * @param fileName      the file name
     * @param bitmapWidth   the bitmap width
     * @param bitmapHeight  the bitmap height
     * @param compressLevel the compress level
     * @return the file
     */
    public File compressImageFile(File imageFile, String fileName, int bitmapWidth, int bitmapHeight,int compressLevel) {

        try {
            // write the compressed bitmap at the destination specified by destinationPath.
            decodeSampledBitmapFromFile(imageFile, bitmapWidth,bitmapHeight).compress( Bitmap.CompressFormat.WEBP, compressLevel, new FileOutputStream(imageFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageFile;

    }

    private Bitmap decodeSampledBitmapFromFile(File imageFile, int reqWidth, int reqHeight) throws IOException {
        // First decode with inJustDecodeBounds=true to check dimensions
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        Bitmap scaledBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);

        //check the rotation of the image and display it properly
        ExifInterface exif;
        exif = new ExifInterface(imageFile.getAbsolutePath());
        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, 0);
        Matrix matrix = new Matrix();
        if (orientation == 6) {
            matrix.postRotate(90);
        } else if (orientation == 3) {
            matrix.postRotate(180);
        } else if (orientation == 8) {
            matrix.postRotate(270);
        }
        scaledBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), matrix, true);
        return scaledBitmap;
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
