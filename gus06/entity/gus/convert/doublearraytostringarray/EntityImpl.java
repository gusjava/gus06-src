package gus06.entity.gus.convert.doublearraytostringarray;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160625";}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		double[] oo = (double[]) obj;
		int number = oo.length;
		
		String[] yy = new String[number];
		for(int i=0;i<number;i++) yy[i] = ""+oo[i];
		return yy;
	}
}
