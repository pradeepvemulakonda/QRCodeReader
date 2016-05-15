package itext.pradeep;

import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;

public class QRCodeReader {
	
	private QRCodeImageRenderListener imageRenderListener;
	 
    /** The new document to which we've added a border rectangle. */
 
    public QRCodeImageRenderListener getImageRenderListener() {
		return imageRenderListener;
	}

	public void setImageRenderListener(QRCodeImageRenderListener imageRenderListener) {
		this.imageRenderListener = imageRenderListener;
	}

	/**
     * Parses a PDF and extracts all the images.
     * @param src the source PDF
     * @param dest the resulting PDF
     */
    public void extractImages(String filename)
        throws IOException, DocumentException {
        PdfReader reader = new PdfReader(filename);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        QRCodeImageRenderListener listener = getImageRenderListener();
        parser.processContent(1, listener);
        reader.close();
    }
 
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, DocumentException {
        
    }
}