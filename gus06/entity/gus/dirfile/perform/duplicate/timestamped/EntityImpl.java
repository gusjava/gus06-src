package gus06.entity.gus.dirfile.perform.duplicate.timestamped;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, T, F {

	public String creationDate() {return "20151004";}


	private Service handleFile;
	private Service handleDir;


	public EntityImpl() throws Exception
	{
		handleFile = Outside.service(this,"gus.file.perform.duplicate.timestamped");
		handleDir = Outside.service(this,"gus.dir.perform.duplicate.timestamped");
	}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{return t(obj)!=null;}
	
	
	public Object t(Object obj) throws Exception
	{
		File f = (File) obj;
		if(f.isFile()) return handleFile.t(f);
		return handleDir.t(f);
	}
}
