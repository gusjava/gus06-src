package gus06.entity.gus.sys.expression1.apply.op._store2_ini;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160313";}


	private Service builder;
	
	public EntityImpl() throws Exception
	{
		builder = Outside.service(this,"gus.sys.store2.build.mapaccess2.dir.ini");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File) return builder.t(new File[]{(File) obj});
		if(obj instanceof File[]) return builder.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
