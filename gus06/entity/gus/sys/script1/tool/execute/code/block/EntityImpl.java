package gus06.entity.gus.sys.script1.tool.execute.code.block;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

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
		
		Map context = (Map) o[0];
		String code = (String) o[1];
		
		String[] lines = code.split("\n");
		
		List list = new ArrayList();
		
		for(String line:lines)
		{
			String s = line.trim();
			if(!s.equals("") && !s.startsWith("!"))
			list.add(line);
		}
		
		while(!list.isEmpty())
		{
			String line = (String) list.remove(0);
			execute.p(new Object[]{context,line});
		}
	}
}
