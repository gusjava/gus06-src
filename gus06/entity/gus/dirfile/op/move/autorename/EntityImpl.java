package gus06.entity.gus.dirfile.op.move.autorename;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150606";}


	private Service moveDir;
	private Service moveFile;
	private Service autoRename;


	public EntityImpl() throws Exception
	{
		moveDir = Outside.service(this,"gus.dir.op.move");
		moveFile = Outside.service(this,"gus.file.op.move");
		autoRename = Outside.service(this,"gus.file.newfile.autorename");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File in = o[0];
		File out = o[1];
		
		if(!in.exists()) throw new Exception("Input not found: "+in);
		
		out = (File) autoRename.t(out);
		File[] data = new File[]{in,out};
		
		if(in.isDirectory()) moveDir.p(data);
		else moveFile.p(data);
	}
}
