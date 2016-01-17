package gus06.entity.gus.entitydev.filelisting;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150430";}

	
	
	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
		ArrayList list = new ArrayList();
		
		dir = new File(new File(dir,"gus06"),"entity");
		if(!dir.isDirectory()) return list;
		
		scan(dir,list);
		Collections.sort(list);
		return list;
	}
	
	
	
	private void scan(File path, ArrayList list)
	{
		if(isEntityFile(path))
			list.add(path);
		
		if(path.isDirectory())
		{
			File[] ff = path.listFiles();
			for(File f:ff) scan(f,list);
		}
	}
	
	
	
	private boolean isEntityFile(File f)
	{return f.isFile() && f.getName().equals("EntityImpl.java");}
}
