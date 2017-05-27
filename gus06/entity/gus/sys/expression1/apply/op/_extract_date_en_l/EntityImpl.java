package gus06.entity.gus.sys.expression1.apply.op._extract_date_en_l;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170212";}


	private Service readText;
	private Service extract;
	
	public EntityImpl() throws Exception
	{
		readText = Outside.service(this,"gus.file.read.string.generic");
		extract = Outside.service(this,"gus.string.extract.date.en.l");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return extract.t(obj);
		if(obj instanceof File) return extract.t(readText.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
