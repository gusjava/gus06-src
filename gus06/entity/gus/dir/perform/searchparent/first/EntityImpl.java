package gus06.entity.gus.dir.perform.searchparent.first;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160829";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File input =(File) o[0];
		F filter = (F) o[1];
		
		File parent = input.getParentFile();
		while(parent!=null && !filter.f(parent))
			parent = parent.getParentFile();
		
		return parent;
	}
}
