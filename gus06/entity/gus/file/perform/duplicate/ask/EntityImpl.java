package gus06.entity.gus.file.perform.duplicate.ask;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, F, T {

	public String creationDate() {return "20140907";}


	private Service input;
	private Service format;
	private Service getExtension;
	private Service copy;


	public EntityImpl() throws Exception
	{
		input = Outside.service(this,"gus.input.text.dialog");
		format = Outside.service(this,"gus.string.transform.format.pathinput1");
		getExtension = Outside.service(this,"gus.file.getextension");
		copy = Outside.service(this,"gus.file.op.copy");
	}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{return t(obj)!=null;}
	
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		String oldExt = (String) getExtension.t(file);
		
		String oldName = file.getName();
		String newName = (String) input.t(new String[]{"Enter new name:",oldName});
		
		if(newName==null) return null;
		if(newName.equals("")) return null;
		
		newName = format(newName);
		if(!oldExt.equals("") && newName.endsWith(" "))
		newName = newName.substring(0,newName.length()-1)+"."+oldExt;
		
		if(newName.equals(oldName)) return null;
		
		File file1 = new File(file.getParentFile(),newName);
		file1.getParentFile().mkdirs();
		
		copy.p(new File[]{file,file1});
		return file1;
	}
	
	
	
	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
