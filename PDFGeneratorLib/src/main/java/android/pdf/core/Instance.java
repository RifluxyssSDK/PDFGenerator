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
        return columnWeight;
    }

    /**
     * Sets column weight.
     *
     * @param columnWeight the column weight
     */
    public void setColumnWeight(int columnWeight) {
        this.columnWeight = columnWeight;
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
     */
    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
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
     */
    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
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
     */
    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
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
     */
    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public Context getContext() {
        return context;
    }

    /**
     * Sets context.
     *
     * @param context the context
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * Gets bg image.
     *
     * @return the bg image
     */
    public BgImage getBgImage() {
        return bgImage;
    }

    /**
     * Sets bg image.
     *
     * @param bgImage the bg image
     */
    public void setBgImage(BgImage bgImage) {
        this.bgImage = bgImage;
    }

    /**
     * Gets page size.
     *
     * @return the page size
     */
    public PageSize getPageSize() {
        return pageSize;
    }

    /**
     * Sets page size.
     *
     * @param pageSize the page size
     */
    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets page count.
     *
     * @return the page count
     */
    public PageCount getPageCount() {
        return pageCount;
    }

    /**
     * Sets page count.
     *
     * @param pageCount the page count
     */
    public void setPageCount(PageCount pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Gets dimension model.
     *
     * @return the dimension model
     */
    public DimensionModel getDimensionModel() {
        return dimensionModel;
    }

    /**
     * Sets dimension model.
     *
     * @param dimensionModel the dimension model
     */
    public void setDimensionModel(DimensionModel dimensionModel) {
        this.dimensionModel = dimensionModel;
    }

    /**
     * Gets cells.
     *
     * @return the cells
     */
    public ArrayList<Cell> getCells() {
        return cells;
    }

    /**
     * Gets header cells.
     *
     * @return the header cells
     */
    public ArrayList<Cell> getHeaderCells() {
        return headerCells;
    }

    /**
     * Gets footer cells.
     *
     * @return the footer cells
     */
    public ArrayList<Cell> getFooterCells() {
        return footerCells;
    }
}
