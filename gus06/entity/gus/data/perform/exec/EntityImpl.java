package gus06.entity.gus.data.perform.exec;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T, P {

	public String creationDate() {return "20151114";}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof String) return process((String) obj);
		if(obj instanceof File) return process((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private Process process(File f) throws Exception
	{return Runtime.getRuntime().exec(p(f));}
	
	private Process process(String cmd) throws Exception
	{return Runtime.getRuntime().exec(cmd);}
	
	
	private String p(File f)
	{return "\""+f.getAbsolutePath()+"\"";}
}
