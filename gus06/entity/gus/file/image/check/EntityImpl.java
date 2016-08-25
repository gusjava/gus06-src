package gus06.entity.gus.file.image.check;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, F, G, FileFilter {

	public String creationDate() {return "20160412";}
	

	private Service isSubType;

	public EntityImpl() throws Exception
	{isSubType = Outside.service(this,"gus.file.filter.mime.issubtype.image");}

	
	public boolean f(Object obj) throws Exception
	{return isSubType.f(obj);}
	
	
	public Object g() throws Exception
	{return this;}
	
	
	
	public boolean accept(File f)
	{
		try{return f(f);}
		catch(Exception e) {Outside.err(this,"accept(File)",e);}
		return false;
	}
}
