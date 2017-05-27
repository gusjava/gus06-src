package gus06.entity.gus.sys.expression1.apply.op._javafile_findclassdata;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170220";}


	private Service find;
	
	public EntityImpl() throws Exception
	{
		find = Outside.service(this,"gus.java.srcfile.extract.classdata.checked");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File) return find.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
