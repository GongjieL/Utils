package gongjie.pdf;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.itextpdf.text.DocumentException;


/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     * @throws DocumentException
     * @throws IOException
     */
    public static void main( String[] args ) throws DocumentException, IOException
    {
    		FileInputStream in=new FileInputStream("d://500d-resume (1).pdf");
    		FileInputStream in2=new FileInputStream("d://376CCBA2A309EEF896581C7125746E36.png");
    		PdfUtil.pdfInsertImg(in, IOUtils.toByteArray(in2));
    		
    }
}
