package gus06.entity.gus.data.list.subsequence;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151117";}


	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List input = (List) o[0];
		String rule = (String) o[1];
		
		return sub(input,rule);
	}
	
	
	private List sub(List input, String rule) throws Exception
	{
		List output = new ArrayList();
		String[] nn = rule.split(";");
		for(String n:nn) handle(output,input,n);
		return output;
	}
	
	
	private void handle(List output, List input, String rule) throws Exception
	{
		if(rule.equals("")) return;
		
		if(rule.equals(".."))
		{
			output.addAll(input);
			return;
		}
		
		int l = input.size();
		
		if(isInt(rule))
		{
			int n = toInt(rule,l);
			if(n<0 || n>=l) throw new Exception("Invalid subsequence rule: "+rule);
			output.add(input.get(n));
			return;
		}
		
		if(rule.startsWith("..")) rule = "0"+rule;
		if(rule.endsWith("..")) rule = rule+"-1";
		
		String[] m = rule.split("\\.\\.");
		if(m.length!=2) throw new Exception("Invalid subsequence rule: "+rule);
		
		int start = toInt(m[0],l);
		if(start<0 || start>=l) throw new Exception("Invalid subsequence rule: "+rule);
		
		int end = toInt(m[1],l);
		if(end<0 || end>=l) throw new Exception("Invalid subsequence rule: "+rule);
		
		if(start<=end)
		{
			for(int i=start;i<=end;i++)
			output.add(input.get(i));
		}
		else
		{
			for(int i=start;i>=end;i--)
			output.add(input.get(i));
		}
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
}
