package gus06.entity.gus.map.deep.nextdata0.list;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160312";}


	private Service ruleToIndex;
	
	public EntityImpl() throws Exception
	{
		ruleToIndex = Outside.service(this,"gus.list.ruletoindex");
	}



	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2)	throw new Exception("Wrong data number: "+o.length);
		
		List data = (List) o[0];
		String key = (String) o[1];
		
		if(key.equals("after"))
			return null;
			
		if(key.equals("before"))
			return null;
		
		Integer index = (Integer) ruleToIndex.t(obj);
		if(index==null) return null;
		
		return data.get(index.intValue());
	}
}
