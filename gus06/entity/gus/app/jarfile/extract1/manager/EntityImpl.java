package gus06.entity.gus.app.jarfile.extract1.manager;

import java.io.File;

import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140906";}

	public static final String START = "gus06/manager/";
	
	
	private Service extract;
	private F filter;
	
	
	public EntityImpl() throws Exception
	{
		extract = Outside.service(this,"gus.app.jarfile.extract1");
		filter = new F() {
			public boolean f(Object obj) throws Exception
			{return isValid((String) obj);}
		};
	}
	
	
	public void e() throws Exception
	{extract.p(filter);}
	
	
	private boolean isValid(String name)
	{return name.startsWith(START);}
}
