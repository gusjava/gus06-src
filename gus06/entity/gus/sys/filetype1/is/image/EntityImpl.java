package gus06.entity.gus.sys.filetype1.is.image;

import gus06.framework.*;
import java.io.File;
import java.io.FileFilter;

public class EntityImpl implements Entity, F, G, FileFilter {

	public String creationDate() {return "20151017";}


	private Service isImage;

	public EntityImpl() throws Exception
	{isImage = Outside.service(this,"gus.file.filter.mime.issubtype.image");}
	
	
	public boolean f(Object obj) throws Exception
	{return isImage.f(obj);}
	
	
	public Object g() throws Exception
	{return this;}
	
	
	public boolean accept(File f)
	{
		try{return f(f);}
		catch(Exception e) {Outside.err(this,"accept(File)",e);}
		return false;
	}
}
