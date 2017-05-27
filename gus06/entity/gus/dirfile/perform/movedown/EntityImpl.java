package gus06.entity.gus.dirfile.perform.movedown;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170225";}


	private Service moveDir;
	private Service moveFile;

	public EntityImpl() throws Exception
	{
		moveDir = Outside.service(this,"gus.dir.perform.movedown");
		moveFile = Outside.service(this,"gus.file.perform.movedown");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File in = (File) o[0];
		
		if(!in.exists()) throw new Exception("Input not found: "+in);
		
		if(in.isDirectory()) moveDir.p(obj);
		else moveFile.p(obj);
	}
}
