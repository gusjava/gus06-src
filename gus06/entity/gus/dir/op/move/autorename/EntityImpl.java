package gus06.entity.gus.dir.op.move.autorename;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160612";}


	private Service perform;
	private Service autoRename;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.dir.op.move");
		autoRename = Outside.service(this,"gus.file.newfile.autorename2");
	}

	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File in = o[0];
		File out = (File) autoRename.t(o[1]);
		
		perform.p(new File[]{in,out});
	}
}
