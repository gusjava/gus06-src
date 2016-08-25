package gus06.entity.gus.file.read.string.list.autodetect;

import gus06.framework.*;
import java.util.Arrays;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160804";}


	private Service read;


	public EntityImpl() throws Exception
	{read = Outside.service(this,"gus.file.read.string.array.autodetect");}
	
	
	public Object t(Object obj) throws Exception
	{
		String[] array = (String[]) read.t(obj);
		return Arrays.asList(array);
	}
}
