package gus06.entity.gus.dir.runtask.rm.doubloon;

import gus06.framework.*;
import java.io.File;
import java.util.Set;
import java.util.List;
import java.util.HashSet;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150702";}


	private Service listing;
	private Service buildMd5;
	private Service remove;
	
	public EntityImpl() throws Exception
	{
		listing = Outside.service(this,"gus.dir.listing.dirtofiles");
		buildMd5 = Outside.service(this,"gus.crypto.hash.md5.hexa");
		remove = Outside.service(this,"gus.file.op.delete");
	}

	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		List l = (List) listing.t(dir);
		if(progress!=null) ((V)progress).v("size",""+l.size());
		
		Set found = new HashSet();
		
		for(int i=0;i<l.size();i++)
		{
			File f = (File) l.get(i);
			String md5 = (String) buildMd5.t(f);
			
			if(found.contains(md5)) remove.p(f);
			else found.add(md5);
			
			if(progress!=null) ((E)progress).e();
			if(interrupt!=null && !interrupt.isEmpty()) break;
		}
	}
}
