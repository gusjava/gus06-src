package gus06.entity.gus.string.transform.encoding.uu.encode;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141114";}
	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		
		StringBuffer b = new StringBuffer();
		for(int i=0;i<s.length();i++)
		{
		    int x = s.codePointAt(i);
		    if(isTargetCodePoint(x))
		    {
				String hexa = Integer.toHexString(x);
				while(hexa.length()<4) hexa="0"+hexa;
				b.append("\\u"+hexa);
		    }
		    else b.append(s.charAt(i));
		}
		return b.toString();
	}
	
	
	private boolean isTargetCodePoint(int x)
	{return x<=8 || x==11 || (x>=14 && x<=31) || x==92 || x>=127;}
	
	// 92 est \
}
