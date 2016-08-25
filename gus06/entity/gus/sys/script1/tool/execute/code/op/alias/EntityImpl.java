package gus06.entity.gus.sys.script1.tool.execute.code.op.alias;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P {
	
	public static final String C_ALIAS = "alias";

	public String creationDate() {return "20150906";}


	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map context = (Map) o[0];
		String line = (String) o[1];
		
		Map alias = getAliasMap(context);
		setAlias(alias,line);
	}
	
	
	
	private Map getAliasMap(Map m) throws Exception
	{
		if(!m.containsKey(C_ALIAS)) throw new Exception("alias not found inside context");
		return (Map) m.get(C_ALIAS);
	}
	
	private void setAlias(Map m, String s)
	{
		String[] n = s.split("=",2);
		m.put(n[0],n[1]);
	}
}
