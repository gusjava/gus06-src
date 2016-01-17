package gus06.entity.gus.find.integer;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150529";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof Integer) return obj;
		if(obj instanceof String) return new Integer(stringToInt((String)obj));
		
		if(obj instanceof Long) return new Integer(((Long)obj).intValue());
		if(obj instanceof Double) return new Integer(((Double)obj).intValue());
		if(obj instanceof Float) return new Integer(((Float)obj).intValue());
		if(obj instanceof Short) return new Integer(((Short)obj).intValue());
		
		throw new Exception("Invalid type: "+obj.getClass().getName());
	}
	
	
	private int stringToInt(String s)
	{
		try
		{
			if(s.startsWith("\\u"))
				return Integer.parseInt(s.substring(2),16);
			if(s.startsWith("0x"))
				return Integer.parseInt(s.substring(2),16);
			return Integer.parseInt(s);
		}
		catch(NumberFormatException e)
		{
			s = s.toLowerCase();
			int length = NB.length;
			for(int i=0;i<length;i++) if(NB[i].equals(s)) return i;
			
			throw e;
		}
	}

	
	
	public static final String[] NB = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine","ten",
		"eleven","thelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
}
