package gus06.entity.gus.crypto.hash.sha512.hexa.s;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151014";}
	
	public static final String FAILED_VALUE = "###";


	private Service t;


	public EntityImpl() throws Exception
	{t = Outside.service(this,"gus.crypto.hash.sha512.hexa");}
	
	
	public Object t(Object obj) throws Exception
	{return call(obj);}
	
	
	
	private Object call(Object obj)
	{
		try{return t.t(obj);}
		catch(Exception e)
		{return FAILED_VALUE;}
	}
}
