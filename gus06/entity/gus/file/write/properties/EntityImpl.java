package gus06.entity.gus.file.write.properties;

import gus06.framework.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140831";}


	private Service toProp;

	public EntityImpl() throws Exception
	{toProp = Outside.service(this,"gus.find.properties");}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Properties prop = toProp(o[1]);
		
		FileOutputStream fos = new FileOutputStream(file);
		prop.store(fos,"");
		fos.close();
	}
	
	
	private Properties toProp(Object obj) throws Exception
	{return (Properties) toProp.t(obj);}
}
