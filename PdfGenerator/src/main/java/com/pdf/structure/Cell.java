package com.pdf.structure;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.widget.ImageView;

import androidx.annotation.ColorInt;

/**
 * The type Cell.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Cell {

    /**
     * The Border.
     */
    boolean border;
    /**
     * The Line spacing.
     */
    float lineSpacing;

    /**
     * The Message.
     */
    String message;
    /**
     * The Bitmap.
     */
    Bitmap bitmap;
    /**
     * The Paragraph.
     */
    Paragraph paragraph;

    /**
     * The Scale type.
     */
    ImageView.ScaleType scaleType;

    /**
     * The Row span.
     */
    int rowSpan,
    /**
     * The Col span.
     */
    colSpan,
    /**
     * The Draw.
     */
    draw;
    /**
     * The Bitmap width.
     */
    int bitmapWidth,
    /**
     * The Bitmap height.
     */
    bitmapHeight;
    /**
     * The Margin left.
     */
    int marginLeft,
    /**
     * The Margin top.
     */
    marginTop,
    /**
     * The Margin right.
     */
    marginRight,
    /**
     * The Margin bottom.
     */
    marginBottom;
    /**
     * The Padding left.
     */
    int paddingLeft,
    /**
     * The Padding top.
     */
    paddingTop,
    /**
     * The Padding right.
     */
    paddingRight,
    /**
     * The Padding bottom.
     */
    paddingBottom;
    /**
     * The Text size.
     */
    int textSize,
    /**
     * The Font style.
     */
    fontStyle,
    /**
     * The Text color.
     */
    textColor,
    /**
     * The Background color.
     */
    backgroundColor,
    /**
     * The Gravity.
     */
    gravity,
    /**
     * The Border width.
     */
    borderWidth,
    /**
     * The Border color.
     */
    borderColor;

    /**
     * The Left.
     */
    boolean left,
    /**
     * The Right.
     */
    right,
    /**
     * The Center.
     */
    center;
    /**
     * The spannableStringBuilder.
     */
    private SpannableStringBuilder spannableStringBuilder;

    /**
     * Instantiates a new Cell.
     *
     * @param rowSpan the row span
     * @param colSpan the col span
     * @param Draw    the draw
     */
    public Cell(int rowSpan, int colSpan, int Draw) {

        this.rowSpan = rowSpan;
        this.colSpan = colSpan;
        this.draw = Draw;

        init(Draw);
    }

    /**
     * Instantiates a new Cell.
     *
     * @param colSpan the col span
     * @param Draw    the draw
     */
    public Cell(int colSpan, int Draw) {

        this.rowSpan = 1;
        this.colSpan = colSpan;
        this.draw = Draw;

        init(Draw);
    }

    private void init(int Draw) {
        setTextSize(pdfUtils.constants.Draw.empty_space == Draw ? 1 : 7);
        setBorder(false);
        setBorderWidth(1);
        setLineSpacing(1);
        setScaleType(ImageView.ScaleType.FIT_XY);
        setBorderColor(Color.BLACK);
        setTextColor(Color.BLACK);
    }

    /**
     * Sets padding.
     *
     * @param paddingLeft   the padding left
     * @param paddingTop    the padding top
     * @param paddingRight  the padding right
     * @param paddingBottom the padding bottom
     * @return the padding
     */
    public Cell setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.paddingRight = paddingRight;
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * Sets padding.
     *
     * @param padding the padding
     * @return the padding
     */
    public Cell setPadding(int padding) {
        this.paddingLeft = padding;
        this.paddingTop = padding;
        this.paddingRight = padding;
        this.paddingBottom = padding;
        return this;
    }

    /**
     * Sets margin.
     *
     * @param marginLeft   the margin left
     * @param marginTop    the margin top
     * @param marginRight  the margin right
     * @param marginBottom the margin bottom
     * @return the margin
     */
    public Cell setMargin(int marginLeft, int marginTop, int marginRight, int marginBottom) {
        this.marginLeft = marginLeft;
        this.marginTop = marginTop;
        this.marginRight = marginRight;
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * Sets margin.
     *
     * @param margin the margin
     * @return the margin
     */
    public Cell setMargin(int margin) {
        this.marginLeft = margin;
        this.marginTop = margin;
        this.marginRight = margin;
        this.marginBottom = margin;
        return this;
    }

    /**
     * Gets bitmap.
     *
     * @return the bitmap
     */
    public Bitmap getBitmap() {
        return bitmap;
    }

    /**
     * Sets bitmap.
     *
     * @param bitmap the bitmap
     * @return the bitmap
     */
    public Cell setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.bitmapWidth = bitmap.getWidth();
        this.bitmapHeight = bitmap.getHeight();
        return this;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @return the message
     */
    public Cell setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Gets paragraph.
     *
     * @return the paragraph
     */
    public Paragraph getParagraph() {
        return paragraph;
    }

    /**
     * Sets paragraph.
     *
     * @param paragraph the paragraph
     * @return the paragraph
     */
    public Cell setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
        return this;
    }

    /**
     * Gets row span.
     *
     * @return the row span
     */
    public int getRowSpan() {
        return rowSpan;
    }

    /**
     * Sets row span.
     *
     * @param rowSpan the row span
     * @return the row span
     */
    public Cell setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
        return this;
    }

    /**
     * Gets col span.
     *
     * @return the col span
     */
    public int getColSpan() {
        return colSpan;
    }

    /**
     * Sets col span.
     *
     * @param colSpan the col span
     * @return the col span
     */
    public Cell setColSpan(int colSpan) {
        this.colSpan = colSpan;
        return this;
    }

    /**
     * Gets draw.
     *
     * @return the draw
     */
    public int getDraw() {
        return draw;
    }

    /**
     * Sets draw.
     *
     * @param draw the draw
     * @return the draw
     */
    public Cell setDraw(int draw) {
        this.draw = draw;
        return this;
    }

    /**
     * Gets bitmap width.
     *
     * @return the bitmap width
     */
    public int getBitmapWidth() {
        return bitmapWidth;
    }

    /**
     * Sets bitmap width.
     *
     * @param bitmapWidth the bitmap width
     * @return the bitmap width
     */
    public Cell setBitmapWidth(int bitmapWidth) {
        this.bitmapWidth = bitmapWidth;
        return this;
    }

    /**
     * Gets bitmap height.
     *
     * @return the bitmap height
     */
    public int getBitmapHeight() {
        return bitmapHeight;
    }

    /**
     * Sets bitmap height.
     *
     * @param bitmapHeight the bitmap height
     * @return the bitmap height
     */
    public Cell setBitmapHeight(int bitmapHeight) {
        this.bitmapHeight = bitmapHeight;
        return this;
    }

    /**
     * Gets margin left.
     *
     * @return the margin left
     */
    public int getMarginLeft() {
        return marginLeft;
    }

    /**
     * Sets margin left.
     *
     * @param marginLeft the margin left
     * @return the margin left
     */
    public Cell setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
        return this;
    }

    /**
     * Gets margin top.
     *
     * @return the margin top
     */
    public int getMarginTop() {
        return marginTop;
    }

    /**
     * Sets margin top.
     *
     * @param marginTop the margin top
     * @return the margin top
     */
    public Cell setMarginTop(int marginTop) {
        this.marginTop = marginTop;
        return this;
    }

    /**
     * Gets margin right.
     *
     * @return the margin right
     */
    public int getMarginRight() {
        return marginRight;
    }

    /**
     * Sets margin right.
     *
     * @param marginRight the margin right
     * @return the margin right
     */
    public Cell setMarginRight(int marginRight) {
        this.marginRight = marginRight;
        return this;
    }

    /**
     * Gets margin bottom.
     *
     * @return the margin bottom
     */
    public int getMarginBottom() {
        return marginBottom;
    }

    /**
     * Sets margin bottom.
     *
     * @param marginBottom the margin bottom
     * @return the margin bottom
     */
    public Cell setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
        return this;
    }

    /**
     * Gets padding left.
     *
     * @return the padding left
     */
    public int getPaddingLeft() {
        return paddingLeft;
    }

    /**
     * Sets padding left.
     *
     * @param paddingLeft the padding left
     * @return the padding left
     */
    public Cell setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    /**
     * Gets padding top.
     *
     * @return the padding top
     */
    public int getPaddingTop() {
        return paddingTop;
    }

    /**
     * Sets padding top.
     *
     * @param paddingTop the padding top
     * @return the padding top
     */
    public Cell setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
        return this;
    }

    /**
     * Gets padding right.
     *
     * @return the padding right
     */
    public int getPaddingRight() {
        return paddingRight;
    }

    /**
     * Sets padding right.
     *
     * @param paddingRight the padding right
     * @return the padding right
     */
    public Cell setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    /**
     * Gets padding bottom.
     *
     * @return the padding bottom
     */
    public int getPaddingBottom() {
        return paddingBottom;
    }

    /**
     * Sets padding bottom.
     *
     * @param paddingBottom the padding bottom
     * @return the padding bottom
     */
    public Cell setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
        return this;
    }

    /**
     * Gets text size.
     *
     * @return the text size
     */
    public int getTextSize() {
        return textSize;
    }

    /**
     * Sets text size.
     *
     * @param textSize the text size
     * @return the text size
     */
    public Cell setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * Gets font style.
     *
     * @return the font style
     */
    public int getFontStyle() {
        return fontStyle;
    }

    /**
     * Sets font style.
     *
     * @param fontStyle the font style
     * @return the font style
     */
    public Cell setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    /**
     * Gets text color.
     *
     * @return the text color
     */
    public int getTextColor() {
        return textColor;
    }

    /**
     * Sets text color.
     *
     * @param textColor the text color
     * @return the text color
     */
    public Cell setTextColor(@ColorInt int textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * Gets background color.
     *
     * @return the background color
     */
    public int getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Sets background color.
     *
     * @param backgroundColor the background color
     * @return the background color
     */
    public Cell setBackgroundColor(@ColorInt int backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Gets gravity.
     *
     * @return the gravity
     */
    public int getGravity() {
        return gravity;
    }

    /**
     * Sets gravity.
     *
     * @param gravity the gravity
     * @return the gravity
     */
    public Cell setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * Gets border width.
     *
     * @return the border width
     */
    public int getBorderWidth() {
        return borderWidth;
    }

    /**
     * Sets border width.
     *
     * @param borderWidth the border width
     * @return the border width
     */
    public Cell setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Gets border color.
     *
     * @return the border color
     */
    public int getBorderColor() {
        return borderColor;
    }

    /**
     * Sets border color.
     *
     * @param borderColor the border color
     * @return the border color
     */
    public Cell setBorderColor(@ColorInt int borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Is border boolean.
     *
     * @return the boolean
     */
    public boolean isBorder() {
        return border;
    }

    /**
     * Sets border.
     *
     * @param border the border
     * @return the border
     */
    public Cell setBorder(boolean border) {
        this.border = border;
        return this;
    }

    /**
     * Gets line spacing.
     *
     * @return the line spacing
     */
    public float getLineSpacing() {
        return lineSpacing;
    }

    /**
     * Sets line spacing.
     *
     * @param lineSpacing the line spacing
     * @return the line spacing
     */
    public Cell setLineSpacing(float lineSpacing) {
        this.lineSpacing = lineSpacing;
        return this;
    }

    /**
     * Sets scale type.
     *
     * @param scaleType the scale type
     * @return the scale type
     */
    public Cell setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
        return this;
    }

    /**
     * Gets scale type.
     *
     * @return the scale type
     */
    public ImageView.ScaleType getScaleType() {
        return scaleType;
    }

    /**
     * Is left boolean.
     *
     * @return the boolean
     */
    public boolean isLeft() {
        return left;
    }

    /**
     * Sets left.
     *
     * @param left the left
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * Is right boolean.
     *
     * @return the boolean
     */
    public boolean isRight() {
        return right;
    }

    /**
     * Sets right.
     *
     * @param right the right
     */
    public void setRight(boolean right) {
        this.right = right;
    }

    /**
     * Is center boolean.
     *
     * @return the boolean
     */
    public boolean isCenter() {
        return center;
    }

    /**
     * Sets center.
     *
     * @param center the center
     */
    public void setCenter(boolean center) {
        this.center = center;
    }

    /**
     * Sets message.
     *
     * @param message the message
     * @return the message
     */
    public Cell setSpannableString(SpannableStringBuilder message) {
        this.spannableStringBuilder = message;
        return this;
    }

    /**
     * Gets spannable string builder.
     *
     * @return the spannable string builder
     */
    public SpannableStringBuilder getSpannableStringBuilder() {
        return spannableStringBuilder;
    }
}
