package gus06.entity.gus.sys.script1.main.fromargs.init.find;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20170408";}
	
	public static final String REGEX = "[0-9a-zA-Z_]+(\\.gus)?";

	
	private String input;

	public EntityImpl() throws Exception
	{
		String[] args = (String[]) Outside.resource(this,"main.appargs");
		input = find(args);
	}
	
	
	public Object g() throws Exception
	{return input;}
	
	
	
	
	
	private String find(String[] args)
	{
		if(args==null || args.length==0) return null;
		if(args.length==1 && args[0].matches(REGEX)) return args[0];
		
		for(String arg:args)
		if(arg.startsWith("script=")) return arg.substring(7);
		
		return null;
	}
}
