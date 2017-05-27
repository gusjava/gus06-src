package gus06.entity.gus.string.split.lines1.list.trimed;

import gus06.framework.*;
import java.util.ArrayList;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170131";}


	private Service split;


	public EntityImpl() throws Exception
	{
		split = Outside.service(this,"gus.string.split.lines1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String[] nn = (String[]) split.t(obj);
		List list = new ArrayList();
		for(String n:nn)
		if(!n.trim().equals("")) list.add(n.trim());
		return list;
	}
}
