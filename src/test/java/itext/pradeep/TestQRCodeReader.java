package itext.pradeep;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.itextpdf.text.DocumentException;

public class TestQRCodeReader {

    public static final String RESULT = "results/tables/barcode_table.pdf";
	
    @Before
    public void setUp() throws IOException, DocumentException {
    	File file = new File(RESULT);
        file.getParentFile().mkdirs();
        new QRCodeWriter().createPdf(RESULT, "523421121");
    }
    
	@Test
	public void test() throws IOException, DocumentException {
		QRCodeReader codeReader = new QRCodeReader();
		QRCodeImageRenderListener imageRenderListener = new QRCodeImageRenderListener();
		codeReader.setImageRenderListener(imageRenderListener);
		codeReader.extractImages(RESULT);
        Assert.assertEquals("523421121", imageRenderListener.getQrCodeText());
        
	}
}
