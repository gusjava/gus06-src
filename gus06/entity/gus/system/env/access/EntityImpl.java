package gus06.entity.gus.system.env.access;

import gus06.framework.*;

public class EntityImpl implements Entity, R, V, G {

	public String creationDate() {return "20151111";}
	
	
	public Object g() throws Exception
	{return System.getenv();}
	
	
	public Object r(String key) throws Exception
	{return System.getenv(key);}
	
	
	public void v(String key, Object obj) throws Exception
	{
		throw new UnsupportedOperationException();
	}
}