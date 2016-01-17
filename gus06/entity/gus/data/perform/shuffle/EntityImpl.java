package gus06.entity.gus.data.perform.shuffle;

import gus06.framework.*;
import java.util.List;
import java.util.Collections;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151124";}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof StringBuffer)
		{shuffle((StringBuffer) obj);return;}
		
		if(obj instanceof List)
		{shuffle((List) obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private void shuffle(List l)
	{Collections.shuffle(l);}
	
	
	private void shuffle(StringBuffer b)
	{
		StringBuffer b1 = new StringBuffer();
		while(b.length()>0)
		{
			int n = (int) (Math.random()*b.length());
			b1.append(b.charAt(n));
			b.deleteCharAt(n);
		}
		b.append(b1.toString());
	}
}
