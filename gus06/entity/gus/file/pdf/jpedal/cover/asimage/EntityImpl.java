package gus06.entity.gus.file.pdf.jpedal.cover.asimage;

import java.awt.Image;
import java.io.File;
import org.jpedal.Display;
import org.jpedal.PdfDecoder;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150616";}
	
	
	public EntityImpl() throws Exception
	{
		System.setProperty("org.jpedal.jai","true");
	}


	
	
	public Object t(Object obj) throws Exception
	{
		return firstPageAsImage((File) obj);
	}
	
	
	private Image firstPageAsImage(File file) throws Exception
	{
		PdfDecoder decoder = null;
		
		try
		{
			decoder = new PdfDecoder(false);
			decoder.setDisplayView(Display.SINGLE_PAGE,Display.DISPLAY_CENTERED);
			decoder.openPdfFile(file.getAbsolutePath());
			decoder.decodePage(1);
			Image image = decoder.getPageAsImage(1);
			decoder.closePdfFile();
			
			return image;
		}
		catch(Exception e)
		{
			if(decoder!=null) decoder.closePdfFile();
			throw e;
		}
	}
}
