package gus06.entity.gus.dir.perform.linkfile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150607";}


	private Service autoRename;
	private Service createLnk;


	public EntityImpl() throws Exception
	{
		autoRename = Outside.service(this,"gus.file.newfile.autorename");
		createLnk = Outside.service(this,"gus.file.lnk.create.shortcut1");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = o[0];
		File dir = o[1];
		
		File file1 = new File(dir,file.getName()+".lnk");
		file1 = (File) autoRename.t(file1);
		
		createLnk.p(new File[]{file,file1});
	}
}
