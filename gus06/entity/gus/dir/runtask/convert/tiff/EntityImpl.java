package gus06.entity.gus.dir.runtask.convert.tiff;

import gus06.framework.*;
import java.io.File;
import java.util.Set;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151113";}
	
	public static final String EXT = "tiff";


	private Service listing;
	private Service generate;
	
	public EntityImpl() throws Exception
	{
		listing = Outside.service(this,"gus.dir.listing.dirtofiles");
		generate = Outside.service(this,"gus.file.perform.generate.tiff");
	}

	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		File dir1 = new File(dir.getAbsolutePath()+"_"+EXT);
		dir1.mkdirs();
		
		List l = (List) listing.t(dir);
		if(progress!=null) ((V)progress).v("size",""+l.size());
		
		for(int i=0;i<l.size();i++)
		{
			File f = (File) l.get(i);
			File f1 = new File(dir1,f.getName()+"."+EXT);
			
			if(!f1.exists())
			generate.p(new File[]{f,f1});
			
			if(progress!=null) ((E)progress).e();
			if(interrupt!=null && !interrupt.isEmpty()) break;
		}
	}
}
