package gus06.entity.gus.file.runtask.image.perform.rotate90;

import gus06.framework.*;
import java.io.File;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150929";}


	private Service op;

	public EntityImpl() throws Exception
	{
		op = Outside.service(this,"gus.file.image.perform.rotate90");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		if(progress!=null) ((V)progress).v("size","1");
		op.p(file);
		if(progress!=null) ((E)progress).e();
	}
}