package gongjie.pdf.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;

import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import gongjie.pdf.entities.ImageJ;

public class PdfUtil {
	/**
	 * 
	 * @param in 原pdf 的inputstrream
	 * @param images 图片集合
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static byte[] pdfInsertImg(InputStream in,List<ImageJ>images) throws DocumentException, IOException {
		PdfReader reader=new PdfReader(in);
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		PdfStamper stamper=new PdfStamper(reader, os);
		
		//得到图片
		if(images.size()>0){
			for(ImageJ imageJ:images){
				//得到图片的字节数组
				byte[] bytes = imageJ.getBytes();
				//取得Image对象
				Image img = Image.getInstance(bytes);
				Rectangle rec = reader.getPageSize(imageJ.getPage());
				//页面高度
				float height = rec.getHeight();
				img.scaleToFit(imageJ.getWidth(), imageJ.getHeigth());
				img.setAbsolutePosition(imageJ.getLocWidth(),height-imageJ.getLocHeigth());
				PdfContentByte overContent = stamper.getOverContent(imageJ.getPage());				
				overContent.addImage(img);
			}
		}
		stamper.close();
		reader.close();
		return os.toByteArray();
	}
}
