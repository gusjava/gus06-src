package gus06.entity.gus.file.runtask.string.filesdico2.topropcorpus;

import gus06.framework.*;
import java.io.File;
import java.util.Set;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150919";}


	private Service lineToProp;
	private Service lineReader;
	private Service writeProp;

	public EntityImpl() throws Exception
	{
		lineToProp = Outside.service(this,"gus.sys.filesdico2.linetoprop");
		lineReader = Outside.service(this,"gus.file.string.reader.handlelines");
		writeProp = Outside.service(this,"gus.dir.access.write.properties.randomid");
	}


	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		File dir = new File(file.getAbsolutePath()+"_propcorpus");
		P handler = new Handler(dir);
		
		lineReader.p(new Object[]{file,handler,progress,interrupt});
	}
	
	
	private class Handler implements P
	{
		private File dir;
		public Handler(File dir) {this.dir = dir;}
		
		public void p(Object obj) throws Exception
		{
			String line = (String) obj;
			Map prop = (Map) lineToProp.t(line);
			writeProp.p(new Object[]{dir,prop});
		}
	}
}
