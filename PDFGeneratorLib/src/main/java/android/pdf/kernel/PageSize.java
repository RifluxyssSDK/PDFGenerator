package android.pdf.kernel;

@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PageSize {

    public final int documentWidth;
    public final int documentHeight;

    public int pageWidth;
    public int pageHeight;

    public static final PageSize A0 = new PageSize(2384, 3370);
    public static final PageSize A1 = new PageSize(1684, 2384);
    public static final PageSize A2 = new PageSize(1190, 1684);
    public static final PageSize A3 = new PageSize(842, 1190);
    public static final PageSize A4 = new PageSize(595, 842);
    public static final PageSize A5 = new PageSize(420, 595);
    public static final PageSize A6 = new PageSize(298, 420);
    public static final PageSize A7 = new PageSize(210, 298);
    public static final PageSize A8 = new PageSize(148, 210);
    public static final PageSize A9 = new PageSize(105, 547);
    public static final PageSize A10 = new PageSize(74, 105);

    public static final PageSize B0 = new PageSize(2834, 4008);
    public static final PageSize B1 = new PageSize(2004, 2834);
    public static final PageSize B2 = new PageSize(1417, 2004);
    public static final PageSize B3 = new PageSize(1000, 1417);
    public static final PageSize B4 = new PageSize(708, 1000);
    public static final PageSize B5 = new PageSize(498, 708);
    public static final PageSize B6 = new PageSize(354, 498);
    public static final PageSize B7 = new PageSize(249, 354);
    public static final PageSize B8 = new PageSize(175, 249);
    public static final PageSize B9 = new PageSize(124, 175);
    public static final PageSize B10 = new PageSize(88, 124);

    public static final PageSize DEFAULT = A4;

    public static final PageSize EXECUTIVE = new PageSize(522, 756);
    public static final PageSize LEDGER = new PageSize(1224, 792);
    public static final PageSize LEGAL = new PageSize(612, 1008);
    public static final PageSize LETTER = new PageSize(612, 792);
    public static final PageSize TABLOID = new PageSize(792, 1224);

    public PageSize(int documentWidth, int documentHeight) {
        this.documentWidth = documentWidth;
        this.documentHeight = documentHeight;
    }

    public void decreasePadding(int paddingWidth, int paddingHeight) {
        this.pageWidth = documentWidth - paddingWidth;
        this.pageHeight = documentHeight - paddingHeight;
    }
}

