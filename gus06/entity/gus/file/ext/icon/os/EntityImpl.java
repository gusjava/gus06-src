package gus06.entity.gus.file.ext.icon.os;

import java.io.File;
import java.util.Map;
import java.util.HashMap;
import javax.swing.Icon;

import gus06.framework.*;


public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20140806";}

	
	private Service fileToIcon;
	private File tmpDir;
	private Map cache;
	
	
	public EntityImpl() throws Exception
	{
		fileToIcon = Outside.service(this,"gus.file.icon.os");
		tmpDir = (File) Outside.resource(this,"defaultdir");
		tmpDir.mkdirs();
		
		cache = new HashMap();
	}
	
	
	public Object r(String key) throws Exception
	{return t(key);}
	
	
	
	
	public Object t(Object obj) throws Exception
	{
		String ext = (String) obj;
		if(!cache.containsKey(ext))
			cache.put(ext,build(ext));
		return cache.get(ext);
	}
	
	
	
	private Icon build(String ext) throws Exception
	{
		if(ext.equals("#"))
			return (Icon) fileToIcon.t(tmpDir);
	
		String fileName = ext.equals("")?"tmp":"tmp."+ext;
		File file = new File(tmpDir,fileName);
		if(!file.exists()) file.createNewFile();
		
		return (Icon) fileToIcon.t(file);
	}
}
