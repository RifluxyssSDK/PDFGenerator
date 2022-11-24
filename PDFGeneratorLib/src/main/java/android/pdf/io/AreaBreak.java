package android.pdf.io;

import android.pdf.kernel.ElementType;

/**
 * This class used to create empty white space for creating a new page.
 */
public class AreaBreak extends Cell {

    @Override
    public byte getCellType() {
        return ElementType.AREA_BREAK;
    }
}
