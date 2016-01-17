package gus06.entity.gus.file.read.string.from.pdf;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150617";}


	private Service textFromPdf;


	public EntityImpl() throws Exception
	{
		textFromPdf = Outside.service(this,"gus.file.pdf.pdfbox.extract.text.pages");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return textFromPdf.t(obj);
	}
}
