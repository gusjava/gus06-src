package gus06.entity.gus.dirfile.op.copy.autorename;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150606";}


	private Service copyDir;
	private Service copyFile;

	public EntityImpl() throws Exception
	{
		copyDir = Outside.service(this,"gus.dir.op.copy.autorename");
		copyFile = Outside.service(this,"gus.file.op.copy.autorename");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File in = o[0];
		File out = o[1];
		
		if(!in.exists()) throw new Exception("Input not found: "+in);
		
		if(in.isDirectory()) copyDir.p(obj);
		else copyFile.p(obj);
	}
}
