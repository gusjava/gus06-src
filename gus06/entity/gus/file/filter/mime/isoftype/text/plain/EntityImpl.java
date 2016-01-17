package gus06.entity.gus.file.filter.mime.isoftype.text.plain;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, F, G, FileFilter {

	public String creationDate() {return "20150819";}
	
	public static final String TYPE = "text/plain";

	private Service checkMime;

	public EntityImpl() throws Exception
	{checkMime = Outside.service(this,"gus.file.mime.tika.check.isoftype");}

	
	public boolean f(Object obj) throws Exception
	{return checkMime.f(new Object[]{obj,TYPE});}
	
	
	public Object g() throws Exception
	{return this;}
	
	
	
	public boolean accept(File f)
	{
		try{return f(f);}
		catch(Exception e) {Outside.err(this,"accept(File)",e);}
		return false;
	}
}
