package android.pdf.core;

import android.content.Context;
import android.pdf.dimension.DimensionModel;
import android.pdf.io.Cell;
import android.pdf.bgImage.BgImage;
import android.pdf.constant.PageSize;
import android.pdf.io.PageCount;

import java.util.ArrayList;

/**
 * The type Instance.
 */
public class Instance {

    private static Instance instance;


    private int columnWeight;

    private int paddingLeft, paddingTop, paddingRight, paddingBottom;


    private Context context;

    private BgImage bgImage;

    private PageSize pageSize;

    private PageCount pageCount;

    private DimensionModel dimensionModel;


    private final ArrayList<Cell> cells = new ArrayList<>();

    private final ArrayList<Cell> headerCells = new ArrayList<>();

    private final ArrayList<Cell> footerCells = new ArrayList<>();

    /**
     * Sets instance.
     *
     * @param instance the instance
     */
    public static void setInstance(Instance instance) {
        Instance.instance = instance;
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }

    /**
     * Gets column weight.
     *
     * @return the column weight
     */
    public int getColumnWeight() {
        return getInstance().columnWeight;
    }

    /**
     * Sets column weight.
     *
     * @param columnWeight the column weight
     */
    protected void setColumnWeight(int columnWeight) {
        getInstance().columnWeight = columnWeight;
    }

    /**
     * Gets padding left.
     *
     * @return the padding left
     */
    public int getPaddingLeft() {
        return getInstance().paddingLeft;
    }

    /**
     * Sets padding left.
     *
     * @param paddingLeft the padding left
     */
    public void setPaddingLeft(int paddingLeft) {
        getInstance().paddingLeft = paddingLeft;
    }

    /**
     * Gets padding top.
     *
     * @return the padding top
     */
    public int getPaddingTop() {
        return getInstance().paddingTop;
    }

    /**
     * Sets padding top.
     *
     * @param paddingTop the padding top
     */
    public void setPaddingTop(int paddingTop) {
        getInstance().paddingTop = paddingTop;
    }

    /**
     * Gets padding right.
     *
     * @return the padding right
     */
    public int getPaddingRight() {
        return getInstance().paddingRight;
    }

    /**
     * Sets padding right.
     *
     * @param paddingRight the padding right
     */
    public void setPaddingRight(int paddingRight) {
        getInstance().paddingRight = paddingRight;
    }

    /**
     * Gets padding bottom.
     *
     * @return the padding bottom
     */
    public int getPaddingBottom() {
        return getInstance().paddingBottom;
    }

    /**
     * Sets padding bottom.
     *
     * @param paddingBottom the padding bottom
     */
    public void setPaddingBottom(int paddingBottom) {
        getInstance().paddingBottom = paddingBottom;
    }

    /**
     * Sets the margins.
     *
     * @param paddingLeft   the padding on the left
     * @param paddingTop    the padding on the right
     * @param paddingRight  the padding on the top
     * @param paddingBottom the padding on the bottom
     */
    public void setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        setPaddingLeft(paddingLeft);
        setPaddingTop(paddingTop);
        setPaddingRight(paddingRight);
        setPaddingBottom(paddingBottom);
    }

    /**
     * Sets the margins.
     *
     * @param padding   the padding on the left, top, right bottom
     */
    public void setPadding(int padding) {
        setPaddingLeft(padding);
        setPaddingTop(padding);
        setPaddingRight(padding);
        setPaddingBottom(padding);
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public Context getContext() {
        return getInstance().context;
    }

    /**
     * Sets context.
     *
     * @param context the context
     */
    protected void setContext(Context context) {
        getInstance().context = context;
    }

    /**
     * Gets bg image.
     *
     * @return the bg image
     */
    public BgImage getBgImage() {
        return getInstance().bgImage;
    }

    /**
     * Sets bg image.
     *
     * @param bgImage the bg image
     */
    public void setBgImage(BgImage bgImage) {
        getInstance().bgImage = bgImage;
    }

    /**
     * Gets page size.
     *
     * @return the page size
     */
    public PageSize getPageSize() {
        return getInstance().pageSize;
    }

    /**
     * Sets page size.
     *
     * @param pageSize the page size
     */
    protected void setPageSize(PageSize pageSize) {
        getInstance().pageSize = pageSize;
    }

    /**
     * Gets page count.
     *
     * @return the page count
     */
    protected PageCount getPageCount() {
        return getInstance().pageCount;
    }

    /**
     * Sets page count.
     *
     * @param pageCount the page count
     */
    public void setPageCount(PageCount pageCount) {
        getInstance().pageCount = pageCount;
    }

    /**
     * Gets dimension model.
     *
     * @return the dimension model
     */
    protected DimensionModel getDimensionModel() {
        return getInstance().dimensionModel;
    }

    /**
     * Sets dimension model.
     *
     * @param dimensionModel the dimension model
     */
    protected void setDimensionModel(DimensionModel dimensionModel) {
        getInstance().dimensionModel = dimensionModel;
    }

    /**
     * Gets cells.
     *
     * @return the cells
     */
    protected ArrayList<Cell> getCells() {
        return getInstance().cells;
    }

    /**
     * Gets header cells.
     *
     * @return the header cells
     */
    protected ArrayList<Cell> getHeaderCells() {
        return getInstance().headerCells;
    }

    /**
     * Gets footer cells.
     *
     * @return the footer cells
     */
    protected ArrayList<Cell> getFooterCells() {
        return getInstance().footerCells;
    }
}
