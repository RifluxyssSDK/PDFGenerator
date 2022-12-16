package android.pdf.exception;

import android.graphics.Bitmap;
import android.pdf.core.Instance;

/**
 * The type Authorization.
 *
 * The class <code>Exception</code> and its subclasses are a form of Throwable that indicates conditions that a reasonable application might want to catch.
 */
public class Authorization extends Instance {

    /**
     * Col span authenticate.
     *
     * @param colSpan the col span
     */
    public static void colSpanAuthenticate(int colSpan) {
        if (colSpan > Instance.getInstance().getColumnWeight() && Instance.getInstance().getColumnWeight() !=0 ) {
            throw new Error("colSpan mustn't exceed the columnWeight. ( Max Value : " + Instance.getInstance().getColumnWeight() +" )");
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
        if (Instance.getInstance().getColumnWeight() == 0) {
            throw new NullPointerException("You been must call 'open' method before add 'Elements'");
        } else if (Instance.getInstance().getContext() == null) {
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
        if (Instance.getInstance().getPageSize().getPageWidth() == 0) {
            throw new NullPointerException("You been must call 'close' method");
        } else {
            return true;
        }
    }
}
