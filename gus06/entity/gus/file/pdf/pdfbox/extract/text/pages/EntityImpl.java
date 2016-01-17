package gus06.entity.gus.file.pdf.pdfbox.extract.text.pages;

import java.io.File;
import java.util.Map;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150617";}
	
	public static final String PAGE_DELIM = "________________\n";
	
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		PDFTextStripper stripper = null;
		PDDocument doc = null;
		int index = 1;
		
		StringBuffer b = new StringBuffer();
		
		try
		{
			doc = PDDocument.load(file);
			stripper = new PDFTextStripper();
			int number = pageNumber(doc);

			while(index <= number)
			{
				stripper.setStartPage(index);
				stripper.setEndPage(index+1);
				
				String text = stripper.getText(doc).trim();
				
				if(!text.equals(""))
				{
					b.append("PAGE"+index+PAGE_DELIM);
					b.append(text);
				}
				index++;
			}
		}
		finally
		{
			if(stripper!=null) stripper.resetEngine();
			if(doc!=null) doc.close();
		}
		return b.toString();
	}


	
	
	
	
	private int pageNumber(PDDocument doc)
	{
		try{return doc.getNumberOfPages();}
		catch(NullPointerException e) {return -1;}
	}
}
