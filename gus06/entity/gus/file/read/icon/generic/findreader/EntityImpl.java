package gus06.entity.gus.file.read.icon.generic.findreader;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160209";}


	private Service readIcon_gif;
	private Service readIcon_png;
	
	private Service default0;
	

	
	public EntityImpl() throws Exception
	{
		readIcon_gif = Outside.service(this,"gus.file.read.icon.from.gif");
		readIcon_png = Outside.service(this,"gus.file.read.icon.from.png");
	}
	

	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return findReader(file);
	}
	
	
	private Service findReader(File file) throws Exception
	{
		String s = file.getName().toLowerCase();
		
		if(en(s,"gif")) return readIcon_gif;
		if(en(s,"png")) return readIcon_png;
		
		return null;
	}
	
	
	private boolean en(String s, String ext)
	{return s.endsWith("."+ext);}
}
