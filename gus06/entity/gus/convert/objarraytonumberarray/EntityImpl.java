package gus06.entity.gus.convert.objarraytonumberarray;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160802";}


	private Service find;

	public EntityImpl() throws Exception
	{find = Outside.service(this,"gus.find.number");}
		
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		Object[] oo = (Object[]) obj;
		int length = oo.length;
		
		Number[] nn = new Number[length];
		for(int i=0;i<length;i++) nn[i] = (Number) find.t(oo[i]);
			
		return nn;
	}
}