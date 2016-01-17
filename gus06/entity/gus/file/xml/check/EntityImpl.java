package gus06.entity.gus.file.xml.check;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, F, G, FileFilter {

	public String creationDate() {return "20150823";}
	

	private Service isOfType;

	public EntityImpl() throws Exception
	{isOfType = Outside.service(this,"gus.file.filter.mime.isoftype.application.xml");}

	
	public boolean f(Object obj) throws Exception
	{return isOfType.f(obj);}
	
	
	public Object g() throws Exception
	{return this;}
	
	
	
	public boolean accept(File f)
	{
		try{return f(f);}
		catch(Exception e) {Outside.err(this,"accept(File)",e);}
		return false;
	}
}
