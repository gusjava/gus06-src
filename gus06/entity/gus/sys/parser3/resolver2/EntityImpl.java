package gus06.entity.gus.sys.parser3.resolver2;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class EntityImpl implements Entity, T, V {

	public String creationDate() {return "20151119";}
	
	public static final String VALUE = "value";


	private Service resolver1;

	private T external;

	public EntityImpl() throws Exception
	{
		resolver1 = Outside.service(this,"gus.sys.parser3.resolver1");
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("external")) {external = (T) obj;return;}
		throw new Exception("Unknown key: "+key);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		String rule = (String) o[1];
		
		String[] rr = rule.split("\\|");
		for(String r:rr)
		{
			Map value = build(list,r);
			if(value!=null) return value;
		}
		return null;
	}
	
	
	private Map build(List list, String r) throws Exception
	{
		List list1 = new ArrayList(list);
		String[] nn = r.split(" ");
		Map map = new HashMap();
		
		String key = null;
		List buff = null;
		
		for(String n:nn)
		{
			if(b(n))
			{
				key = bb(n);
				buff = new ArrayList();
			}
			else
			{
				if(buff==null)
				{
					Map tag = nextTag(list1);
					if(!value(tag).equals(n)) return null;
				}
				else
				{
					Map tag = nextTag(list1);
					while(tag!=null && !value(tag).equals(n))
					{
						buff.add(tag);
						tag = nextTag(list1);
					}
				
					if(tag==null) return null;
					if(buff.isEmpty()) return null;
				
					map.put(key,resolve(buff));
				}
			}
		}
		
		if(buff==null) return null;
		
		Map tag = nextTag(list1);
		while(tag!=null)
		{
			buff.add(tag);
			tag = nextTag(list1);
		}
		
		if(!buff.isEmpty()) map.put(key,resolve(buff));
		return map;
	}
	
	
	
	
	
	private Object resolve(Object list) throws Exception
	{
		resolver1.v("external",external);
		return resolver1.t(list);
	}
	
	
	private boolean b(String s)
	{return s.startsWith("[") && s.endsWith("]");}
	
	private String bb(String s)
	{return s.substring(1,s.length()-1);}
	
	
	private Map nextTag(List l)
	{
		if(l.isEmpty()) return null;
		return (Map) l.remove(0);
	}
	
	private Object value(Map m)
	{return m.get(VALUE);}
}
