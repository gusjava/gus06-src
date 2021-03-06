package gus06.entity.gus.sys.expression1.apply.op._id_to_gg;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160920";}


	private Service id_to_g;
	
	public EntityImpl() throws Exception
	{
		id_to_g = Outside.service(this,"gus.sys.expression1.apply.op._id_to_g");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object data = o[0];
		Map opMap = (Map) o[1];
		
		if(data==null) return null;
		if(data instanceof String) return find(data, opMap);
		
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
	
	
	
	private Object find(Object data, Map opMap) throws Exception
	{
		G g = (G) id_to_g.t(new Object[]{data,opMap});
		return g.g();
	}
}
