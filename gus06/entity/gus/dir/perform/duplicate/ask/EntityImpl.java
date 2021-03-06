package gus06.entity.gus.dir.perform.duplicate.ask;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, T, F {

	public String creationDate() {return "20140910";}


	private Service input;
	private Service format;
	private Service copy;


	public EntityImpl() throws Exception
	{
		input = Outside.service(this,"gus.input.text.dialog");
		format = Outside.service(this,"gus.string.transform.format.pathinput1");
		copy = Outside.service(this,"gus.dir.op.copy");
	}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{return t(obj)!=null;}
	
	
	
	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
		
		String oldName = dir.getName();
		String newName = (String) input.t(new String[]{"Enter new name:",oldName});
		
		if(newName==null) return null;
		if(newName.equals("")) return null;
		if(newName.equals(oldName)) return null;
		
		File dir1 = new File(dir.getParentFile(),format(newName));
		if(dir1.exists()) throw new Exception("Target path already exists: "+dir1);
		
		copy.p(new File[]{dir,dir1});
		return dir1;
	}
	
	
	
	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
