package gus06.entity.gus.file.write.file;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150530";}


	private Service copy;
	
	public EntityImpl() throws Exception
	{copy = Outside.service(this,"gus.file.op.copy.replace");}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		File src = (File) o[1];
		
		copy.p(new File[]{src,file});
	}
}
