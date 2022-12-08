package android.pdf.dimension;

import android.pdf.core.Instance;
import android.util.DisplayMetrics;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Dimension {

    private final Instance instance = Instance.getInstance();

    public void saveDefaultDisplayMetrics() {
        instance.setDisplayMetrics(instance.getContext().getResources().getDisplayMetrics());
    }

    public void setDefaultDisplayMetrics() {
        instance.getContext().getResources().getDisplayMetrics().setTo(instance.getDisplayMetrics());
    }

    public void setCustomDisplayMetrics() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.density = 2f;
        displayMetrics.densityDpi = 320;
        displayMetrics.heightPixels = 1184;
        displayMetrics.widthPixels = 768;
        displayMetrics.scaledDensity = 2f;
        displayMetrics.xdpi = 320f;
        displayMetrics.ydpi = 320f;
        instance.getContext().getResources().getDisplayMetrics().setTo(displayMetrics);
    }
}
