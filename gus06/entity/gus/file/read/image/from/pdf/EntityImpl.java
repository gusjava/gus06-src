package gus06.entity.gus.file.read.image.from.pdf;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150616";}


	private Service imageFromPdf1;
	private Service imageFromPdf2;


	public EntityImpl() throws Exception
	{
		imageFromPdf1 = Outside.service(this,"gus.file.pdf.jpedal.cover.asimage");
		imageFromPdf2 = Outside.service(this,"gus.file.pdf.pdfbox.cover.asimage");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object r1 = imageFromPdf1(obj);
		if(r1!=null) return r1;
		
		Object r2 = imageFromPdf2(obj);
		if(r2!=null) return r2;
		
		throw new Exception("Failed to read image from pdf: "+obj);
	}
	
	
	
	private Object imageFromPdf1(Object obj)
	{
		try{return imageFromPdf1.t(obj);}
		catch(Exception e){Outside.err(this,"imageFromPdf1(Object)",e);}
		return null;
	}
	
	
	private Object imageFromPdf2(Object obj)
	{
		try{return imageFromPdf2.t(obj);}
		catch(Exception e){Outside.err(this,"imageFromPdf2(Object)",e);}
		return null;
	}
}
