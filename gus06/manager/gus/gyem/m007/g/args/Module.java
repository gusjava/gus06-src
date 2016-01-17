package gus06.manager.gus.gyem.m007.g.args;

import gus06.framework.G;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {

	
	public static final String OE = "\\u152"; // character \\u152 = Œ
	
	
	private String[] args1;
	
	public Object g() throws Exception
	{
		if(args1==null) init();
		return args1;
	}
	
	
	private void init() throws Exception
	{
		String[] args = (String[]) get(KEY_APPARGS);
		
		if(args.length==0)
		{args1 = new String[0];return;}
		
		StringBuilder b = new StringBuilder(args[0]);
		for(int i=1;i<args.length;i++) b.append(" "+args[i]);
		String line = b.toString();
		
		args1 = line.replace(";;",OE).split(";",-1);   
		for(int i=0;i<args1.length;i++) args1[i] = args1[i].replace(OE,";");
	}
}