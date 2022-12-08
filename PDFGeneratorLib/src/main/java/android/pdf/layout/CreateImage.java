package android.pdf.layout;

import android.pdf.core.Instance;
import android.pdf.element.Image;
import android.pdf.utility.Utils;
import android.widget.GridLayout;
import android.widget.ImageView;

public class CreateImage {

    private final Instance instance = Instance.getInstance();
    private final ImageView imageView = new ImageView(instance.getContext());

    public ImageView create(float width, Image image) {

        authorization(image);

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
        imageView.setPadding(image.getPaddingLeft(), image.getPaddingTop(), image.getPaddingRight(), image.getPaddingBottom());
        return imageView;
    }

    private void authorization(Image image) {
        if (image.getImage() == null) {
            throw new Error("Given bitmap is Null");
        } else if (image.getColSpan() > instance.getColumnWeight()) {
            throw new Error("column span mustn't exceed the column count. ( total column : " + instance.getColumnWeight() + ", cell colSpan : " + image.getColSpan() + " )");
        }
    }

    private int calculateActualWidth(float width, Image image) {
        double minMaxWidth = width * image.getColSpan();
        int marginWidth = image.getMarginLeft() + image.getMarginRight();
        return (int) minMaxWidth - marginWidth;
    }
}
