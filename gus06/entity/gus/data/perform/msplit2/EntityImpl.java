package gus06.entity.gus.data.perform.msplit2;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170219";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		String glue1 = (String) o[1];
		String glue2 = (String) o[2];
		
		if(input instanceof String)
		return split((String) input,glue1,glue2);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	private Map split(String s, String glue1, String glue2) throws Exception
	{
		Map map = new HashMap();
		String[] nn = s.split(glue2,-1);
		for(String n:nn)
		{
			String[] kk = n.split(glue1,2);
			String key = kk[0];
			String value = kk.length==2?kk[1]:"";
			map.put(key,value);
		}
		return map;
	}
}
