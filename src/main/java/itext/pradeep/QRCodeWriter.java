package itext.pradeep;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;
 
 
public class QRCodeWriter {

    public void createPdf(String dest, String code) throws IOException, DocumentException {
    	  Document document = new Document(PageSize.A4);
          PdfWriter.getInstance(document, new FileOutputStream(dest));
          document.open();
          document.add(new Paragraph("Barcode QRCode"));
          BarcodeQRCode qrcode = new BarcodeQRCode(code, 100, 100, null);
          Image img = qrcode.getImage();
          img.setAbsolutePosition(document.getPageSize().getRight() - 100, document.getPageSize().getTop() - 100);
          document.add(img);
          // step 5
          document.close();
    }
}