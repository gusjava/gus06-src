package gus06.entity.gus.dirfile.perform.rename.ask;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, F {

	public String creationDate() {return "20170303";}


	private Service handleFile;
	private Service handleDir;


	public EntityImpl() throws Exception
	{
		handleFile = Outside.service(this,"gus.file.perform.rename.ask");
		handleDir = Outside.service(this,"gus.dir.perform.rename.ask");
	}
	
	
	public void p(Object obj) throws Exception
	{f(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{
		File f = (File) obj;
		if(f.isFile()) return handleFile.f(f);
		return handleDir.f(f);
	}
}
