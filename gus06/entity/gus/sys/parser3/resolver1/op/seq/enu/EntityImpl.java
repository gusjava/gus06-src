package gus06.entity.gus.sys.parser3.resolver1.op.seq.enu;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151119";}

	public static final String VALUE = "value";
	public static final String TYPE = "type";
	public static final String ELEMENT = "element";
	

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List cut = (List) o[0];
		T t = (T) o[1];
		
		int number = cut.size();
		if(number<2) throw new Exception("Invalid operation: ENU");
		
		String key = null;
		List value = null;
		
		Map map = new HashMap();
		
		for(int i=0;i<number;i++)
		{
			List l = (List) cut.get(i);
			int number0 = l.size();
			
			if(i==0)
			{
				if(number0!=1) throw new Exception("Invalid operation: ENU");
				key = value((Map) l.get(0));
			}
			else if(i<number-1)
			{
				if(number0<2) throw new Exception("Invalid operation: ENU");
				value = new ArrayList();
				for(int j=0;j<number0-1;j++) value.add(l.get(j));
				map.put(key,t.t(value));
				key = value((Map) l.get(number0-1));
			}
			else
			{
				value = new ArrayList();
				for(int j=0;j<number0;j++) value.add(l.get(j));
				map.put(key,t.t(value));
			}
		}
		
		return map;
	}
	
	
	
	
	private String value(Map m) throws Exception
	{
		if(!m.get(TYPE).equals(ELEMENT))
			throw new Exception("Invalid operation: ENU");
		return (String) m.get(VALUE);
	}
}
