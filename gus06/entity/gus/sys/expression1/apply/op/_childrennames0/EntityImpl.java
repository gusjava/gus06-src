package gus06.entity.gus.sys.expression1.apply.op._childrennames0;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service listing;
	
	public EntityImpl() throws Exception
	{listing = Outside.service(this,"gus.dir.listing0.names0");}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File)
			return listing.t((File) obj);
		if(obj instanceof String)
			return listing.t(file((String) obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private File file(String s) throws Exception
	{return new File(s).getCanonicalFile();}
}
