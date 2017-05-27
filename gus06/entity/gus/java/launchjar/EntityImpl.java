package gus06.entity.gus.java.launchjar;

import java.io.File;
import java.io.PrintStream;
import java.util.*;

import gus06.framework.*;


public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20140705";}

	
	private Service findExe;
	private PrintStream out;

	
	public EntityImpl() throws Exception
	{
		findExe = Outside.service(this,"gus.java.dir.bin.javaexe");
		out = (PrintStream) Outside.resource(this,"sysout");
	}
	
	
	public void p(Object obj) throws Exception
	{t(obj);}
	
	
	
	public Object t(Object obj) throws Exception
	{
		List<String> cmd = new ArrayList<>();
		
		File javaExe = (File) findExe.g();
		cmd.add(javaExe.getAbsolutePath());
		
		handleData(cmd,obj);
		
		ProcessBuilder pb = new ProcessBuilder(cmd);
		pb.redirectErrorStream(true);
		return pb.start();
	}
	
	
	
	
	private void handleData(List<String> list, Object obj) throws Exception
	{
		if(obj instanceof Object[])
		{
			Object[] o = (Object[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
			
			File jar = toFile(o[0]);
			String[] args = toStringArray(o[1]);
			
			list.add("-jar");
			list.add(jar.getAbsolutePath());
			for(String arg:args) list.add(arg);
			return;
		}
		if(obj instanceof String[])
		{
			String[] o = (String[]) obj;
			if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
			
			File jar = toFile(o[0]);
			String[] args = toStringArray(o[1]);
			
			list.add("-jar");
			list.add(jar.getAbsolutePath());
			for(String arg:args) list.add(arg);
			return;
		}
		if(obj instanceof File)
		{
			File jar = toFile(obj);
			
			list.add("-jar");
			list.add(jar.getAbsolutePath());
			return;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	
	private File toFile(Object obj) throws Exception
	{
		if(obj instanceof File) return (File) obj;
		if(obj instanceof String) return new File((String) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private String[] toStringArray(Object obj) throws Exception
	{
		if(obj instanceof String[]) return (String[]) obj;
		if(obj instanceof String) return ((String) obj).split(" ");
		if(obj instanceof List) return toStringArray((List) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public String[] toStringArray(List l) throws Exception
	{
		int number = l.size();
		String[] yy = new String[number];
		for(int i=0;i<number;i++) yy[i] = ""+l.get(i);
		return yy;
	}
}
