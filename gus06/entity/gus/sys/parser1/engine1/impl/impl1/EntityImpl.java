package gus06.entity.gus.sys.parser1.engine1.impl.impl1;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151023";}
	
	private Service engine1;
	private Service defaultParser;
	
	private Map map;


	public EntityImpl() throws Exception
	{
		engine1 = Outside.service(this,"gus.sys.parser1.engine1");
		defaultParser = Outside.service(this,"gus.sys.parser1.engine1.impl.brackets.curly");
		
		map = new HashMap();
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		if(!s.startsWith("@")) return defaultParser.t(s);
		
		int n = s.indexOf("\n");
		
		if(n==-1) return defaultParser.t(s);
		
		if(n==1) return defaultParser.t(s.substring(2));
		
		if(n==2)
		{
			char c = s.charAt(1);
			return getParser(""+c+c).t(s.substring(3));
		}
		
		if(n==3)
		{
			char c1 = s.charAt(1);
			char c2 = s.charAt(2);
			return getParser(""+c1+c2).t(s.substring(4));
		}
		
		if(n==4)
		{
			char e = s.charAt(1);
			char c1 = s.charAt(2);
			char c2 = s.charAt(3);
			return getParser(""+e+c1+c2).t(s.substring(5));
		}
		return defaultParser.t(s);
	}
	
	
	
	private T getParser(String info) throws Exception
	{
		if(!map.containsKey(info))
			map.put(info,buildParser(info));
		return (T) map.get(info);
	}
	
	private T buildParser(String info) throws Exception
	{return (T) engine1.t(info);}
}
