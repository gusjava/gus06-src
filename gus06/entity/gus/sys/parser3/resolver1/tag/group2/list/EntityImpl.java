package gus06.entity.gus.sys.parser3.resolver1.tag.group2.list;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}


	private Service cutMethod;

	public EntityImpl() throws Exception
	{
		cutMethod = Outside.service(this,"gus.sys.parser3.cut.symbol.a1");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List l = (List) o[0];
		T t = (T) o[1];
		
		List result = new ArrayList();
		
		List cut = (List) cutMethod.t(new Object[]{l,","});
		if(cut==null)
		{
			result.add(t.t(l));
		}
		else
		{
			int number = cut.size();
			for(int i=0;i<number;i++)
			result.add(t.t(cut.get(i)));
		}
		return result;
	}
}
