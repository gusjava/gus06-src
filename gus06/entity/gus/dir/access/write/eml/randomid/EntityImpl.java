package gus06.entity.gus.dir.access.write.eml.randomid;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160609";}
	
	public static final String EXTENSION = "eml";


	private Service write;
	private Service getFile;

	public EntityImpl() throws Exception
	{
		write = Outside.service(this,"gus.file.write.mail");
		getFile = Outside.service(this,"gus.dir.access.getfile.eml.randomid");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		Object data = o[1];
		
		File f = (File) getFile.t(dir);
		write.p(new Object[]{f,data});
	}
}
