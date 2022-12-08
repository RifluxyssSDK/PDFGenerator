package android.pdf.core;

import android.content.Context;
import android.pdf.io.Cell;
import android.pdf.bgImage.BgImage;
import android.pdf.constant.PageSize;
import android.pdf.io.PageCount;
import android.util.DisplayMetrics;

import java.util.ArrayList;

public class Instance {

    private static Instance instance;


    private int columnWeight;

    private int paddingLeft, paddingTop, paddingRight, paddingBottom;


    private Context context;

    private BgImage bgImage;

    private PageSize pageSize;

    private PageCount pageCount;


    private DisplayMetrics displayMetrics;


    private final ArrayList<Cell> cells = new ArrayList<>();

    private final ArrayList<Cell> headerCells = new ArrayList<>();

    private final ArrayList<Cell> footerCells = new ArrayList<>();


    public Instance() {
        if (instance == null) {
            instance = this;
        }
    }

    public static Instance getInstance() {
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

    public void setContext(Context context) {
        this.context = context;
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

    public DisplayMetrics getDisplayMetrics() {
        return displayMetrics;
    }

    public void setDisplayMetrics(DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
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
