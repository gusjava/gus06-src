package gus06.entity.gus.data.holder0;

import gus06.framework.*;

public class EntityImpl extends S1 implements Entity, P, G {

	public String creationDate() {return "20161117";}
	
	private Object value;
	

	public Object g() throws Exception
	{return value;}
	
	
	public void p(Object obj) throws Exception
	{value = obj;changed();}
	
	
	private void changed()
	{send(this,"changed()");}
}
