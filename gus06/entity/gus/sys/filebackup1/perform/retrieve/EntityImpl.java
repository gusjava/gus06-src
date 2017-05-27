package gus06.entity.gus.sys.filebackup1.perform.retrieve;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161018";}



	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		String timeStamp = (String) o[1];
		
		if(timeStamp.equals("last")) return last(dir);
		
		File[] ff = dir.listFiles();
		for(File f:ff) if(f.getName().startsWith(timeStamp+"_")) return f;
		
		return null;
	}
	
	
	private File last(File dir)
	{
		File[] ff = dir.listFiles();
		if(ff==null || ff.length==0) return null;
		return ff[ff.length-1];
	}
}
