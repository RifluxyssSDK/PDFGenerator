package android.pdf.exception;

import android.graphics.Bitmap;
import android.pdf.core.Instance;

/**
 * The type Authorization.
 *
 * The class <code>Exception</code> and its subclasses are a form of Throwable that indicates conditions that a reasonable application might want to catch.
 */
public class Authorization extends Exception {

    private static final Instance instance = Instance.getInstance();

    /**
     * Col span authenticate.
     *
     * @param colSpan the col span
     */
    public static void colSpanAuthenticate(int colSpan) {
        if (colSpan > instance.getColumnWeight() && instance.getColumnWeight() !=0 ) {
            throw new Error("colSpan mustn't exceed the columnWeight. ( Max Value : " + instance.getColumnWeight() +" )");
        }
    }

    /**
     * Bitmap authenticate.
     *
     * @param bitmap the bitmap
     */
    public static void bitmapAuthenticate(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Given bitmap is Null");
        }
    }

    /**
     * Document authenticate boolean.
     *
     * @return the boolean
     */
    public static boolean documentAuthenticate() {
        if (instance.getColumnWeight() == 0) {
            throw new NullPointerException("You been must call 'open' method before add 'Elements'");
        } else if (instance.getContext() == null) {
            throw new NullPointerException("You been must call 'init' method to initialize library");
        } else {
            return true;
        }
    }

    /**
     * Document close authenticate boolean.
     *
     * @return the boolean
     */
    public static boolean documentCloseAuthenticate() {
        if (instance.getPageSize().getPageWidth() == 0) {
            throw new NullPointerException("You been must call 'close' method");
        } else {
            return true;
        }
    }
}
