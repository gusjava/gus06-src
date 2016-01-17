package gus06.entity.gus.sys.script1.tool.execute.code.block;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150906";}


	private Service execute;

	public EntityImpl() throws Exception
	{
		execute = Outside.service(this,"gus.sys.script1.tool.execute.code.line");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String code = (String) o[0];
		Map context = (Map) o[1];
		
		String[] lines = code.split("\n");
		
		for(String line:lines)
		execute.p(new Object[]{line,context});
	}
}
