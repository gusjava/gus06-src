package gus06.entity.gus.file.runtask.properties.pbe1.decrypt;

import gus06.framework.*;
import java.io.File;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150626";}


	private Service decrypt;

	public EntityImpl() throws Exception
	{
		decrypt = Outside.service(this,"gus.crypto.pbe1.file.prop.decrypt");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		if(progress!=null) ((V)progress).v("size","1");
		decrypt.p(file);
		if(progress!=null) ((E)progress).e();
	}
}