package gus06.entity.gus.file.runtask.gusscript.buildjar;

import gus06.framework.*;
import java.io.File;
import java.util.Set;
import java.util.Properties;
import java.util.ArrayList;
import java.io.PrintStream;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161014";}


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.file.perform.generate.jar.from.gusscript");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		File file1 = new File(file.getAbsolutePath()+".jar");
		
		if(progress!=null) ((V)progress).v("size","1");
		perform.p(new File[]{file,file1});
		if(progress!=null) ((E)progress).e();
	}
}
