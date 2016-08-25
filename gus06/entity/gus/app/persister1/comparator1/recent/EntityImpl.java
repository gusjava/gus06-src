package gus06.entity.gus.app.persister1.comparator1.recent;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, R, V {

	public String creationDate() {return "20160510";}


	private Service persistList;
	private Service listToComparator;


	public EntityImpl() throws Exception
	{
		persistList = Outside.service(this,"gus.app.persister1.data.list");
		listToComparator = Outside.service(this,"gus.convert.listtocomparator");
	}
	
	
	public Object r(String key) throws Exception
	{
		List l = (List) persistList.r(key);
		if(l==null) l = new ArrayList();
		return listToComparator.t(l);
	}
	
	
	public void v(String key, Object obj) throws Exception
	{
		List l = (List) persistList.r(key);
		if(l==null) l = new ArrayList();
		
		l.remove(obj);
		l.add(obj);
		
		persistList.v(key,l);
	}
}
