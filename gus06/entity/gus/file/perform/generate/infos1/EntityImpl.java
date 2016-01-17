package gus06.entity.gus.file.perform.generate.infos1;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150826";}


	private Service extract;
	private Service write;


	public EntityImpl() throws Exception
	{
		extract = Outside.service(this,"gus.file.extract.infomap1");
		write = Outside.service(this,"gus.file.write.properties");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] o = (File[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) extract.t(o[0]);
		write.p(new Object[]{o[1],map});
	}
}
