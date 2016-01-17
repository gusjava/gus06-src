package gus06.entity.gus.sys.option.getfile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, R {

	public String creationDate() {return "20150318";}


	private Service m;
	
	public EntityImpl() throws Exception
	{
		m = Outside.service(this,"gus.sys.option.manager");
	}
	
	
	public Object r(String key) throws Exception
	{
		String v = (String) m.r(key);
		if(v==null || v.equals("")) return null;
		return new File(v);
	}
}
