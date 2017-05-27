package gus06.entity.gus.sys.script1.executor.type.el.r.extends11;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, T {
	
	public String creationDate() {return "20160221";}
	
	public static final String X_PARENT = "parent";
	public static final String K_INCLUDED = "included";
	
	
	private Service handleContent;
	private Service wrapping1;
	private Service engine;
	private Service evaluate;
	private Service getExecution;


	public EntityImpl() throws Exception
	{
		handleContent = Outside.service(this,"gus.sys.script1.executor.type.el.r.extends1.content");
		wrapping1 = Outside.service(this,"gus.sys.script1.tool.execute.wrapping1");
		engine = Outside.service(this,"gus.sys.script1.engine");
		evaluate = Outside.service(this,"gus.sys.script1.context.evaluate");
		getExecution = Outside.service(this,"gus.sys.script1.access.context.execution");
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
			wrapping1.p(new Object[]{context,tag,new Wrap()});
		}
	}
	
	
	private class Wrap implements P
	{
		public void p(Object obj) throws Exception
		{
			Object[] o = (Object[]) obj;
			if(o.length!=5) throw new Exception("Wrong data number: "+o.length);
			
			Map context = (Map) o[0];
			Map tag = (Map) o[1];
			Map pool1 = (Map) o[2];
			Object main = o[3];
			Map data = (Map) o[4];
			
			String id = (String) main;
			T mapper = (T) evaluate.t(new Object[]{context,"script.file._mapper"});
			File file = (File) mapper.t(id);
			
			handleContent.p(new Map[]{context,tag});
			
			Map execution = (Map) getExecution.t(context);
			execution.put(X_PARENT,tag);
			
			Map included = (Map) engine.t(new Object[]{file,context});
			tag.put(K_INCLUDED,included);
		}
	}
	
	
	
	private Object get(Map map, String key)
	{return map.containsKey(key)?map.get(key):null;}
}
