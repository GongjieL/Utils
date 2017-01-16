package gongjie.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;

import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PdfUtil {
	/**
	 * 插入图片（运用itext，位置被写死了）
	 * @param in  原pdfinputstream
	 * @param imgb 图片
	 * @throws DocumentException
	 * @throws IOException
	 * @return 输出的字节数组
	 */
	public static byte[] pdfInsertImg(InputStream in,byte[]imgb) throws DocumentException, IOException {
		PdfReader reader=new PdfReader(in);
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		PdfStamper stamper=new PdfStamper(reader, os);
		Rectangle rec = reader.getPageSize(1);
		//页面高度
		float height = rec.getHeight();
		//得到图片
		Image img = Image.getInstance(imgb);
		//第一页的操作页面
		img.scaleToFit(80, 120);
		img.setAbsolutePosition(444, height-120);
		PdfContentByte overContent = stamper.getOverContent(1);
		
		overContent.addImage(img);
		stamper.close();
		reader.close();
		return os.toByteArray();
	}
}
