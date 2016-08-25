package gus06.entity.gus.array.objectarray.each;

import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160816";}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object[] input = (Object[]) o[0];
		P p = (P) o[1];
		
		int nb = input.length;
		for(int i=0;i<nb;i++) p.p(input[i]);
	}
}
