package gus06.entity.gus.file.perform.rename.ask.keepext;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, F, T {

	public String creationDate() {return "20150615";}


	private Service input;
	private Service format;
	private Service getExtension;


	public EntityImpl() throws Exception
	{
		input = Outside.service(this,"gus.input.text.dialog");
		format = Outside.service(this,"gus.string.transform.format.pathinput1");
		getExtension = Outside.service(this,"gus.file.getextension");
	}
	
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{return t(obj)!=null;}
	
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		
		String oldName = file.getName();
		String oldExt = (String) getExtension.t(file);
		
		String newName = (String) input.t(new String[]{"Enter new name:",oldName});
		
		if(newName==null) return null;
		if(newName.equals("")) return null;
		
		newName = format(newName);
		if(!oldExt.equals("") && !newName.contains("."))
		newName = newName+"."+oldExt;
		
		if(newName.equals(oldName)) return null;
		
		File file1 = new File(file.getParentFile(),newName);
		rename(file,file1);
		return file1;
	}
	
	
	
	
	private void rename(File file0, File file1) throws Exception
	{
		boolean r = file0.renameTo(file1);
		if(!r) throw new Exception("Failed to rename file: "+file0+" to file "+file1);
	}
	
	
	
	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
