package gus06.entity.gus.dir.listing0.names0;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151106";}


	private Service getName;

	public EntityImpl() throws Exception
	{getName = Outside.service(this,"gus.file.getname0");}


	public Object t(Object obj) throws Exception
	{
		File[] f = toListing(obj);
		
		String[] n = new String[f.length];
		for(int i=0;i<f.length;i++) n[i] = (String) getName.t(f[i]);
		
		return n;
	}
	
	
	
	private File[] toListing(Object obj) throws Exception
	{
		if(obj instanceof File[]) return (File[]) obj;
		if(obj instanceof File) return ((File) obj).listFiles();
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
