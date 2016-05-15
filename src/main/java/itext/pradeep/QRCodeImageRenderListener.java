package itext.pradeep;

import java.io.IOException;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.PdfImageObject;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class QRCodeImageRenderListener implements RenderListener {

	private String qrCodeText;
	
    public String getQrCodeText() {
		return qrCodeText;
	}

	public void setQrCodeText(String qrCodeText) {
		this.qrCodeText = qrCodeText;
	}

	/**
     * @see com.itextpdf.text.pdf.parser.RenderListener#beginTextBlock()
     */
    public void beginTextBlock() {
    }

    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#endTextBlock()
     */
    public void endTextBlock() {
    }

    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#renderImage(
     *     com.itextpdf.text.pdf.parser.ImageRenderInfo)
     */
    public void renderImage(ImageRenderInfo renderInfo) {
        try {
            PdfImageObject image = renderInfo.getImage();
            if (image == null) return;
            // creating luminance source
            LuminanceSource lumSource = new BufferedImageLuminanceSource(image.getBufferedImage());
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(lumSource));

            // barcode decoding
            QRCodeReader reader = new QRCodeReader();

            Result result = null;
            try {
            	result = reader.decode(bitmap);
            	setQrCodeText(result.getText());
            } catch (ReaderException e) {
            	throw new IllegalStateException(e);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @see com.itextpdf.text.pdf.parser.RenderListener#renderText(
     *     com.itextpdf.text.pdf.parser.TextRenderInfo)
     */
    public void renderText(TextRenderInfo renderInfo) {
    }
}