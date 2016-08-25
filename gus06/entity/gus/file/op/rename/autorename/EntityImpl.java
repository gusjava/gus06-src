package gus06.entity.gus.file.op.rename.autorename;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160612";}
	

	private Service autoRename;

	public EntityImpl() throws Exception
	{
		autoRename = Outside.service(this,"gus.file.newfile.autorename2");
	}
		
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File f = (File) o[0];
		String newName = (String) o[1];
		
		if(!f.isFile()) throw new Exception("Invalid input file: "+f);
		if(f.getName().equals(newName)) return;
		
		File parent = f.getParentFile();
		File f1 = new File(parent,newName);
		
		f1 = (File) autoRename.t(f1);
		
		boolean r = f.renameTo(f1);
		if(!r) throw new Exception("Failed to rename file: "+f);
	}
}
