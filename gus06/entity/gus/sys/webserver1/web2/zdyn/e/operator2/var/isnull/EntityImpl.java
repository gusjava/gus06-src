package gus06.entity.gus.sys.webserver1.web2.zdyn.e.operator2.var.isnull;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141021";}


	private Service findVar;
	
	public EntityImpl() throws Exception
	{findVar = Outside.service(this,"gus.sys.webserver1.web2.zdyn.e.var.build");}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=4) throw new Exception("Wrong data number: "+o.length);
		
		R mr = (R) o[0];
		String info = (String) o[1];
		Map args = (Map) o[2];
		Map vars = (Map) o[3];
		
		Object result = findVar.t(new Object[]{vars,info});
		return ""+(result==null);
	}
}
