package gus06.entity.gus.sys.script1.tool.execute.code.opmap;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20150906";}

	
	private Map map;


	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("alias",		Outside.service(this,"gus.sys.script1.tool.execute.code.op.alias"));
		put("comment",		Outside.service(this,"gus.sys.script1.tool.execute.code.op.comment"));
		put("execute",		Outside.service(this,"gus.sys.script1.tool.execute.code.op.execute"));
		put("mouse",		Outside.service(this,"gus.sys.script1.tool.execute.code.op.mouse"));
		put("output",		Outside.service(this,"gus.sys.script1.tool.execute.code.op.output"));
		put("print",		Outside.service(this,"gus.sys.script1.tool.execute.code.op.print"));
		put("set",		Outside.service(this,"gus.sys.script1.tool.execute.code.op.set"));
		put("set0",		Outside.service(this,"gus.sys.script1.tool.execute.code.op.set0"));
		put("set1",		Outside.service(this,"gus.sys.script1.tool.execute.code.op.set1"));
		put("wait",		Outside.service(this,"gus.sys.script1.tool.execute.code.op.wait"));
		
		put("p",		get("print"));
		put("e",		get("execute"));
		put("c",		get("comment"));
		put("s",		get("set"));
	}
	
	
	private void put(String name, Service s)
	{map.put(name,s);}
	
	private Service get(String name)
	{return (Service) map.get(name);}
	
	
	
	public Object t(Object obj) throws Exception
	{
		String name = (String) obj;
		if(!map.containsKey(name))
			throw new Exception("Undefined operator for name: "+name);
		return get(name);
	}
	
	
	public Object g() throws Exception
	{return map;}
}
