package gus06.entity.gus.dir.runtask.org.insert;

import gus06.framework.*;
import java.io.File;
import java.util.Set;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150620";}


	private Service autoRename;
	
	
	public EntityImpl() throws Exception
	{
		autoRename = Outside.service(this,"gus.file.newfile.autorename2");
	}


	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		Object progress = o[1];
		Set interrupt = (Set) o[2];
		
		File[] ff = dir.listFiles();
		if(progress!=null) ((V)progress).v("size",""+ff.length);
		
		File dir1 = new File(dir,"newdir");
		dir1 = (File) autoRename.t(dir1);
		dir1.mkdirs();
		
		for(File f:ff)
		{
			File f1 = new File(dir1,f.getName());
			rename(f,f1);
			
			if(progress!=null) ((E)progress).e();
			if(interrupt!=null && !interrupt.isEmpty()) break;
		}
	}
	
	
	private void rename(File f, File f1) throws Exception
	{
		boolean r = f.renameTo(f1);
		if(!r) throw new Exception("Failed to rename path: "+f+" into path: "+f1);
	}
}
