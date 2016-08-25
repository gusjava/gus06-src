package gus06.entity.gus.dirfile.op.move;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150606";}


	private Service moveDir;
	private Service moveFile;


	public EntityImpl() throws Exception
	{
		moveDir = Outside.service(this,"gus.dir.op.move");
		moveFile = Outside.service(this,"gus.file.op.move");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File in = o[0];
		
		if(!in.exists()) throw new Exception("Input not found: "+in);
		
		if(in.isDirectory()) moveDir.p(obj);
		else moveFile.p(obj);
	}
}
