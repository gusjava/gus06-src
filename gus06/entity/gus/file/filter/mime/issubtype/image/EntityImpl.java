package gus06.entity.gus.file.filter.mime.issubtype.image;

import java.io.File;
import java.io.FileFilter;
import gus06.framework.*;

public class EntityImpl implements Entity, F, G, FileFilter {

	public String creationDate() {return "20151017";}
	
	public static final String SUBTYPE = "image";

	private Service checkSubType;

	public EntityImpl() throws Exception
	{checkSubType = Outside.service(this,"gus.file.mime.tika.check.issubtype");}

	
	public boolean f(Object obj) throws Exception
	{return checkSubType.f(new Object[]{obj,SUBTYPE});}
	
	
	public Object g() throws Exception
	{return this;}
	
	
	
	public boolean accept(File f)
	{
		try{return f(f);}
		catch(Exception e) {Outside.err(this,"accept(File)",e);}
		return false;
	}
}
