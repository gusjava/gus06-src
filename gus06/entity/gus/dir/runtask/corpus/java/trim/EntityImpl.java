package gus06.entity.gus.dir.runtask.corpus.java.trim;

import gus06.framework.*;
import java.io.File;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150817";}


	private Service listing;
	private Service trimFile;
	
	public EntityImpl() throws Exception
	{
		listing = Outside.service(this,"gus.dir.listing0.ext.java");
		trimFile = Outside.service(this,"gus.file.string.perform.trim");
	}

	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		File[] ff = (File[]) listing.t(dir);
		
		int size = ff.length*2;
		if(progress!=null) ((V)progress).v("size",""+size);
		
		for(File f:ff)
		{
			trimFile.p(f);
			if(progress!=null) ((E)progress).e();
			if(interrupt!=null && !interrupt.isEmpty()) break;
		}
	}
}
