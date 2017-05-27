package gus06.entity.gus.dir.perform.searchparent.byname.last;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160904";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File input =(File) o[0];
		String name = (String) o[1];
		
		File found = null;
		
		File parent = input.getParentFile();
		while(parent!=null)
		{
			if(parent.getName().equals(name)) found = parent;
			parent = parent.getParentFile();
		}
		return found;
	}
}
