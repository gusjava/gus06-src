package gus06.entity.gus.data.perform.keylist;

import gus06.framework.*;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170418";}


	private Service performFile;
	
	public EntityImpl() throws Exception
	{
		performFile = Outside.service(this,"gus.file.read.properties.keyset");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		
		if(obj instanceof Map) return perform((Map) obj);
		if(obj instanceof File) return perform((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private List perform(Map m)
	{
		return new ArrayList(m.keySet());
	}
	
	private List perform(File f) throws Exception
	{
		Set set = (Set) performFile.t(f);
		return new ArrayList(set);
	}
}
