package gus06.entity.gus.dir.runtask.classify.bymime;

import gus06.framework.*;
import java.io.File;
import java.util.Set;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150812";}


	private Service listing;
	private Service getMime;
	private Service moveFile;
	
	public EntityImpl() throws Exception
	{
		listing = Outside.service(this,"gus.dir.listing.dirtofiles");
		getMime = Outside.service(this,"gus.file.mime.tika.detect.asstring");
		moveFile = Outside.service(this,"gus.file.op.move.autorename");
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
		
		for(int i=0;i<l.size();i++)
		{
			File f = (File) l.get(i);
			String mime = (String) getMime.t(f);
			mime = mime.replace("/",File.separator);
			
			File d = new File(dir,mime);
			File f1 = new File(d,f.getName());
			
			moveFile.p(new File[]{f,f1});
			
			if(progress!=null) ((E)progress).e();
			if(interrupt!=null && !interrupt.isEmpty()) break;
		}
	}
}
