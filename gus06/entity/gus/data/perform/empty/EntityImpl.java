package gus06.entity.gus.data.perform.empty;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141026";}


	private Service emptyDir;


	public EntityImpl() throws Exception
	{
		emptyDir = Outside.service(this,"gus.dir.op.empty");
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof StringBuffer)
		{empty((StringBuffer) obj);return;}
		
		if(obj instanceof Collection)
		{empty((Collection) obj);return;}
		
		if(obj instanceof Map) 
		{empty((Map) obj);return;}
		
		if(obj instanceof File)
		{empty((File) obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private void empty(StringBuffer b)
	{b.setLength(0);}
	
	private void empty(Collection c)
	{c.clear();}
	
	private void empty(Map m)
	{m.clear();}
	
	private void empty(File f) throws Exception
	{
		if(f.isFile()) f.createNewFile();
		else if(f.isDirectory()) emptyDir.p(f);
	}
}
