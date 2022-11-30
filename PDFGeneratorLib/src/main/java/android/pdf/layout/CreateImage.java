package android.pdf.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.pdf.io.Image;

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
    public View create(Context context, float singleColWeight, Image image) {

        double minMaxWidth = singleColWeight * image.getColSpan();
        int elementWidth = (int) (minMaxWidth - (image.getMarginRight() + image.getMarginLeft()));

        if (image.getImage() != null) {

            ImageView imageView = new ImageView(context);

            imageView.setImageBitmap(image.getImage());

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
