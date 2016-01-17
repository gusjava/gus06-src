package gus06.entity.gus.file.mime.tika.check.isoftype;

import gus06.framework.*;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MediaTypeRegistry;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150822";}


	private Service detect;

	public EntityImpl() throws Exception
	{
		detect = Outside.service(this,"gus.file.mime.tika.detect.asmediatype");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object target = o[0];
		String type1 = (String) o[1];
		
		MediaType type = (MediaType) detect.t(target);
		MediaTypeRegistry registry = MediaTypeRegistry.getDefaultRegistry();
		
		while(type!=null)
		{
			if(type.toString().equals(type1)) return true;
			type = registry.getSupertype(type);
		}
		return false;
	}
}
