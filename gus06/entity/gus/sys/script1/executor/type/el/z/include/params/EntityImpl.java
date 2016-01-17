package gus06.entity.gus.sys.script1.executor.type.el.z.include.params;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151118";}
	
	public static final String K_SRC = "src";
	public static final String K_ARGS = "args";
	public static final String K_REPEAT = "repeat";
	public static final String K_REDIRECT = "redirect";
	public static final String K_IF = "if";
	
	public static final String RULE = "[src] with [map]|[src]";




	private Service evalAsObject;
	
	public EntityImpl() throws Exception
	{
		evalAsObject = Outside.service(this,"gus.sys.script1.context.evaluate.withrule");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map context = (Map) o[0];
		String params = (String) o[1];
		
		
		Map data = (Map) evalAsObject.t(new Object[]{context,params,RULE});
		Map m = new HashMap();
		
		transfer(data,m,K_SRC);
		
		if(has(data,"map"))
		{
			Map map = (Map) get(data,"map");
			
			transfer(map,m,K_ARGS);
			transfer(map,m,K_REPEAT);
			transfer(map,m,K_REDIRECT);
			transfer(map,m,K_IF);
		}
		return m;
	}
	
	
	
	
	
	private boolean has(Map m, String key)
	{
		if(m==null || key==null) return false;
		return m.containsKey(key);
	}
	
	
	private Object get(Map m, String key)
	{
		if(m==null || key==null) return null;
		if(!m.containsKey(key)) return null;
		return m.get(key);
	}
	
	
	
	private void transfer(Map m1, Map m2, String key)
	{
		if(!has(m1,key)) return;
		if(m2==null) return;
		
		m2.put(key,m1.get(key));
	}
}
