package gus06.entity.gus.file.runtask.string.perform.execute.script1;

import gus06.framework.*;
import java.io.File;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151024";}


	private Service perform;
	private Service loader1;
	
	

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.file.string.perform.execute.script1");
		loader1 = Outside.service(this,"gus.load.entities1");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		File outputFile = new File(file.getAbsolutePath()+"_output.txt");
		
		if(progress!=null) ((V)progress).v("size","1");
		perform.p(new File[]{file,outputFile});
		if(progress!=null) ((E)progress).e();
	}
}
