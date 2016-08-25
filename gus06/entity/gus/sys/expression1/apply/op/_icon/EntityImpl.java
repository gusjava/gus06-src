package gus06.entity.gus.sys.expression1.apply.op._icon;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160209";}


	private Service readIcon;
	
	public EntityImpl() throws Exception
	{
		readIcon = Outside.service(this,"gus.file.read.icon.generic");
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
			return file.isFile()?readIcon.t(file):null;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
