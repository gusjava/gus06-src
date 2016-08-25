package gus06.entity.gus.sys.jsonparser1.resolver.tag.group2;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151125";}
	
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
		if(l.isEmpty()) return result;
		
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
