package gus06.entity.gus.sys.expression1.apply.op._mimehier;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151111";}


	private Service buildMimeHier;
	
	public EntityImpl() throws Exception
	{
		buildMimeHier = Outside.service(this,"gus.file.mime.tika.hierarchy.list");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File)
		{
			File file = (File) obj;
			return file.isFile()?buildMimeHier.t(file):null;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
