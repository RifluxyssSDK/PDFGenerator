package android.pdf.layout;

import android.pdf.core.Instance;
import android.pdf.element.Image;
import android.pdf.utility.Utils;
import android.widget.GridLayout;
import android.widget.ImageView;

/**
 * The type Create image.
 */
public class CreateImage extends Instance {

    private final ImageView imageView = new ImageView(getContext());

    /**
     * Create image view.
     *
     * @param width the width
     * @param image the image
     * @return the image view
     */
    public ImageView create(float width, Image image) {

        int actualWidth = calculateActualWidth(width, image);

        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(
                GridLayout.spec(GridLayout.UNDEFINED, image.getRowSpan(), image.getRowSpan()),
                GridLayout.spec(GridLayout.UNDEFINED, image.getColSpan(), image.getColSpan())
        );

        layoutParams.setMargins(
                image.getMarginLeft(),
                image.getMarginTop(),
                image.getMarginRight(),
                image.getMarginBottom()
        );

        if (image.isBorder()) {
            imageView.setBackground(
                    Utils.createBorder(
                            image.getBackgroundColor(),
                            image.getBorderColor(),
                            image.getBorderWidth()
                    )
            );
        } else {
            imageView.setBackgroundColor(image.getBackgroundColor());
        }

        imageView.setMaxWidth(actualWidth);
        imageView.setAdjustViewBounds(true);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageBitmap(image.getImage());
        imageView.setScaleType(image.getScaleType());
        imageView.setMinimumWidth(image.getImageWidth());
        imageView.setBackgroundColor(image.getBackgroundColor());
        imageView.setMaxHeight(getPageSize().getPageHeight() - 10);
        imageView.setPadding(image.getPaddingLeft(), image.getPaddingTop(), image.getPaddingRight(), image.getPaddingBottom());
        return imageView;
    }

    private int calculateActualWidth(float width, Image image) {
        double minMaxWidth = width * image.getColSpan();
        int marginWidth = image.getMarginLeft() + image.getMarginRight();
        return (int) minMaxWidth - marginWidth;
    }
}
