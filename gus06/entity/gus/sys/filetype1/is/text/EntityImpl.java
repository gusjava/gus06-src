package gus06.entity.gus.sys.filetype1.is.text;

import gus06.framework.*;
import java.io.File;
import java.io.FileFilter;

public class EntityImpl implements Entity, F, G, FileFilter {

	public String creationDate() {return "20151017";}


	private Service isText;

	public EntityImpl() throws Exception
	{isText = Outside.service(this,"gus.file.filter.mime.isoftype.text.plain");}
	
	
	public boolean f(Object obj) throws Exception
	{return isText.f(obj);}
	
	
	public Object g() throws Exception
	{return this;}
	
	
	public boolean accept(File f)
	{
		try{return f(f);}
		catch(Exception e) {Outside.err(this,"accept(File)",e);}
		return false;
	}
}
