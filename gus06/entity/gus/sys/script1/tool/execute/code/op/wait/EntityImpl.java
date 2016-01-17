package gus06.entity.gus.sys.script1.tool.execute.code.op.wait;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150906";}


	private Service evalAsLong;

	public EntityImpl() throws Exception
	{
		evalAsLong = Outside.service(this,"gus.sys.script1.context.evaluate.long1");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String line = (String) o[0];
		Map context = (Map) o[1];
		
		Long lapse = (Long) evalAsLong.t(new Object[]{context,line});
		Thread.sleep(lapse.longValue());
	}
}
