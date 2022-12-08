package android.pdf.cell;

import android.pdf.io.Cell;
import android.pdf.constant.ElementType;

/**
 * This class used to create empty white space for creating a new page.
 */
public class AreaBreak extends Cell {

    /**
     * @return cellType
     */
    @Override
    public byte getCellType() {
        return ElementType.AREA_BREAK;
    }
}
