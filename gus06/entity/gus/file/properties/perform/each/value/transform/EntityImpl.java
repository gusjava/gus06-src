package gus06.entity.gus.file.properties.perform.each.value.transform;

import java.io.File;
import gus06.framework.*;
import java.util.Map;
import java.util.Properties;
import java.util.Iterator;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150926";}


	private Service readFile;
	private Service writeFile;
	
	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.properties");
		writeFile = Outside.service(this,"gus.file.write.properties");
	}


	

	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		T t = (T) o[1];
		
		Map prop = (Map) readFile.t(file);
		Properties prop1 = new Properties();
		
		Iterator it = prop.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			String value = (String) prop.get(key);
			
			String value1 = (String) t.t(value);
			
			prop1.setProperty(key,value1);
		}
		writeFile.p(new Object[]{file,prop1});
	}
}
