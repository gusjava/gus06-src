package gus06.entity.gus.sys.webserver1.web2.zdyn.e.format.formatter2;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141002";}

	public static final int MAXLOOP = 30;

	private Service compute;
	
	
	private Pattern p;


	public EntityImpl() throws Exception
	{
		compute = Outside.service(this,"gus.sys.webserver1.web2.zdyn.e.format.formatter2.compute");
		p = Pattern.compile("\\{[^\\{\\}:]+:[^\\{\\}]+\\}");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		R mr = (R) o[0];
		String text = (String) o[1];
		Map args = (Map) o[2];
		Map vars = (Map) o[3];
		
		for(int i=0;i<MAXLOOP;i++)
		{
			Matcher m = p.matcher(text);
			if(!m.find()) break;
		
			String group = m.group();
			int start = m.start();
			int end = m.end();
		
			String repl = compute(mr,group,args,vars);
			text = text.substring(0,start)+repl+text.substring(end);
		}
		return text;
	}
	
	
	
	
	private String compute(R mr, String s, Map args, Map vars) throws Exception
	{
		s = s.substring(1,s.length()-1);
		String[] n = s.split(":",2);
		Object r = compute.t(new Object[]{mr,n[0],n[1],args,vars});
		return toString(r);
	}
	
	
	private String toString(Object obj)
	{
		if(obj==null) return "null";
		if(obj instanceof String) return (String) obj;
		return "["+obj.getClass().getSimpleName()+"]";
	}
}
