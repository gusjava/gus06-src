package gus06.entity.gus.file.pdf.pdfbox.extract.text;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150617";}


	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		StringWriter writer = new StringWriter();
		PDDocument doc = null;

		try
		{
			doc = PDDocument.load(file);
			PDFTextStripper stripper = new PDFTextStripper();
			stripper.writeText(doc,writer);
		}
		finally
		{
			if(doc!=null) doc.close();
		}
		return writer.getBuffer().toString();
	}
}
