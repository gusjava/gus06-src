package gus06.entity.gus.convert.objarraytointarray;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160626";}


	private Service find;

	public EntityImpl() throws Exception
	{find = Outside.service(this,"gus.find.integer");}
		
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int length = oo.length;
		
		int[] yy = new int[length];
		for(int i=0;i<length;i++) yy[i] = ((Integer) find.t(oo[i])).intValue();
			
		return yy;
	}
}