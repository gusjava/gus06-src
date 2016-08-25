package gus06.entity.gus.convert.longarraytoobjarray;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160626";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		long[] oo = (long[]) obj;
		int number = oo.length;
		
		Long[] yy = new Long[number];
		for(int i=0;i<number;i++) yy[i] = new Long(oo[i]);
		return yy;
	}
}
