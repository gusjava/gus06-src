package gus06.entity.gus.tostring.desc.list;

import java.util.Map;
import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151125";}


	private Service short1;
	
	public EntityImpl() throws Exception
	{short1 = Outside.service(this,"gus.tostring.desc.short1");}



	public Object t(Object obj) throws Exception
	{
		List list = (List) obj;
		
		StringBuffer b = new StringBuffer();
		b.append(short1.t(list)+"\n");
		
		for(int i=0;i<list.size();i++)
		{
			Object value = list.get(i);
			b.append(i+"-"+short1.t(value)+"\n");
		}
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
