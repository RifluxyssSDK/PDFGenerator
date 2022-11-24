package android.pdf.merger;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfDocument;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class used to merge pdf files.
 */
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class DocumentMerger {

    private File destination;

    /**
     * The Files.
     */
    final List<File> files = new ArrayList<>();

    /**
     * The Pdf document.
     */
    final PdfDocument pdfDocument = new PdfDocument();

    /**
     * Sets destination file.
     *
     * @param destination the destination
     */
    public void setDestinationFile(File destination) {
        this.destination = destination;
    }

    /**
     * Add source.
     *
     * @param filePath the file path
     */
    public void addSource(File filePath) {
        files.add(filePath);
    }

    /**
     * Merge document.
     *
     * @throws IOException the io exception
     */
    public void mergeDocument() throws IOException {

        if (destination != null && files.size() > 0) {

            FileOutputStream fileOutputStream = new FileOutputStream(destination);

            for (File file : files) {

                PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));

                for (int i = 0; i < pdfRenderer.getPageCount(); i++) {

                    PdfRenderer.Page openPage = pdfRenderer.openPage(i);
                    Bitmap bitmap = Bitmap.createBitmap(openPage.getWidth(), openPage.getHeight(), Bitmap.Config.ARGB_8888);
                    openPage.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);

                    if (bitmap != null) {

                        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), 1).create();
                        PdfDocument.Page page = pdfDocument.startPage(pageInfo);
                        page.getCanvas().drawBitmap(bitmap, 0, 0, null);
                        pdfDocument.finishPage(page);
                    }

                    openPage.close();
                }

                pdfRenderer.close();
            }

            pdfDocument.writeTo(fileOutputStream);
            pdfDocument.close();
        }
    }
}
