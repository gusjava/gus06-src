package gus06.manager.gus.gyem.m121.g.defaultgui.emptytext;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.VERSION;
import gus06.manager.gus.gyem.tools.Tool_Args;
import java.util.Map;


public class Module extends GyemSystem implements G {
	
	public Object g() throws Exception
	{
		String argsLine = argsLine();
		
		StringBuffer b = new StringBuffer();
		
		b.append("Manager ID = "+VERSION.ID+"\n");
		b.append("Application type = "+getType()+"\n");
		if(argsLine!=null) b.append("Args line: "+argsLine+"\n");
		
		return b.toString();
	}
	
	
	
	private String argsLine()
	{
		String[] args = (String[]) get(KEY_APPARGS);
		if(args==null || args.length==0) return null;
		return Tool_Args.toString(args);
	}
	
	
	private String getType() throws Exception
	{
		Map prop = (Map) ((G) module(M012_G_PROP)).g();
		if(prop==null || !prop.containsKey(PROP_TYPE)) return TYPE_DEFAULT;
		return (String) prop.get(PROP_TYPE);
	}
}