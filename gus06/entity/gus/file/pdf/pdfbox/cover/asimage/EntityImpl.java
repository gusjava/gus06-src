package gus06.entity.gus.file.pdf.pdfbox.cover.asimage;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150616";}



	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return firstPageAsImage(file);
	}
	
	
	
	private Image firstPageAsImage(File file) throws Exception
	{
		PDDocument doc = PDDocument.load(file);
		PDDocumentCatalog catalog = doc.getDocumentCatalog();
		List allPages = catalog.getAllPages();
		if(allPages==null || allPages.isEmpty()) return null;
		
		PDPage page = (PDPage) allPages.get(0);
		Image image = page.convertToImage(BufferedImage.TYPE_INT_RGB,200);
		doc.close();
		
		return image;
	}
}
