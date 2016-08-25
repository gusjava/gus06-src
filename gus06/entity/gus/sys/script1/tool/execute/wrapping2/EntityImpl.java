package gus06.entity.gus.sys.script1.tool.execute.wrapping2;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160221";}

	private Service buildData;
	private Service wrapping;



	public EntityImpl() throws Exception
	{
		buildData = Outside.service(this,"gus.sys.script1.tool.execute.params.handler2.a");
		wrapping = Outside.service(this,"gus.sys.script1.tool.execute.wrapping");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Map context = (Map) o[0];
		Map tag = (Map) o[1];
		P wrap = (P) o[2];
		
		wrapping.p(new Object[]{context,tag,wrap,buildData});
	}
}
