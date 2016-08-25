package gus06.entity.gus.file.getname0ext;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160602";}

	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		String name = file.getName();
		if(!name.contains("."))
			return new String[]{name,""};
		
		String[] n = name.split("\\.");
		String ext = n[n.length-1].toLowerCase();
		String name0 = name.substring(0,name.length()-ext.length()-1);
		
		return new String[]{name0,ext};
	}
}
