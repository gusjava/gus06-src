package gus06.entity.gus.tostring.set.join.point;

import java.util.Set;
import gus06.framework.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170125";}


	private Service listToString;


	public EntityImpl() throws Exception
	{
		listToString = Outside.service(this,"gus.tostring.list.join.point");
	}


	public Object t(Object obj) throws Exception
	{return setToString((Set) obj);}
	
	
	private String setToString(Set set) throws Exception
	{
		List list = new ArrayList(set);
		Collections.sort(list);
		return (String) listToString.t(list);
	}
}
