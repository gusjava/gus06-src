package gus06.entity.gus.sys.expression1.apply.op._read_propp;

import gus06.framework.*;
import java.io.File;
import java.util.Properties;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161208";}


	private Service readProperties;
	
	public EntityImpl() throws Exception
	{
		readProperties = Outside.service(this,"gus.file.read.properties.autosaver.strict");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof File)
			return readProperties.t(obj);
		if(obj instanceof File[])
			return readProperties((File[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Properties[] readProperties(File[] ff) throws Exception
	{
		Properties[] pp = new Properties[ff.length];
		for(int i=0;i<ff.length;i++)
		pp[i] = (Properties) readProperties.t(ff[i]);
		return pp;
	}
}
