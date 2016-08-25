package gus06.entity.gus.dir.access.write.eml.autorename;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160609";}
	
	public static final String EXTENSION = "eml";


	private Service write;
	private Service remove;
	private Service autoRename;

	public EntityImpl() throws Exception
	{
		write = Outside.service(this,"gus.file.write.mail");
		remove = Outside.service(this,"gus.file.perform.remove");
		autoRename = Outside.service(this,"gus.file.newfile.autorename2");
	}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		File dir = (File) o[0];
		String key = (String) o[1];
		Object data = o[2];
		
		File f = file(dir,key);
		f = (File) autoRename.t(f);
		
		if(data==null) remove.p(f);
		else write.p(new Object[]{f,data});
		
		return f;
	}
	
	private File file(File dir, String key)
	{
		if(!dir.exists()) dir.mkdirs();
		return new File(dir,key+"."+EXTENSION);
	}
}
