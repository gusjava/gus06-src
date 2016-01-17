package gus06.entity.gus.convert.stringtonumber;

import gus06.framework.*;
import java.awt.Dimension;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151205";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		return toNumber((String) obj);
	}
	
	
	
	private Number toNumber(String s) throws Exception
	{
		if(isInt(s)) return new Integer(s);
		if(isLong(s)) return new Long(s);
		if(isDouble(s)) return new Double(s);
		
		throw new Exception("Could not convert string into number: "+s);
	}
	
	private boolean isInt(String s)
	{
		try{Integer.parseInt(s);return true;}
		catch(NumberFormatException e) {return false;}
	}
	
	private boolean isLong(String s)
	{
		try{Long.parseLong(s);return true;}
		catch(NumberFormatException e) {return false;}
	}
	
	private boolean isDouble(String s)
	{
		try{Double.parseDouble(s);return true;}
		catch(NumberFormatException e) {return false;}
	}
}
