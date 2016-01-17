package gus06.entity.gus.map.key.filter2;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150615";}
	
	
	private Service mapFilter;
	private Service filterBuilder;
	
	public EntityImpl() throws Exception
	{
		mapFilter = Outside.service(this,"gus.map.key.filter");
		filterBuilder = Outside.service(this,"gus.filter.string.simple1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map map = (Map) o[0];
		String rule = (String) o[1];
		
		if(rule.equals("")) return map;

		F filter = (F) filterBuilder.t(rule);
		return mapFilter.t(new Object[]{map,filter});
	}
}
