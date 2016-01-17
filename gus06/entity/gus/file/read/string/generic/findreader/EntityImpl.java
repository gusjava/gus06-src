package gus06.entity.gus.file.read.string.generic.findreader;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150620";}


	private Service readString_txt;
	private Service readString_pdf;
	private Service readString_prop;
	
	private Service default0;
	

	
	public EntityImpl() throws Exception
	{
		readString_txt = Outside.service(this,"gus.file.read.string.from.txt");
		readString_pdf = Outside.service(this,"gus.file.read.string.from.pdf");
		readString_prop = Outside.service(this,"gus.file.read.string.from.properties");
	}
	

	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return findReader(file);
	}
	
	
	private Service findReader(File file) throws Exception
	{
		String s = file.getName().toLowerCase();
		
		if(en(s,"txt")) return readString_txt;
		if(en(s,"pdf")) return readString_pdf;
		if(en(s,"properties")) return readString_prop;
		
		return null;
	}
	
	
	private boolean en(String s, String ext)
	{return s.endsWith("."+ext);}
}
