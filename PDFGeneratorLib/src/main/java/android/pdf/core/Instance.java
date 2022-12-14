package android.pdf.core;

import android.content.Context;
import android.pdf.dimension.DimensionModel;
import android.pdf.io.Cell;
import android.pdf.bgImage.BgImage;
import android.pdf.constant.PageSize;
import android.pdf.io.PageCount;

import java.util.ArrayList;

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


    public static Instance getInstance() {
        return instance;
    }

    public static Instance createInstance() {
        instance = new Instance();
        return instance;
    }

    public int getColumnWeight() {
        return columnWeight;
    }

    public void setColumnWeight(int columnWeight) {
        this.columnWeight = columnWeight;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public Context getContext() {
        return context;
    }

    public Instance setContext(Context context) {
        this.context = context;
        return this;
    }

    public BgImage getBgImage() {
        return bgImage;
    }

    public void setBgImage(BgImage bgImage) {
        this.bgImage = bgImage;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    public PageCount getPageCount() {
        return pageCount;
    }

    public void setPageCount(PageCount pageCount) {
        this.pageCount = pageCount;
    }

    public DimensionModel getDimensionModel() {
        return dimensionModel;
    }

    public void setDimensionModel(DimensionModel dimensionModel) {
        this.dimensionModel = dimensionModel;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

    public ArrayList<Cell> getHeaderCells() {
        return headerCells;
    }

    public ArrayList<Cell> getFooterCells() {
        return footerCells;
    }
}
