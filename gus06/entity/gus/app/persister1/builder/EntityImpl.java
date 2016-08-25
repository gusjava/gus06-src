package gus06.entity.gus.app.persister1.builder;

import gus06.framework.*;
import java.io.File;
import java.util.Map;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140930";}


	private Service readString;
	private Service writeString;
	
	private Service readProp;
	private Service writeProp;
	
	private Service dirToSet;


	public EntityImpl() throws Exception
	{
		readString = Outside.service(this,"gus.file.read.string");
		writeString = Outside.service(this,"gus.file.write.string");
		
		readProp = Outside.service(this,"gus.file.read.properties");
		writeProp = Outside.service(this,"gus.file.write.properties");
		
		dirToSet = Outside.service(this,"gus.dir.children.dirtoset.name0");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{return new Holder((File) obj);}
	
	
	
	
	private class Holder implements R, V, F, G
	{
		private File dir;
		
		public Holder(File dir)
		{
			this.dir = dir;
			dir.mkdirs();
		}
		
		
		public Object r(String key) throws Exception
		{
			File f1 = fileProp(key);
			if(f1.isFile()) return readProp.t(f1);
			
			File f2 = fileTxt(key);
			if(f2.isFile()) return readString.t(f2);
			
			return null;
		}
		
		
		public void v(String key, Object obj) throws Exception
		{
			if(obj==null)
			{
				delete(fileProp(key));
				delete(fileTxt(key));
			}
			else if(obj instanceof String)
			{
				if(!dir.exists()) dir.mkdirs();
				writeString.p(new Object[]{fileTxt(key),obj});
				delete(fileProp(key));
			}
			else if(obj instanceof Map)
			{
				if(!dir.exists()) dir.mkdirs();
				writeProp.p(new Object[]{fileProp(key),obj});
				delete(fileTxt(key));
			}
			else throw new Exception("Invalid data type: "+obj.getClass().getName());
		}
		
		
		public boolean f(Object obj) throws Exception
		{
			if(fileProp((String) obj).isFile()) return true;
			if(fileTxt((String) obj).isFile()) return true;
			
			return false;
		}
		
		
		public Object g() throws Exception
		{
			return dirToSet.t(dir);
		}
	
	
		private File fileTxt(String key)
		{return new File(dir,key+".txt");}
	
		private File fileProp(String key)
		{return new File(dir,key+".properties");}
	}
	
	
	
	
	private void delete(File f) throws Exception
	{
		if(!f.exists()) return;
		boolean r = f.delete();
		if(!r) throw new Exception("Failed to delete file: "+f);
	}
}
