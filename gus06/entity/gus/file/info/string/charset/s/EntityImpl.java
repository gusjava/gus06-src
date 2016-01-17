package gus06.entity.gus.file.info.string.charset.s;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151002";}
	
	public static final String FAILED_VALUE = "###";


	private Service t;


	public EntityImpl() throws Exception
	{t = Outside.service(this,"gus.file.info.string.charset");}
	
	
	public Object t(Object obj) throws Exception
	{return call(obj);}
	
	
	
	private Object call(Object obj)
	{
		try{return t.t(obj);}
		catch(Exception e)
		{return FAILED_VALUE;}
	}
}
