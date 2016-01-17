package gus06.entity.gus.dir.op.copy;

import java.io.File;
import java.util.List;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140910";}


	private Service fileCopy;
	private Service listing;


	public EntityImpl() throws Exception
	{
		fileCopy = Outside.service(this,"gus.file.op.copy");
		listing = Outside.service(this,"gus.dir.listing.dirtopaths");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File in = o[0];
		File out = o[1];
		
		if(!in.isDirectory()) throw new Exception("Invalid input directory: "+in);
		if(out.isFile()) throw new Exception("Output is already a file: "+out);
		
		
		out.mkdirs();
		int length = in.getAbsolutePath().length();
		List files = (List) listing.t(in);
		
		for(Object f:files)
		{
			File f0 = (File) f;
			String part = f0.getAbsolutePath().substring(length);
			File f1 = new File(out,part);
            
			if(f0.isFile()) copy(f0,f1);
			else f1.mkdirs();
		}
	}
	
	
	
	
	private void copy(File f0, File f1) throws Exception
	{fileCopy.p(new File[]{f0,f1});}
}
