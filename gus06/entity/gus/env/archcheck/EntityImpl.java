package gus06.entity.gus.env.archcheck;

import java.util.Map;
import gus06.framework.*;

public class EntityImpl implements Entity, F, G {

	public String creationDate() {return "20150607";}
	
	public static final String sunArch = System.getProperty("sun.arch.data.model");
	public static final String PROPKEY_DEBUG = "debug.env.archcheck";
	
	
	private Map prop;
	
	
	public EntityImpl() throws Exception
	{
		prop = (Map) Outside.resource(this,"prop");
	}
	
	
	
	private String arch()
	{
		if(prop.containsKey(PROPKEY_DEBUG))
			return (String) prop.get(PROPKEY_DEBUG);
		return sunArch;
	}
	
	
	public Object g() throws Exception
	{return arch();}
	
	
	public boolean f(Object obj) throws Exception
	{return obj.equals(arch());}
}
