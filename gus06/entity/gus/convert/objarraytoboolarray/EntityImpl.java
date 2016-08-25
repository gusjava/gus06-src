package gus06.entity.gus.convert.objarraytoboolarray;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160626";}



	private Service find;

	public EntityImpl() throws Exception
	{find = Outside.service(this,"gus.find.boolean1");}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int length = oo.length;
		
		boolean[] yy = new boolean[length];
		for(int i=0;i<length;i++) yy[i] = find(oo[i]);
		
		return yy;
	}
	
	
	private boolean find(Object obj) throws Exception
	{return find.f(obj);}
}
