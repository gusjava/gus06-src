package gus06.entity.gus.file.read.properties.generic.findreader;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151018";}


	private Service readProp_txt;
	private Service readProp_pdf;
	private Service readProp_prop;
	private Service readProp_eml;
	private Service readProp_ini;
	
	private Service default0;
	

	
	public EntityImpl() throws Exception
	{
		readProp_txt = Outside.service(this,"gus.file.read.properties.from.txt");
		readProp_pdf = Outside.service(this,"gus.file.read.properties.from.pdf");
		readProp_prop = Outside.service(this,"gus.file.read.properties.from.properties");
		readProp_eml = Outside.service(this,"gus.file.read.properties.from.eml");
		readProp_ini = Outside.service(this,"gus.file.read.properties.from.ini");
	}
	

	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return findReader(file);
	}
	
	
	private Service findReader(File file) throws Exception
	{
		String s = file.getName().toLowerCase();
		
		if(en(s,"txt")) return readProp_txt;
		if(en(s,"pdf")) return readProp_pdf;
		if(en(s,"properties")) return readProp_prop;
		if(en(s,"eml")) return readProp_eml;
		if(en(s,"ini")) return readProp_ini;
		
		return null;
	}
	
	
	private boolean en(String s, String ext)
	{return s.endsWith("."+ext);}
}
