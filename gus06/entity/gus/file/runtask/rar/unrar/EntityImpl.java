package gus06.entity.gus.file.runtask.rar.unrar;

import gus06.framework.*;
import java.io.File;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150630";}


	private Service runUnrar;
	private Service getName;

	public EntityImpl() throws Exception
	{
		runUnrar = Outside.service(this,"gus.file.rar.run.unrar");
		getName = Outside.service(this,"gus.file.getname0");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		String name = (String) getName.t(file);
		File dir = new File(file.getParentFile(),name);
		dir.mkdirs();
		
		runUnrar.p(new Object[]{file,dir,progress,interrupt});
	}
}
