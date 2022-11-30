package android.pdf.abstract_io;

import android.pdf.cell.Paragraph;

/**
 * This class to used to find the elementType on {@link Paragraph}.
 */
public abstract class Element {

    /**
     * Gets element type.
     *
     * @return the element type
     */
    public abstract byte getElementType();

}
