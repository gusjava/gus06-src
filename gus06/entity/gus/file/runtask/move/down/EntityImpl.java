package gus06.entity.gus.file.runtask.move.down;

import gus06.framework.*;
import java.io.File;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150924";}


	private Service moveDown;

	public EntityImpl() throws Exception
	{
		moveDown = Outside.service(this,"gus.file.perform.movedown.ask");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		if(progress!=null) ((V)progress).v("size","1");
		moveDown.p(file);
		if(progress!=null) ((E)progress).e();
	}
}