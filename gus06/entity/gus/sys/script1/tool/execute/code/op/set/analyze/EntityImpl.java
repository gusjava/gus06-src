package gus06.entity.gus.sys.script1.tool.execute.code.op.set.analyze;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151111";}
	
	public static final String MODE_REPLACE = "replace";
	public static final String MODE_CHANGE = "change";
	public static final String MODE_APPEND = "append";


	private Service evalAsObject;

	public EntityImpl() throws Exception
	{
		evalAsObject = Outside.service(this,"gus.sys.script1.context.evaluate");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String line = (String) o[0];
		Map context = (Map) o[1];
		
		if(!line.contains("="))
		{
			if(line.endsWith("++"))
			{
				line = line.substring(0,line.length()-2);
				line = line+"="+line+"+1";
			}
			else if(line.endsWith("--"))
			{
				line = line.substring(0,line.length()-2);
				line = line+"="+line+"-1";
			}
			else if(line.endsWith("**"))
			{
				line = line.substring(0,line.length()-2);
				line = line+"="+line+"*2";
			}
			else if(line.endsWith("//"))
			{
				line = line.substring(0,line.length()-2);
				line = line+"="+line+"/2";
			}
			else throw new Exception("Invalid set operation: "+line);
		}
		
		String[] n = line.split(" *= *",2);
		
		String key = n[0];
		String exp = n[1];
		String mode = MODE_REPLACE;
		
		if(key.endsWith("["))
		{
			key = key.substring(0,key.length()-1)+".after";
		}
		else if(key.endsWith("]"))
		{
			key = key.substring(0,key.length()-1)+".before";
		}
		else if(key.endsWith("+"))
		{
			key = key.substring(0,key.length()-1);
			exp = key+"+("+exp+")";
		}
		else if(key.endsWith("-"))
		{
			key = key.substring(0,key.length()-1);
			exp = key+"-("+exp+")";
		}
		else if(key.endsWith("*"))
		{
			key = key.substring(0,key.length()-1);
			exp = key+"*("+exp+")";
		}
		else if(key.endsWith("/"))
		{
			key = key.substring(0,key.length()-1);
			exp = key+"/("+exp+")";
		}
		else if(key.endsWith("<"))
		{
			key = key.substring(0,key.length()-1);
			mode = MODE_APPEND;
		}
		else if(key.endsWith("|"))
		{
			key = key.substring(0,key.length()-1);
			mode = MODE_CHANGE;
		}
		
		Object value = evalAsObject.t(new Object[]{context,exp});
		return new Object[]{key,value,mode};
	}
}
