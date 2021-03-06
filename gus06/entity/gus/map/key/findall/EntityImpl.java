package gus06.entity.gus.map.key.findall;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160201";}


	private Service builder;
	
	public EntityImpl() throws Exception
	{builder = Outside.service(this,"gus.feature.op.col.findall.mapkey.f");}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map input = (Map) o[0];
		F filter = (F) o[1];
		
		T t = (T) builder.t(filter);
		return t.t(input);
	}
}
