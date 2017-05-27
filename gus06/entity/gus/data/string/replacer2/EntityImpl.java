package gus06.entity.gus.data.string.replacer2;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

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
		
		while(m.find())
		{
			List list = buildGroupList(m);
			String g1 = toString(t.t(list));
			m.appendReplacement(b,g1);
		}
		m.appendTail(b);
		return b.toString();
	}
	
	
	
	private List buildGroupList(Matcher m)
	{
		List list = new ArrayList();
		for(int i=0;i<=m.groupCount();i++)
		list.add(m.group(i));
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
