package gus06.entity.gus.sys.expression1.apply.op._parsetree_tab;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170304";}


	private Service readFile;
	private Service builder;
	
	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string.tree.autodetect");
		builder = Outside.service(this,"gus.data.transform.string.tree1");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof File) return readFile.t(obj);
		if(obj instanceof String) return builder.t(obj);
			
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
