package gus06.entity.gus.web.allocine.api.search.cache;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, R, V {

	public String creationDate() {return "20141010";}

	private Service builder;
	private Object holder;


	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.app.persister1.builder");
		File dir = (File) Outside.resource(this,"defaultdir");
		holder = builder.t(dir);
	}
	
	
	public Object r(String key) throws Exception
	{return ((R) holder).r(formatKey(key));}
	
	
	public void v(String key, Object obj) throws Exception
	{((V) holder).v(formatKey(key),obj);}
	
	
	
	private String formatKey(String key)
	{return key.replace("|","@");}
}
