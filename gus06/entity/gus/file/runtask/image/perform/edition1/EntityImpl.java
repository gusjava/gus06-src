package gus06.entity.gus.file.runtask.image.perform.edition1;

import gus06.framework.*;
import java.io.File;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151005";}


	private Service op;

	public EntityImpl() throws Exception
	{
		op = Outside.service(this,"gus.file.image.perform.edition1");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		if(progress!=null) ((V)progress).v("size","1");
		boolean edited = op.f(file);
		
		if(!edited && interrupt!=null)
		{interrupt.add("*");return;}

		if(progress!=null) ((E)progress).e();
	}
}