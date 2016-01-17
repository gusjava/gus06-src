package gus06.entity.gus.sys.script1.tool.execute.code.line;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150906";}


	private Service formatValue;
	private Service opMap;

	public EntityImpl() throws Exception
	{
		formatValue = Outside.service(this,"gus.sys.script1.analyze2.formatvalue");
		opMap = Outside.service(this,"gus.sys.script1.tool.execute.code.opmap");
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		String line = (String) o[0];
		Map context = (Map) o[1];
		
		line = (String) formatValue.t(line);
		if(line.equals("")) return;
		
		String[] n = line.split("[ \n\r\t]+",2);
			
		String name = n[0];
		String params = n.length==2?n[1]:null;
		
		P op = (P) opMap.t(name);
		op.p(new Object[]{params,context});
	}
}
