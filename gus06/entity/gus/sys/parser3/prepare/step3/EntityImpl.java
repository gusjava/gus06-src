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
	
	public static final String TYPE_INT = "int";
	public static final String TYPE_DOUBLE = "double";
	public static final String TYPE_SYMBOL = "symbol";
	
	

	public EntityImpl() throws Exception
	{
	}
	
	public Object t(Object obj) throws Exception
	{
		List input = (List) obj;
		List output = new ArrayList();
		
		List l = new ArrayList();
		int number = input.size();
		
		for(int i=0;i<number;i++)
		{
			Map m = (Map) input.get(i);
			
			if(l.size()==0)
			{
				if(isInt(m)) l.add(m);
				else
				{
					output.add(m);
				}
			}
			else if(l.size()==1)
			{
				if(isPoint(m)) l.add(m);
				else
				{
					output.addAll(l);
					output.add(m);
					l.clear();
				}
			}
			else if(l.size()==2)
			{
				if(isInt(m)) l.add(m);
				else
				{
					output.addAll(l);
					output.add(m);
					l.clear();
				}
			}
			
			if(l.size()==3)
			{
				Integer n1 = (Integer) ((Map) l.get(0)).get(VALUE);
				Integer n2 = (Integer) ((Map) l.get(2)).get(VALUE);
				Double d = buildDouble(n1,n2);
				
				Map m1 = new HashMap();
				m1.put(TYPE,TYPE_DOUBLE);
				m1.put(VALUE,d);
				
				output.add(m1);
				l.clear();
			}
		}
		
		output.addAll(l);
		return output;
	}
	
	
	
	
	private Object value(Map m)
	{return m.get(VALUE);}
	
	private String type(Map m)
	{return (String) m.get(TYPE);}
	
	private boolean hasValue(Map m, Object value)
	{return value(m).equals(value);}
	
	private boolean hasType(Map m, String type)
	{return type(m).equals(type);}
	
	
	
	
	private boolean isInt(Map m)
	{return hasType(m,TYPE_INT);}
	
	private boolean isPoint(Map m)
	{return hasType(m,TYPE_SYMBOL) && hasValue(m,".");}
	
	
	
	private Double buildDouble(Integer n1, Integer n2)
	{return new Double(n1+"."+n2);}
}
