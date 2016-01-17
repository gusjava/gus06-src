package gus06.entity.gus.sys.script1.tool.execute.tag;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, P {
	
	public static final String K_CONTEXT = "context";
	
	public static final String C_HISTORY = "history";
	public static final String C_CURRENT = "current";
	public static final String C_START = "start";
	public static final String C_STOP = "stop";


	public String creationDate() {return "20150829";}


	private Service getExecutor;


	public EntityImpl() throws Exception
	{
		getExecutor = Outside.service(this,"gus.sys.script1.access.tag.executor1");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Map[] o = (Map[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map tag = o[0];
		Map context = o[1];
		
		if(context.containsKey(C_STOP)) return;
		handleContext(context,tag);
		
		try
		{
			P p = (P) getExecutor.t(tag);
			p.p(context);
		}
		catch(Exception e)
		{
			String message = "Failed to execute tag ["+tag+"]";
			throw new Exception(message,e);
		}
	}
	
	
	
	
	private void handleContext(Map context, Map tag)
	{
		tag.put(K_CONTEXT,context);
		
		if(!context.containsKey(C_START)) context.put(C_START,tag);
		
		context.put(C_CURRENT,tag);
		List history = (List) context.get(C_HISTORY);
		history.add(tag);
	}
}
