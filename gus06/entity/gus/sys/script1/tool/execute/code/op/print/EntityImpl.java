package gus06.entity.gus.sys.script1.tool.execute.code.op.print;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150906";}


	private Service getOutput;
	private Service evalAsString;

	public EntityImpl() throws Exception
	{
		getOutput = Outside.service(this,"gus.sys.script1.access.context.output0");
		evalAsString = Outside.service(this,"gus.sys.script1.context.evaluate.string1");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String line = (String) o[0];
		Map context = (Map) o[1];
		
		String value = (String) evalAsString.t(new Object[]{context,line});
		P output = (P) getOutput.t(context);
			
		if(output!=null) output.p(value);
	}
}
