package gus06.entity.gus.data.perform.subsequence0;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151119";}


	private Service stringSub;
	private Service listSub;


	public EntityImpl() throws Exception
	{
		stringSub = Outside.service(this,"gus.data.string.subsequence0");
		listSub = Outside.service(this,"gus.data.list.subsequence0");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof String) return stringSub.t(obj);
		if(input instanceof List) return listSub.t(obj);
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
}
