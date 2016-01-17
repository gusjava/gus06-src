package gus06.entity.gus.find.properties;

import gus06.framework.*;
import java.util.Properties;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140831";}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof Properties) return obj;
		if(obj instanceof Map) return mapToProp((Map) obj);
		if(obj instanceof File) return readProp((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Properties mapToProp(Map map)
	{
		Properties prop = new Properties();
		prop.putAll(map);
		return prop;
	}
	
	
	
	private Properties readProp(File file) throws Exception
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		fis.close();
		return prop;
	}
}
