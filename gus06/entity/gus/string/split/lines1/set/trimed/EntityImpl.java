package gus06.entity.gus.string.split.lines1.set.trimed;

import gus06.framework.*;
import java.util.Set;
import java.util.HashSet;

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
		Set set = new HashSet();
		for(String n:nn)
		if(!n.trim().equals("")) set.add(n.trim());
		return set;
	}
}
