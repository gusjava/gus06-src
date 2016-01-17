package gus06.entity.gus.sys.jsonparser1.resolver.tag.group3;

import gus06.framework.*;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151125";}
	
	private Service cutMethod1;
	private Service cutMethod2;

	public EntityImpl() throws Exception
	{
		cutMethod1 = Outside.service(this,"gus.sys.parser3.resolver1.cut.symbol1");
		cutMethod2 = Outside.service(this,"gus.sys.parser3.resolver1.cut.d.symbol1");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List l = (List) o[0];
		T t = (T) o[1];
		
		Map result = new HashMap();
		if(l.isEmpty()) return result;
		
		List cut = (List) cutMethod1.t(new Object[]{l,","});
		if(cut==null)
		{
			addToMap(result,l,t);
		}
		else
		{
			int number = cut.size();
			for(int i=0;i<number;i++)
			{
				List x = (List) cut.get(i);
				addToMap(result,x,t);
			}
		}
		return result;
	}
	
	
	
	private void addToMap(Map map, List l, T t) throws Exception
	{
		List[] cut = (List[]) cutMethod2.t(new Object[]{l,":"});
		if(cut==null) throw new Exception("Invalid element inside map");
		
		Object key = t.t(cut[0]);
		Object value = t.t(cut[1]);
		map.put(key,value);
	}
}
