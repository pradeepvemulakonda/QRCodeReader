package itext.pradeep;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.itextpdf.text.DocumentException;

public class TestQRCodeGeneration {

	public static final String DEST = "results/tables/barcode_table.pdf";
	
	@Test
	public void test() throws IOException, DocumentException {
		File file = new File(DEST);
        file.getParentFile().mkdirs();
        new QRCodeWriter().createPdf(DEST, "523421121");
        Assert.assertNotNull(new File(DEST));
	}

}
