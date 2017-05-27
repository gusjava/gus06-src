package gus06.entity.gus.data.string.replacer3;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161029";}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		String line = (String) o[0];
		String s1 = (String) o[1];
		T t = (T) o[2];
		
		StringBuffer b = new StringBuffer();
		
		Pattern p = Pattern.compile(s1);
		Matcher m = p.matcher(line);
		
		Map previous = null;
		List all = new ArrayList();
		int length = s1.length();
		
		while(m.find())
		{
			Map map = new HashMap();
			
			map.put("g",buildGroups(m));
			map.put("r",all);
			map.put("s",m.group());
			
			if(previous!=null) map.put("p",previous);
			
			map.put("index",new Integer(all.size()));
			map.put("start",new Integer(m.start()));
			map.put("end",new Integer(m.end()));
			map.put("length",new Integer(length));
			
			String g1 = toString(t.t(map));
			m.appendReplacement(b,g1);
			
			previous = map;
			all.add(map);
		}
		m.appendTail(b);
		return b.toString();
	}
	
	
	
	private List buildGroups(Matcher m)
	{
		List list = new ArrayList();
		for(int i=0;i<=m.groupCount();i++)
		{
			Map map = new HashMap();
			map.put("s",m.group(i));
			map.put("start",new Integer(m.start(i)));
			map.put("end",new Integer(m.end(i)));
			
			list.add(map);
		}
		return list;
	}
	
	private String toString(Object obj) throws Exception
	{
		if(obj==null) return "null";
		if(obj instanceof String) return ""+obj;
		if(obj instanceof Number) return ""+obj;
		if(obj instanceof Boolean) return ""+obj;
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
