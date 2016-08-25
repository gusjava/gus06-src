package gus06.entity.gus.sys.parser3.prepare.step3;

import gus06.framework.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151027";}

	public static final String TYPE = "type";
	public static final String VALUE = "value";
	
	public static final String TYPE_ELEMENT = "element";
	public static final String TYPE_SYMBOL = "symbol";
	public static final String TYPE_DOUBLE = "double";
	public static final String TYPE_INT = "int";
	
	
	
	public Object t(Object obj) throws Exception
	{
		List input = (List) obj;
		int number = input.size();
		
		for(int i=0;i<number;i++)
		{
			Map m = (Map) input.get(i);
			if(!isElement(m)) continue;
			
			Object value = value(m);
			Integer n = toInt(value);
			if(n!=null)
			{
				m.put(TYPE,TYPE_INT);
				m.put(VALUE,n);
			}
		}
		
		List output = new ArrayList();
		List buff = new ArrayList();
		
		for(int i=0;i<number;i++)
		{
			Map m = (Map) input.get(i);
			if(isPoint(m) || isInt(m))
			{buff.add(m);continue;}
			
			handleBuff(buff,output);
			output.add(m);
		}
		
		handleBuff(buff,output);
		return output;
	}
	
	
	
	
	private void handleBuff(List buff, List output)
	{
		if(buff.isEmpty()) return;
		
		if(buff.size()==3)
		{
			Map m1 = (Map) buff.get(0);
			Map m2 = (Map) buff.get(1);
			Map m3 = (Map) buff.get(2);
			
			if(isInt(m1) && isPoint(m2) && isInt(m3))
			{
				addDouble(m1,m3,output);
				buff.clear();
				return;
			}
		}
		
		output.addAll(buff);
		buff.clear();
	}
	
	
	
	private void addDouble(Map m1, Map m2, List output)
	{
		Integer n1 = (Integer) m1.get(VALUE);
		Integer n2 = (Integer) m2.get(VALUE);
		Double d = new Double(n1+"."+n2);
		
		Map m = new HashMap();
		m.put(TYPE,TYPE_DOUBLE);
		m.put(VALUE,d);
		
		output.add(m);
	}
	
	
	
	private Object value(Map m)
	{return m.get(VALUE);}
	
	private String type(Map m)
	{return (String) m.get(TYPE);}
	
	private boolean hasValue(Map m, Object value)
	{return value(m).equals(value);}
	
	private boolean hasType(Map m, String type)
	{return type(m).equals(type);}
	
	private boolean isElement(Map m)
	{return hasType(m,TYPE_ELEMENT);}
	
	private boolean isInt(Map m)
	{return hasType(m,TYPE_INT);}
	
	private boolean isPoint(Map m)
	{return hasType(m,TYPE_SYMBOL) && hasValue(m,".");}
	
	
	
	
	private Integer toInt(Object n)
	{
		try{return new Integer(""+n);}
		catch(NumberFormatException e){}
		return null;
	}
}
