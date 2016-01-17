package gus06.entity.gus.sys.script1.tool.execute.code.op.execute;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150906";}


	private Service evalAsObject;

	public EntityImpl() throws Exception
	{
		evalAsObject = Outside.service(this,"gus.sys.script1.context.evaluate");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String line = (String) o[0];
		Map context = (Map) o[1];
		
		E exec = (E) evalAsObject.t(new Object[]{context,line});
		exec.e();
	}
}
