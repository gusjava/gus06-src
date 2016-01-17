package gus06.entity.gus.dirfile.op.moveup.autorename;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150923";}


	private Service moveOp;


	public EntityImpl() throws Exception
	{
		moveOp = Outside.service(this,"gus.dirfile.op.move.autorename");
	}

	
	public void p(Object obj) throws Exception
	{
		File in = (File) obj;
		
		File p1 = in.getParentFile();
		File p2 = p1.getParentFile();
		
		File out = new File(p2,in.getName());
		moveOp.p(new File[]{in,out});
	}
}
