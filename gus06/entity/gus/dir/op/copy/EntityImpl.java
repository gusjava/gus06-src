package gus06.entity.gus.dir.op.copy;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140910";}


	private Service fileCopy;
	private Service handler;

	public EntityImpl() throws Exception
	{
		fileCopy = Outside.service(this,"gus.file.op.copy");
		handler = Outside.service(this,"gus.dir.op.copy.handler");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File in = o[0];
		File out = o[1];
		
		if(!in.isDirectory()) throw new Exception("Invalid input directory: "+in);
		if(out.exists()) throw new Exception("Output already exists: "+out);
		
		handler.p(new Object[]{in,out,fileCopy});
	}
}
