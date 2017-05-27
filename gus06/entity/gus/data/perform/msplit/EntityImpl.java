package gus06.entity.gus.data.perform.msplit;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170119";}

	
	
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
		String[] nn = s.split(Pattern.quote(glue2),-1);
		for(String n:nn)
		{
			String[] kk = n.split(Pattern.quote(glue1),2);
			String key = kk[0];
			String value = kk.length==2?kk[1]:"";
			map.put(key,value);
		}
		return map;
	}
}
