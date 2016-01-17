package gus06.entity.gus.file.info.pdf.pagenumber;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150823";}


	private Service check;
	private Service info;
	
	
	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.file.pdf.check");
		info = Outside.service(this,"gus.file.pdf.lowagie.pdfpage.number");
	}



	public Object t(Object obj) throws Exception
	{
		if(!check.f(obj)) return null;
		return info.t(obj);
	}
}
