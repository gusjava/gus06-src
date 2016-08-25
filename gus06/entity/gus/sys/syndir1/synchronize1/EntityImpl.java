package gus06.entity.gus.sys.syndir1.synchronize1;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160808";}


	private Service empty;
	private Service copyToDir;


	public EntityImpl() throws Exception
	{
		empty = Outside.service(this,"gus.dir.perform.empty");
		copyToDir = Outside.service(this,"gus.dir.perform.copyfile");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File dir1 = o[0];
		File dir2 = o[1];
		
		empty.p(dir2);
		
		File[] ff = dir1.listFiles();
		for(File f:ff)
		{
			copyToDir.p(new File[]{f,dir2});
		}
	}
}
