package gus06.entity.gus.file.info.pagenumber;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150825";}


	private Service checkPdf;
	private Service infoPdf;
	
	
	public EntityImpl() throws Exception
	{
		checkPdf = Outside.service(this,"gus.file.pdf.check");
		infoPdf = Outside.service(this,"gus.file.pdf.lowagie.pdfpage.number");
	}



	public Object t(Object obj) throws Exception
	{
		if(checkPdf.f(obj)) return infoPdf.t(obj);
		
		// word
		// excel
		// ps
		// ...
		return null;
	}
}
