package gus06.entity.gus.app.persister1.builder;

import gus06.framework.*;
import java.io.File;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140930";}


	private Service readFile;
	private Service writeFile;
	private Service dirToSet;


	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string");
		writeFile = Outside.service(this,"gus.file.write.string");
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
		
		private File file(String key)
		{
			if(!dir.exists()) dir.mkdirs();
			return new File(dir,key+".txt");
		}
	
		public Object r(String key) throws Exception
		{return read(file(key));}
	
		public void v(String key, Object obj) throws Exception
		{write(file(key),obj);}
		
		public boolean f(Object obj) throws Exception
		{return file((String) obj).exists();}
		
		public Object g() throws Exception
		{return dirToSet.t(dir);}
	}
	
	
	
	
	
	private void write(File f, Object obj) throws Exception
	{
		if(obj==null) delete(f);
		else writeFile.p(new Object[]{f,obj});
	}
	
	private Object read(File f) throws Exception
	{
		if(!f.exists()) return null;
		return readFile.t(f);
	}
	
	private void delete(File f) throws Exception
	{
		boolean r = f.delete();
		if(!r) throw new Exception("Failed to delete file: "+f);
	}
}
