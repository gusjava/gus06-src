package gus06.entity.gus.sys.clipboard1.g.listfiles2.convertstring;

import gus06.framework.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class EntityImpl implements Entity, T, P {

	public String creationDate() {return "20151021";}


	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] nn = s.split("\n");
		
		List list = new ArrayList();
		for(String n:nn)
		{
			File f = new File(n.trim());
			if(f.exists()) list.add(f);
		}
		return list;
	}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
}
