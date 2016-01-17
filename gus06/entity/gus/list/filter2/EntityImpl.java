package gus06.entity.gus.list.filter2;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140819";}
	
	
	private Service listFilter;
	private Service filterBuilder;
	
	public EntityImpl() throws Exception
	{
		listFilter = Outside.service(this,"gus.list.findall");
		filterBuilder = Outside.service(this,"gus.filter.string.simple1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List list = (List) o[0];
		String rule = (String) o[1];
		
		if(rule.equals("")) return list;

		F filter = (F) filterBuilder.t(rule);
		return listFilter.t(new Object[]{list,filter});
	}
}
