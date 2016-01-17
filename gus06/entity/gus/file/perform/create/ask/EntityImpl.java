package gus06.entity.gus.file.perform.create.ask;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P, F, T {

	public String creationDate() {return "20140911";}


	private Service input;
	private Service format;
	private Service contentFromClipboard;
	private Service contentFromClipboard_deleteSrc;


	public EntityImpl() throws Exception
	{
		input = Outside.service(this,"gus.input.text.dialog");
		format = Outside.service(this,"gus.string.transform.format.pathinput1");
		contentFromClipboard = Outside.service(this,"gus.file.perform.filecontent.fromclipboard");
		contentFromClipboard_deleteSrc = Outside.service(this,"gus.file.perform.filecontent.fromclipboard.deletesrc");
	}
	
	
	
	public void p(Object obj) throws Exception
	{f(obj);}
	
	
	public boolean f(Object obj) throws Exception
	{return t(obj)!=null;}
	
	
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		
		if(!file.exists())
		{
			file.createNewFile();
			return file;
		}
		
		String name = askForName(file);
		if(name==null || name.equals("")) return null;
		
		File dir = getDir(file);
		
		if(!name.contains(";"))
		return create(dir,name);
		
		String[] n = name.split(";");
		File[] f = new File[n.length];
		for(int i=0;i<f.length;i++) f[i] = create(dir,n[i]);
		
		return f;
	}
	
	
	
	private String askForName(File file) throws Exception
	{
		String initValue = file.isFile()?file.getName():"";
		String message = "Please, enter file's name:";
		return (String) input.t(new String[]{message,initValue});
	}
	
	private File getDir(File file)
	{
		if(file.isDirectory()) return file;
		return file.getParentFile();
	}
	
	
	
	private File create(File dir, String name) throws Exception
	{
		boolean copy = name.endsWith("*");
		if(copy) name = name.substring(0,name.length()-1);
		
		boolean move = name.endsWith("*");
		if(move) name = name.substring(0,name.length()-1);
		
		File file = new File(dir,format(name));
		file.getParentFile().mkdirs();
		file.createNewFile();
		
		if(move) contentFromClipboard_deleteSrc.p(file);
		else if(copy) contentFromClipboard.p(file);
		
		return file;
	}
	
	
	
	private String format(String s) throws Exception
	{return (String) format.t(s);}
}
