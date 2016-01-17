package gus06.entity.gus.sys.script1.executor.type.el.z.stop;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {
	
	public String creationDate() {return "20150830";}

	public static final String C_STOP = "stop";
	public static final String K_IF = "if";
	
	
	private Service getParams;
	private Service buildData;
	
	public EntityImpl() throws Exception
	{
		getParams = Outside.service(this,"gus.sys.script1.access.tag.params0");
		buildData = Outside.service(this,"gus.sys.script1.executor.type.el.z.stop.params");
	}
	
	
	public Object t(Object obj) throws Exception
	{return new Executor((Map) obj);}
	
	
	
	private class Executor implements P
	{
		private Map tag;
		public Executor(Map tag) {this.tag = tag;}
		
		public void p(Object obj) throws Exception
		{
			Map context = (Map) obj;
			String params = (String) getParams.t(tag);
			Map data = (Map) buildData.t(new Object[]{context,params});
			
			Boolean if1 = (Boolean) get(data,K_IF);
			if(if1!=null && !if1.booleanValue()) return;
			
			context.put(C_STOP,tag);
		}
	}
	
	
	private Object get(Map map, String key)
	{
		if(!map.containsKey(key)) return null;
		return map.get(key);
	}
}
