package gus06.entity.gus.sys.filemapper1.holder;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, T, R, V, F {

	public String creationDate() {return "20160212";}
	

	private Service mapping;
	private Service fileToId;
	private Service idToFile;
	
	private File root;
	private Map map;
	private String main;


	public EntityImpl() throws Exception
	{
		mapping = Outside.service(this,"gus.sys.filemapper1.mapping");
		fileToId = Outside.service(this,"gus.sys.filemapper1.filetoid");
		idToFile = Outside.service(this,"gus.sys.filemapper1.idtofile");
	}
	
	
	public Object r(String key) throws Exception
	{
		if(key.equals("root")) return root;
		if(key.equals("map")) return map;
		if(key.equals("main")) return main;
		
		if(key.equals("keys")) return new String[]{"root","map","main"};
		
		throw new Exception("Unknown key: " + key);
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("root"))		{root = (File) obj;return;}
		if(key.equals("map"))		{map = (Map) obj;return;}
		if(key.equals("main"))		{main = (String) obj;return;}
		
		throw new Exception("Unknown key: " + key);
	}

	
	
	
	public boolean f(Object obj) throws Exception
	{
		File file = (File) obj;
		String id = fileToId(file);
		return id!=null;
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj instanceof File) return fileToId((File) obj);
		if(obj instanceof String) return idToFile((String) obj);
		
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		String key = (String) o[1];
		
		String id = fileToId(file);
		String id1 = mapping(id,key);
		return idToFile(id1);
	}
	
	
	
	private String mapping(String id, String key) throws Exception
	{return (String) mapping.t(new Object[]{map,id,key});}
	
	
	private String fileToId(File file) throws Exception
	{return (String) fileToId.t(new Object[]{root,main,file});}
	
	
	private File idToFile(String id) throws Exception
	{return (File) idToFile.t(new Object[]{root,main,id});}
}
