package gus06.entity.gus.list.build.from.chars;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170225";}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		List list = new ArrayList();
		for(int i=0;i<s.length();i++) list.add(""+s.charAt(i));
		return list;
	}
}
