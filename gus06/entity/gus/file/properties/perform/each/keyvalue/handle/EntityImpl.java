package gus06.entity.gus.file.properties.perform.each.keyvalue.handle;

import java.io.File;
import gus06.framework.*;
import java.util.Map;
import java.util.Iterator;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161115";}


	private Service readFile;
	
	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.properties");
	}


	

	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		P p = (P) o[1];
		
		Map prop = (Map) readFile.t(file);
		
		Iterator it = prop.keySet().iterator();
		while(it.hasNext())
		{
			String key = (String) it.next();
			String value = (String) prop.get(key);
			
			p.p(key);
			p.p(value);
		}
	}
}
