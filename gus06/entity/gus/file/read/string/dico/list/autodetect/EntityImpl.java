package gus06.entity.gus.file.read.string.dico.list.autodetect;

import gus06.framework.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170109";}


	private Service read;


	public EntityImpl() throws Exception
	{read = Outside.service(this,"gus.file.read.string.array.autodetect");}
	
	
	public Object t(Object obj) throws Exception
	{
		String[] array = (String[]) read.t(obj);
		
		List list = new ArrayList();
		for(String line:array)
		list.add(line.split("\t",-1));
		
		return list;
	}
}
