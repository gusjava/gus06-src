package gus06.entity.gus.data.string.subsequence0;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151119";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String input = (String) o[0];
		String rule = (String) o[1];
		
		return sub(input,rule);
	}
	
	
	private String sub(String input, String rule) throws Exception
	{
		StringBuffer b = new StringBuffer();
		
		String[] nn = rule.split(";");
		for(String n:nn) b.append(sub1(input,n));
		
		return b.toString();
	}
	
	private String sub1(String input, String rule) throws Exception
	{
		if(rule.equals("..")) return input;
		
		int l = input.length();
		
		if(isInt(rule))
		{
			int n = toInt(rule,l);
			if(n<0 || n>=l) return "";
			return ""+input.charAt(n);
		}
		
		if(rule.startsWith("..")) rule = "0"+rule;
		if(rule.endsWith("..")) rule = rule+"-1";
		
		String[] m = rule.split("\\.\\.");
		if(m.length!=2) throw new Exception("Invalid subsequence rule: "+rule);
		
		int start = toInt(m[0],l);
		int end = toInt(m[1],l);
		
		if(start<=end) return substring(input,start,end+1);
		return substring_re(input,start,end);
	}
	
	private boolean isInt(String s)
	{
		try{Integer.parseInt(s);return true;}
		catch(NumberFormatException e){}
		return false;
	}
	
	private int toInt(String s)
	{return Integer.parseInt(s);}
	
	
	private int toInt(String s, int l)
	{
		int n = toInt(s);
		return n<0? n+l:n;
	}
	
	
	
	
	private String substring(String s, int start, int end)
	{
		int l = s.length();
		
		if(start<0) start = 0;
		if(end>=l) end = l-1;
		return s.substring(start,end+1);
	}
	
	
	private String substring_re(String s, int start, int end)
	{
		int l = s.length();
		
		StringBuffer b = new StringBuffer();
		for(int i=start;i>=end;i--) if(i>=0 && i<l) b.append(s.charAt(i));
		return b.toString();
	}
}
