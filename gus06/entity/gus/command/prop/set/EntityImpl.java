package gus06.entity.gus.command.prop.set;

import java.util.Map;

import gus06.framework.*;

public class EntityImpl implements Entity, P, V, R {

	public String creationDate() {return "20140703";}

	private Map prop;
	
	public EntityImpl() throws Exception
	{
		prop = (Map) Outside.resource(this,"prop");
	}
	
	
	public void p(Object obj) throws Exception
	{
		String s = (String) obj;
		
		String[] n = s.split("=",2);
		if(n.length!=2) throw new Exception("Invalid data: "+s);
		
		change(n[0],n[1]);
	}
	
	
	public void v(String key, Object obj) throws Exception
	{change(key,(String) obj);}
	
	
	public Object r(String key) throws Exception
	{return prop.containsKey(key)?prop.get(key):null;}
	
	
	
	
	private void change(String key, String value) throws Exception
	{
		if(value==null) prop.remove(key);
		else prop.put(key,value);
	}
}
