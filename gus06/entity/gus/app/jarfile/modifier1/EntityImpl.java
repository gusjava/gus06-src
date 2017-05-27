package gus06.entity.gus.app.jarfile.modifier1;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20170401";}
	

	private Service getAppJar;
	private Service jarModifier;

	public EntityImpl() throws Exception
	{
		getAppJar = Outside.service(this,"gus.app.jarfile");
		jarModifier = Outside.service(this,"gus.file.jar.modifier1");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File jarFile1 = (File) o[0];
		Map map = (Map) o[1];
		
		File jarFile0 = (File) getAppJar.g();
		jarModifier.p(new Object[]{jarFile0,jarFile1,map});
	}
}
