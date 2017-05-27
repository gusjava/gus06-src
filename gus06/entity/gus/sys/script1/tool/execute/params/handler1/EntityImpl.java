package gus06.entity.gus.sys.script1.tool.execute.params.handler1;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160126";}
   
	public static final String K_OPTIONS = "options";
   

	public static final String[] KEYS = new String[]{
				"main",
				"args",
				"var",
				"if",
				"sort",
				"redirect",
				"repeat",
				"min",
				"max",
				"skip",
				"keep",
				"while",
				"until",
				"op",
				"alter",
				"before",
				"after",
				"return",
				"e"};
	
	public static final String[] RULES = new String[]{
				"[main] with [options]",
				"[main] args [args]",
				"[main] var [var]",
				"[main] if [if]",
				"[main] sort [sort]",
				"[main] redirect [redirect]",
				"[main] repeat [repeat]",
				"[main] min [min]",
				"[main] max [max]",
				"[main] skip [skip]",
				"[main] keep [keep]",
				"[main] while [while]",
				"[main] until [until]",
				"[main] op [op]",
				"[main] alter [alter]",
				"[main] before [before]",
				"[main] after [after]",
				"[main] return [return]",
				"[main] e [e]",
				"[main]"};

	



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
	   	
		Map m = new HashMap();
	   	
		if(params!=null && !params.equals(""))
		{
			Map data = (Map) evalAsObject.t(new Object[]{context,params,RULES});
		
			for(String key:KEYS) transfer(data,m,key);
		
			Map options = (Map) get(data,K_OPTIONS);
			if(options!=null) m.putAll(options);
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