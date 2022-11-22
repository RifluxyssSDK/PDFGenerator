package com.rifluxyss.pdfgenerator.structure;

import java.util.ArrayList;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Paragraph {

    final ArrayList<Cell> cells = new ArrayList<>();

    public Paragraph add(Cell cell) {
        cells.add(cell);
        return this;
    }

    public Paragraph add(ArrayList<Cell> cell) {
        cells.addAll(cell);
        return this;
    }

    public ArrayList<Cell> getCells() {
        return cells;
    }
}
