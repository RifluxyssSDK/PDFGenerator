package com.pdf.structure;

import java.util.ArrayList;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Table {

    final int colWeight;
    final ArrayList<Cell> cells = new ArrayList<>();
    final ArrayList<Cell> headerCells = new ArrayList<>();
    final ArrayList<Cell> footerCells = new ArrayList<>();

    public Table(int colWeight) {
        this.colWeight = colWeight;
    }

    public Table addCell(Cell cell) {
        cells.add(cell);
        return this;
    }

    public Table addCell(ArrayList<Cell> cell) {
        cells.addAll(cell);
        return this;
    }

    public Table addHeaderCell(Cell cell) {
        headerCells.add(cell);
        return this;
    }

    public Table addHeaderCell(ArrayList<Cell> cell) {
        headerCells.addAll(cell);
        return this;
    }

    public Table addFooterCell(Cell cell) {
        footerCells.add(cell);
        return this;
    }

    public Table addFooterCell(ArrayList<Cell> cell) {
        footerCells.addAll(cell);
        return this;
    }

    public ArrayList<Cell> getHeaderCells() {
        return headerCells;
    }

    public ArrayList<Cell> getFooterCells() {
        return footerCells;
    }

    public int getColWeight() {
        return colWeight;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }

}
