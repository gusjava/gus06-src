package gus06.entity.gus.entitydev.listing1;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140703";}
	
	public static final String KEY = "dev.entityroot";

	private Service dirToListing;
	private File rootDir;
	
	
	
	public EntityImpl() throws Exception
	{
		dirToListing = Outside.service(this,"gus.entitydev.listing");
		rootDir = (File) Outside.resource(this,"path#path.dev.entityroot");
	}
	
	
	public Object g() throws Exception
	{
		if(rootDir==null) return null;
		return dirToListing.t(rootDir);
	}
}
