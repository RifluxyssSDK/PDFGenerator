package android.pdf.io;

import android.pdf.kernel.ElementType;

public class AreaBreak extends Cell {

    @Override
    public byte getCellType() {
        return ElementType.AREA_BREAK;
    }
}
