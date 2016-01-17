package gus06.entity.gus.dir.perform.copyfiles.fromclipboard.paths;

import gus06.framework.*;
import java.io.File;
import java.util.List;

public class EntityImpl implements Entity, P, F {

	public String creationDate() {return "20151021";}


	private Service fromClipboard;
	private Service copyFile;


	public EntityImpl() throws Exception
	{
		fromClipboard = Outside.service(this,"gus.sys.clipboard1.g.listfiles2");
		copyFile = Outside.service(this,"gus.dir.perform.copyfile");
	}
	
	
	public void p(Object obj) throws Exception
	{f(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{
		File dir = (File) obj;
		
		List files = (List) fromClipboard.g();
		if(files==null || files.isEmpty()) return false;
		
		for(Object o:files)
		{
			File f = (File) o;
			copyFile.p(new File[]{f,dir});
		}
		return true;
	}
}
