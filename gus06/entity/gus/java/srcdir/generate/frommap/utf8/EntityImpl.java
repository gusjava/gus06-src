package gus06.entity.gus.java.srcdir.generate.frommap.utf8;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170310";}


	private Service fromSrc;
	private Service genSrc;


	public EntityImpl() throws Exception
	{
		fromSrc = Outside.service(this,"gus.java.srcdir.generate.fromsrc.utf8");
		genSrc = Outside.service(this,"gus.java.srccode.generate.classgenerator1");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		File dir = (File) o[1];
		
		String src = (String) genSrc.t(map);
		fromSrc.p(new Object[]{src,dir});
	}
}
