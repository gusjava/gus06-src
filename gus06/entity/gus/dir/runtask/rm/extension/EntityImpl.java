package gus06.entity.gus.dir.runtask.rm.extension;

import gus06.framework.*;
import java.io.File;
import java.util.Set;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150702";}


	private Service listing;
	private Service getInput;
	private Service remove;
	
	public EntityImpl() throws Exception
	{
		listing = Outside.service(this,"gus.dir.listing.dirtofiles");
		getInput = Outside.service(this,"gus.input.text.dialog");
		remove = Outside.service(this,"gus.file.op.delete");
	}

	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		
		String ext = (String) getInput.t("Enter target extension:");
		if(ext==null || ext.equals("")) return;
		
		List l = (List) listing.t(dir);
		if(progress!=null) ((V)progress).v("size",""+l.size());
		
		for(int i=0;i<l.size();i++)
		{
			File f = (File) l.get(i);
			if(isType(f,ext)) remove.p(f);
			
			if(progress!=null) ((E)progress).e();
			if(interrupt!=null && !interrupt.isEmpty()) break;
		}
	}
	
	
	private boolean isType(File f, String ext)
	{return f.getName().toLowerCase().endsWith("."+ext);}
}
