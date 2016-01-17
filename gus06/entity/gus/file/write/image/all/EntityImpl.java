package gus06.entity.gus.file.write.image.all;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150929";}

	
	private Service findWriter;
	
	public EntityImpl() throws Exception
	{
		findWriter = Outside.service(this,"gus.file.write.image.all.findwriter");
	}
	

	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);

		File file = (File) o[0];
		P writer = (P) findWriter.t(file);
		
		writer.p(obj);
	}
}
