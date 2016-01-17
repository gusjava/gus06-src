package gus06.entity.gus.sys.parser3.prepare.step1;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151026";}
	
	public static final String TYPE = "type";
	public static final String VALUE = "value";
	
	public static final String TYPE_INT = "int";
	public static final String TYPE_ELEMENT = "element";
	public static final String TYPE_SYMBOL = "symbol";
	public static final String TYPE_OTHER = "other";
	
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
			
		List list = new ArrayList();
		boolean isEscape = false;
			
		StringBuffer b = new StringBuffer();
			
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(isLetter(c) || isDigit(c) || c=='_')
			{
				b.append(c);
			}
			else if(isSymbol(c))
			{
				addElement(list,b);
				addSymbol(list,c);
			}
			else
			{
				addElement(list,b);
				addOther(list,c);
			}
		}
		
		addElement(list,b);
		return list;
	}
	
	
	
	private void addElement(List list, StringBuffer b)
	{
		if(b.length()==0) return;
		
		String value = b.toString();
		b.delete(0,b.length());
		
		Integer n = toInt(value);
		if(n!=null) add(list,TYPE_INT,n);
		else add(list,TYPE_ELEMENT,value);
	}
	
	
	
	private void addSymbol(List list, char c)
	{add(list,TYPE_SYMBOL,""+c);}
	
	
	
	private void addOther(List list, char c)
	{
		if(list.isEmpty())
		{addOther2(list,c);return;}
		
		Map m = (Map) list.get(list.size()-1);
		if(!m.get(TYPE).equals(TYPE_OTHER))
		{addOther2(list,c);return;}
		
		String previous = (String) m.get(VALUE);
		m.put(VALUE,previous+c);
	}
	
	
	private void addOther2(List list, char c)
	{add(list,TYPE_OTHER,""+c);}
	
	
	
	
	private void add(List list, String type, Object value)
	{
		Map m = new HashMap();
		m.put(TYPE,type);
		m.put(VALUE,value);
		list.add(m);
	}
	
	
	
	private boolean isSymbol(char c)
	{
		return c=='.' || c==',' || c==';' || c=='?' || c=='!' || c==':' || 
			c=='*' || c=='+' || c=='-' || c=='%' || c=='°' || c=='^' || 
			c=='\\' || c=='/' || c=='|' || c=='<' || c=='>' || c=='¨' || 
			c=='(' || c==')' || c=='[' || c==']' || c=='{' || c=='}' || 
			c=='@' || c=='#' || c=='&' || c=='\"' || c=='\'' || c=='~' || 
			c=='$' || c=='£' || c=='µ' || c=='§' || c=='¤' || c=='=';
	}
	
	
	private boolean isLetter(char c)
	{
		int code = (int) c;
		return (code>96 && code<123) || (code>64 && code<91);
	}
	
	
	private boolean isDigit(char c)
	{
		int code = (int) c;
		return code>47 && code<58;
	}
	
	private Integer toInt(String n)
	{
		try{return new Integer(n);}
		catch(NumberFormatException e){}
		return null;
	}
}
