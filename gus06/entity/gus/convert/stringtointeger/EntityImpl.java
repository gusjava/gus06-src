package gus06.entity.gus.convert.stringtointeger;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160626";}

	
	public static final String[] NB = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine","ten",
		"eleven","thelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};


	
	public Object t(Object obj) throws Exception
	{
		return new Integer(stringToInt((String) obj));
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
}
