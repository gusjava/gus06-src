package gus06.entity.gus.file.read.properties.from.txt;

import gus06.framework.*;
import java.util.Properties;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151018";}


	private Service readText;




	public EntityImpl() throws Exception
	{
		readText = Outside.service(this,"gus.file.read.string.array.autodetect");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String[] array = (String[]) readText.t(obj);
		
		Properties prop = new Properties();
		for(int i=0;i<array.length;i++)
		prop.setProperty(""+i,array[i]);
		return prop;
	}
}
