package gus06.entity.gus.list.unique0_n;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160520";}


	private Service normalize;

	public EntityImpl() throws Exception
	{normalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");}

	
	
	public Object t(Object obj) throws Exception
	{
		List l = (List) obj;
		List l1 = new ArrayList();
		
		Set over = new HashSet();
		for(int i=0;i<l.size();i++)
		{
			String element = format((String) l.get(i));
			if(!over.contains(element))
			{
				if(!l1.contains(element)) l1.add(element);
				else
				{
					l1.remove(element);
					over.add(element);
				}
			}
		}
		return l1;
	}
	
	
	private String format(String s) throws Exception
	{return (String) normalize.t(s);}
}
