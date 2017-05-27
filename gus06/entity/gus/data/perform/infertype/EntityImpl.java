package gus06.entity.gus.data.perform.infertype;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170129";}

	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Number) return inferFromString(""+obj);
		if(obj instanceof String) return inferFromString(""+obj);
		return obj;
	}
	
	private Object inferFromString(String s) throws Exception
	{
		s = s.toLowerCase();
		if(s.equals("true")) return Boolean.TRUE;
		if(s.equals("false")) return Boolean.FALSE;
		
		try{return new Integer(s);}
		catch(NumberFormatException e){}
		
		try{return new Long(s);}
		catch(NumberFormatException e){}
		
		try{return new Double(s);}
		catch(NumberFormatException e){}
		
		return s;
	}
}
