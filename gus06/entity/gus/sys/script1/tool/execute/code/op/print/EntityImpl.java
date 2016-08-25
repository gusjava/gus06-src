package gus06.entity.gus.sys.script1.tool.execute.code.op.print;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150906";}


	private Service print;
	private Service eval;

	public EntityImpl() throws Exception
	{
		print = Outside.service(this,"gus.sys.script1.tool.print");
		eval = Outside.service(this,"gus.sys.script1.context.evaluate");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map context = (Map) o[0];
		String line = (String) o[1];
		
		Object value = eval.t(new Object[]{context,line});
		print.p(new Object[]{context,value});
	}
}
