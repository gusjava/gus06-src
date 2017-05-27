package gus06.entity.gus.list.collect3;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20170326";}


	private Service buildMap;
	
	public EntityImpl() throws Exception
	{
		buildMap = Outside.service(this,"gus.list.findall3.buildmap");
	}
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List input = (List) o[0];
		List output = (List) t(obj);
		
		input.clear();
		input.addAll(output);
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List input = (List) o[0];
		T t = (T) o[1];
		
		List output = new ArrayList();
		int nb = input.size();
		
		for(int i=0;i<nb;i++)
		{
			Integer index = new Integer(i);
			Map m = (Map) buildMap.t(new Object[]{input,index});
			output.add(t.t(m));
		}
		return output;
	}
}
