package gus06.entity.gus.file.properties.perform.field.put;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;
import gus06.framework.*;

public class EntityImpl implements Entity, P, F {

	public String creationDate() {return "20150924";}

	

	public void p(Object obj) throws Exception
	{f(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		String field = (String) o[1];
		String value = (String) o[2];
		
		Properties prop = prop(file);
		if(prop.containsKey(field) && prop.get(field).equals(value)) return false;
		
		prop.put(field,value);
		save(prop,file);
		return true;
	}

	
	
	private Properties prop(File file) throws Exception
	{
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(file);
		p.load(fis);
		fis.close();
		return p;
	}
	
	private void save(Properties p, File file) throws Exception
	{
		FileOutputStream fos = new FileOutputStream(file);
		p.store(fos,"");
		fos.close();
	}
}
