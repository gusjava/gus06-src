package gus06.entity.gus.tostring.desc.set;

import gus06.framework.*;
import java.util.Iterator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151125";}
	
	
	private Service short1;
	
	public EntityImpl() throws Exception
	{short1 = Outside.service(this,"gus.tostring.desc.short1");}



	public Object t(Object obj) throws Exception
	{
		Set set = (Set) obj;
		
		StringBuffer b = new StringBuffer();
		b.append(short1.t(set)+"\n");
		
		List list = new ArrayList(set);
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++)
		{
			Object value = list.get(i);
			b.append(short1.t(value)+"\n");
		}
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
