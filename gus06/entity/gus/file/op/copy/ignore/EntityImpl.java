package gus06.entity.gus.file.op.copy.ignore;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150626";}


	private Service copy;

	public EntityImpl() throws Exception
	{
		copy = Outside.service(this,"gus.file.op.copy");
	}


	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File in = o[0];
		File out = o[1];
		
		if(!in.isFile()) throw new Exception("Invalid input file: "+in);
		if(out.exists()) return;
		
		copy.p(new File[]{in,out});
	}
}