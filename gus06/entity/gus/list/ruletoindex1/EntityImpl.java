package gus06.entity.gus.list.ruletoindex1;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160714";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		String rule = (String) o[1];
		
		int index = findIndex(list,rule);
		return index==-1 ? null : new Integer(index);
	}
	
	
	
	private int findIndex(List list, String rule)
	{
		int n = list.size();
		if(n==0) return -1;
		
		if(rule.startsWith("(") && rule.endsWith(")"))
			rule = rule.substring(1,rule.length()-1);
		
		if(rule.startsWith("[") && rule.endsWith("]"))
			rule = rule.substring(1,rule.length()-1);
		
		if(rule.equals("first")) return 0;
		if(rule.equals("last")) return n-1;
		if(rule.equals("random")) return random(n);
		
		int index = findIndex2(rule);
		while(index<0) index += n;
		
		return index;
	}
	
	
	
	private int findIndex2(String rule)
	{
		rule = rule.trim();
		if(rule.startsWith("m"))
		{
			int n = Integer.parseInt(rule.substring(1));
			return -1*Math.abs(n);
		}
		return Integer.parseInt(rule);
	}
	
	
	private int random(int n)
	{return (int) (Math.random()*n);}
}
