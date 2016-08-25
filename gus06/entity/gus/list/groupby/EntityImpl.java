package gus06.entity.gus.list.groupby;

import gus06.framework.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160821";}


	private Service putInList;
	
	public EntityImpl() throws Exception
	{
		putInList = Outside.service(this,"gus.map.put.inlist");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List input = (List) o[0];
		T t = (T) o[1];
		
		Map output = new HashMap();
		for(Object elem:input)
		{
			Object elem1 = t.t(elem);
			putInList.p(new Object[]{output,elem1,elem});
		}
		return output;
	}
}
