package gus06.entity.gus.file.info.string.charset.asstring;

import gus06.framework.*;
import java.nio.charset.Charset;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151006";}
	
	private Service check;
	private Service info;
	
	
	public EntityImpl() throws Exception
	{
		check = Outside.service(this,"gus.file.string.check");
		info = Outside.service(this,"gus.file.string.info.charset");
	}


	public Object t(Object obj) throws Exception
	{
		if(!check.f(obj)) return "";
		Charset charset = (Charset) info.t(obj);
		return charset.name();
	}
}
