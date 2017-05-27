package gus06.entity.gus.sys.expression1.apply.op._parsetree_atmark;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161016";}

	private Service perform;
	private Service read;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.sys.treeparser1.engine");
		read = Outside.service(this,"gus.file.read.string.autodetect");
	}
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return perform.t(obj);
		if(obj instanceof File) return perform.t(read((File) obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private String read(File file) throws Exception
	{return (String) read.t(file);}
}
