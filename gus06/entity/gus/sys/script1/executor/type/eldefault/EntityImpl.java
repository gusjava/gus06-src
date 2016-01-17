package gus06.entity.gus.sys.script1.executor.type.eldefault;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {
	
	public static final String K_NAME = "name";
	public static final String K_PARAMS = "params";
	
	public static final String C_ALIAS = "alias";


	public String creationDate() {return "20150830";}
	



	private Service elMap;
	
	public EntityImpl() throws Exception
	{
		elMap = Outside.service(this,"gus.sys.script1.executor.type.elmap");
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
			String info = getAliasInfo(context);
			
			String[] n = info.split("[ \n\t]+",2);
			
			String name1 = n[0];
			String params1 = n.length==2?n[1]:null;
			
			T builder = (T) elMap.t(name1);
			if(builder==null) throw new Exception("Unknown alias name for element tag: "+name1);
			
			
			String oldParams = (String) get(tag,K_PARAMS);
			String newParams = buildNewParams(params1,oldParams);
			
			setParams(newParams);
			
			P executor = (P) builder.t(tag);
			executor.p(context);
			
			setParams(oldParams);
		}
		
		
		
		private String buildNewParams(String params1, String oldParams)
		{
			if(params1==null) return oldParams;
			if(oldParams==null) return params1;
			return params1+" "+oldParams;
			
		}
		
		private void setParams(String s)
		{
			if(s!=null) tag.put(K_PARAMS,s);
			else tag.remove(K_PARAMS);
		}
		
		
		
		
		private String getAliasInfo(Map context) throws Exception
		{
			Map alias = (Map) get(context,C_ALIAS);
			if(alias==null) throw new Exception("Alias not found inside context");
			
			String name = (String) get(tag,K_NAME);
			if(name==null) throw new Exception("Name not found inside element tag");
			
			String info = (String) get(alias,name);
			if(info==null) throw new Exception("Unknown name for element tag: "+name);
			
			return info;
		}
	}
	
	
	
	private Object get(Map map, String key)
	{return map.containsKey(key)?map.get(key):null;}
}
