package gus06.entity.gus.file.read.string.list;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160804";}


	private Service read;


	public EntityImpl() throws Exception
	{read = Outside.service(this,"gus.file.read.string.array");}
	
	
	public Object t(Object obj) throws Exception
	{
		String[] array = (String[]) read.t(obj);
		List l = new ArrayList();
		for(String a : array) l.add(a);
		return l;
	}
}
