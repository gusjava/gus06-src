package gus06.entity.gus.file.getextension;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140929";}

	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		String name = file.getName();
		if(!name.contains(".")) return "";
		
		String[] n = name.split("\\.");
		return n[n.length-1];
	}
}
