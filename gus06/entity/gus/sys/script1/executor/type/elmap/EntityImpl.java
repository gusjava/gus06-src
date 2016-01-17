package gus06.entity.gus.sys.script1.executor.type.elmap;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20150830";}

	
	private Map map;

	public EntityImpl() throws Exception
	{
		map = new HashMap();
		
		put("alias",		Outside.service(this,"gus.sys.script1.executor.type.el.op.alias"));
		put("comment",		Outside.service(this,"gus.sys.script1.executor.type.el.op.comment"));
		put("execute",		Outside.service(this,"gus.sys.script1.executor.type.el.op.execute"));
		put("mouse",		Outside.service(this,"gus.sys.script1.executor.type.el.op.mouse"));
		put("output",		Outside.service(this,"gus.sys.script1.executor.type.el.op.output"));
		put("print",		Outside.service(this,"gus.sys.script1.executor.type.el.op.print"));
		put("set",		Outside.service(this,"gus.sys.script1.executor.type.el.op.set"));
		put("set0",		Outside.service(this,"gus.sys.script1.executor.type.el.op.set0"));
		put("set1",		Outside.service(this,"gus.sys.script1.executor.type.el.op.set1"));
		put("wait",		Outside.service(this,"gus.sys.script1.executor.type.el.op.wait"));
		
		put("block",		Outside.service(this,"gus.sys.script1.executor.type.el.r.block"));
		put("code",		Outside.service(this,"gus.sys.script1.executor.type.el.r.code"));
		put("each",		Outside.service(this,"gus.sys.script1.executor.type.el.r.each"));
		put("extends",		Outside.service(this,"gus.sys.script1.executor.type.el.r.extends1"));
		put("for",		Outside.service(this,"gus.sys.script1.executor.type.el.r.for1"));
		put("function",		Outside.service(this,"gus.sys.script1.executor.type.el.r.function"));
		put("if",		Outside.service(this,"gus.sys.script1.executor.type.el.r.if1"));
		put("ignore",		Outside.service(this,"gus.sys.script1.executor.type.el.r.ignore"));
		put("redirect",		Outside.service(this,"gus.sys.script1.executor.type.el.r.redirect"));
		put("repeat",		Outside.service(this,"gus.sys.script1.executor.type.el.r.repeat"));
		put("try",		Outside.service(this,"gus.sys.script1.executor.type.el.r.try1"));
		put("until",		Outside.service(this,"gus.sys.script1.executor.type.el.r.until"));
		put("while",		Outside.service(this,"gus.sys.script1.executor.type.el.r.while1"));
		
		put("call",		Outside.service(this,"gus.sys.script1.executor.type.el.z.call"));
		put("debug",		Outside.service(this,"gus.sys.script1.executor.type.el.z.debug"));
		put("else",		Outside.service(this,"gus.sys.script1.executor.type.el.z.else1"));
		put("end",		Outside.service(this,"gus.sys.script1.executor.type.el.z.end"));
		put("include",		Outside.service(this,"gus.sys.script1.executor.type.el.z.include"));
		put("stop",		Outside.service(this,"gus.sys.script1.executor.type.el.z.stop"));
		
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
		if(!map.containsKey(name)) return null;
		return get(name);
	}
	
	
	public Object g() throws Exception
	{return map;}
}