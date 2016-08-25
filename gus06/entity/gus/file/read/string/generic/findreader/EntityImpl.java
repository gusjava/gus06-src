package gus06.entity.gus.file.read.string.generic.findreader;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150620";}


	private Service readString_txt;
	private Service readString_pdf;
	private Service readString_prop;
	private Service readString_docx;
	private Service isOfTypeTextPlain;
	

	
	public EntityImpl() throws Exception
	{
		readString_txt = Outside.service(this,"gus.file.read.string.from.txt");
		readString_pdf = Outside.service(this,"gus.file.read.string.from.pdf");
		readString_prop = Outside.service(this,"gus.file.read.string.from.properties");
		readString_docx = Outside.service(this,"gus.file.read.string.from.docx");
		isOfTypeTextPlain = Outside.service(this,"gus.file.filter.mime.isoftype.text.plain");
	}
	

	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return findReader(file);
	}
	
	
	private Service findReader(File file) throws Exception
	{
		String s = file.getName().toLowerCase();
		
		if(en(s,"properties")) return readString_prop;
		if(en(s,"pdf")) return readString_pdf;
		if(en(s,"docx")) return readString_docx;
		
		if(isOfTypeTextPlain.f(file))
			return readString_txt;
		
		throw new Exception("File type not supported yet: "+file);
	}
	
	
	private boolean en(String s, String ext)
	{return s.endsWith("."+ext);}
}
