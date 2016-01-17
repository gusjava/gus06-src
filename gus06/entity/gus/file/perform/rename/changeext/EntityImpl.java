package gus06.entity.gus.file.perform.rename.changeext;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20150619";}


	private Service getname;
	private Service autoRename;


	public EntityImpl() throws Exception
	{
		getname = Outside.service(this,"gus.file.getname0");
		autoRename = Outside.service(this,"gus.file.newfile.autorename");
	}
	
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		String extension = (String) o[1];
		
		String name = (String) getname.t(file);
		if(extension!=null && !extension.equals("")) name = name+"."+extension;
		
		File file1 = new File(file.getParentFile(),name);
		file1 = (File) autoRename.t(file1);
		
		rename(file,file1);
		return file1;
	}
	
	
	
	
	private void rename(File file0, File file1) throws Exception
	{
		boolean r = file0.renameTo(file1);
		if(!r) throw new Exception("Failed to rename file: "+file0+" to file "+file1);
	}
}
