package android.pdf.core;

import android.content.Context;
import android.pdf.constant.DocType;
import android.pdf.constant.PageSize;
import android.pdf.exception.Authorization;
import android.pdf.io.Cell;

import java.io.File;
import java.io.IOException;

/**
 * A Document class.
 * <p>
 * All kinds of Elements can be stored to a <CODE>Instance</CODE>.
 * </P><BR>
 * Remark:
 * <OL>
 * <BR>
 * <LI>Once a document is created you can add some meta information.
 * <LI>You can also set the headers/footers.
 * <LI>You have to open the document before you can write content.
 * <LI>You can only write content (no more meta-formation!) once a document is opened.
 * <LI>After closing the document, you can't able to add more Elements.
 * <LI>Finally finish your document with <CODE>OutputStream</CODE>
 * </OL><BR>
 * Example:
 * <H6></H6>
 * <PRE>
 * Document document = new Document().init(context);
 * document.open(10);
 * document.add(new Paragraph().add(new Text(1,10,"Hello Document")));
 * document.close();
 * try {
 *      document.finish(file);
 * } catch (IOException e) {
 *      e.printStackTrace();
 * }
 * </PRE>
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class Document extends Instance {

    /**
     * A {@link PdfGenerateFactory} class
     *
     * <p>
     * This class initialize each and every actions by fixed order.
     * </P>
     */
    private final PdfGenerateFactory pdfGenerateFactory = new PdfGenerateFactory();

    /**
     * <P>Sets the pagesize.</P>
     * <p>
     * Constructs a new <CODE>Document</CODE> -object.
     *
     * @param pageSize the pageSize
     */
    public Document(PageSize pageSize) {
        setPageSize(pageSize);
    }

    /**
     * <P>Sets the pagesize.</P>
     * <p>
     * Constructs a new <CODE>Document</CODE> -object.
     */
    public Document() {
        setPageSize(PageSize.DEFAULT);
    }

    /**
     * Opens the document.
     * <p>
     * You have to open the document before you can
     * begin to add content to the document.
     * </P>
     *
     * @param context the context stored to {@link Instance}.
     * @return Document for continues declaration
     */
    public Document init(Context context) {
        setContext(context);
        return this;
    }

    /**
     * @param DocType DocType have three types.
     *                <p><OL>
     *                <LI> DocType.HEADER.
     *                <LI> DocType.FOOTER.
     *                <LI> DocType.NORMAL.
     *                </OL></P><BR>
     * @param cell    The <CODE>Cell</CODE> that has to be written
     */
    public void add(byte DocType, Cell cell) {
        addCell(DocType, cell);
    }

    /**
     * @param cell The <CODE>Cell</CODE> that has to be written
     */
    public void add(Cell cell) {
        addCell(DocType.NORMAL, cell);
    }

    /**
     * <P>Document has been opened and that</P>
     * <P>Cells can be added.</P>
     * <P>When this method is called, setColumnWeight method on {@link Instance} class.</P>
     *
     * @param columnWeight This value define as how many columns in singleRow.
     */
    public void open(int columnWeight) {
        setColumnWeight(columnWeight);
    }

    /**
     * <P>This method spilt {@link Cell} by docType.</P>
     * <P>This method should be overridden in the specific Cell classes derived from this abstract class.</P>
     * <P>Cell abstract classes:
     * <OL>
     * <LI>{@link android.pdf.cell.Paragraph}.
     * <LI>{@link android.pdf.cell.AreaBreak}.
     * </OL></P>
     *
     * @param cell A high level object to add
     */
    private void addCell(byte docType, Cell cell) {
        if (Authorization.documentAuthenticate()) {
            if (docType == DocType.NORMAL) {
                getCells().add(cell);
            } else if (docType == DocType.HEADER) {
                getHeaderCells().add(cell);
            } else if (docType == DocType.FOOTER) {
                getFooterCells().add(cell);
            }
        }
    }

    /**
     * <P>Document has been closed, and that called initialize method on pdfGenerateFactory to perform actions given below :</P><BR>
     * <OL>
     * <LI>initialize CustomDimension.
     * <LI>calculate PageSize.
     * <LI>calculate PageCount.
     * </OL>
     */
    public void close() {
        if (Authorization.documentAuthenticate()) {
            pdfGenerateFactory.initialize();
        }
    }

    /**
     * @throws IOException on error
     * @param file The <CODE>file</CODE> the document has to write to.
     */
    public void finish(File file) throws IOException {
        if (Authorization.documentCloseAuthenticate()) {
            pdfGenerateFactory.finish(file);
            pdfGenerateFactory.terminate();
        }
    }
}
