package android.pdf.kernel;

/**
 * The type Page size.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class PageSize {

    /**
     * The Document width.
     */
    public final int documentWidth;
    /**
     * The Document height.
     */
    public final int documentHeight;

    /**
     * The Page width.
     */
    public int pageWidth;
    /**
     * The Page height.
     */
    public int pageHeight;

    /**
     * The constant A0.
     */
    public static final PageSize A0 = new PageSize(2384, 3370);
    /**
     * The constant A1.
     */
    public static final PageSize A1 = new PageSize(1684, 2384);
    /**
     * The constant A2.
     */
    public static final PageSize A2 = new PageSize(1190, 1684);
    /**
     * The constant A3.
     */
    public static final PageSize A3 = new PageSize(842, 1190);
    /**
     * The constant A4.
     */
    public static final PageSize A4 = new PageSize(595, 842);
    /**
     * The constant A5.
     */
    public static final PageSize A5 = new PageSize(420, 595);
    /**
     * The constant A6.
     */
    public static final PageSize A6 = new PageSize(298, 420);
    /**
     * The constant A7.
     */
    public static final PageSize A7 = new PageSize(210, 298);
    /**
     * The constant A8.
     */
    public static final PageSize A8 = new PageSize(148, 210);
    /**
     * The constant A9.
     */
    public static final PageSize A9 = new PageSize(105, 547);
    /**
     * The constant A10.
     */
    public static final PageSize A10 = new PageSize(74, 105);

    /**
     * The constant B0.
     */
    public static final PageSize B0 = new PageSize(2834, 4008);
    /**
     * The constant B1.
     */
    public static final PageSize B1 = new PageSize(2004, 2834);
    /**
     * The constant B2.
     */
    public static final PageSize B2 = new PageSize(1417, 2004);
    /**
     * The constant B3.
     */
    public static final PageSize B3 = new PageSize(1000, 1417);
    /**
     * The constant B4.
     */
    public static final PageSize B4 = new PageSize(708, 1000);
    /**
     * The constant B5.
     */
    public static final PageSize B5 = new PageSize(498, 708);
    /**
     * The constant B6.
     */
    public static final PageSize B6 = new PageSize(354, 498);
    /**
     * The constant B7.
     */
    public static final PageSize B7 = new PageSize(249, 354);
    /**
     * The constant B8.
     */
    public static final PageSize B8 = new PageSize(175, 249);
    /**
     * The constant B9.
     */
    public static final PageSize B9 = new PageSize(124, 175);
    /**
     * The constant B10.
     */
    public static final PageSize B10 = new PageSize(88, 124);

    /**
     * The constant DEFAULT.
     */
    public static final PageSize DEFAULT = A4;

    /**
     * The constant EXECUTIVE.
     */
    public static final PageSize EXECUTIVE = new PageSize(522, 756);
    /**
     * The constant LEDGER.
     */
    public static final PageSize LEDGER = new PageSize(1224, 792);
    /**
     * The constant LEGAL.
     */
    public static final PageSize LEGAL = new PageSize(612, 1008);
    /**
     * The constant LETTER.
     */
    public static final PageSize LETTER = new PageSize(612, 792);
    /**
     * The constant TABLOID.
     */
    public static final PageSize TABLOID = new PageSize(792, 1224);

    /**
     * Instantiates a new Page size.
     *
     * @param documentWidth  the document width
     * @param documentHeight the document height
     */
    public PageSize(int documentWidth, int documentHeight) {
        this.documentWidth = documentWidth;
        this.documentHeight = documentHeight;
    }

    /**
     * Decrease padding.
     *
     * @param paddingWidth  the padding width
     * @param paddingHeight the padding height
     */
    public void decreasePadding(int paddingWidth, int paddingHeight) {
        this.pageWidth = documentWidth - paddingWidth;
        this.pageHeight = documentHeight - paddingHeight;
    }
}

