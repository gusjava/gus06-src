package gus06.entity.gus.file.pdf.lowagie.pdfpage.number;

import java.io.File;
import java.io.FileInputStream;
import com.lowagie.text.pdf.PdfReader;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150823";}


	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		FileInputStream fis = null;
		PdfReader reader = null;
		int nbPages = -1;

		try
		{
			fis = new FileInputStream(file);
			reader = new PdfReader(fis);
			nbPages = reader.getNumberOfPages();
		}
		finally
		{
			if(fis!=null) fis.close();
			if(reader!=null) reader.close();
		}
		return ""+nbPages;
	}
}
