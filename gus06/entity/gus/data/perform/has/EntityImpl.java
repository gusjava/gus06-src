package gus06.entity.gus.data.perform.has;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;
import javax.swing.JComponent;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160905";}


	private Service colContains;
	private Service mapContainsKey;
	private Service arrayContains;
	private Service compContains;
	private Service dirContains;
	
	
	public EntityImpl() throws Exception
	{
		colContains = Outside.service(this,"gus.collection.contains.coltof");
		mapContainsKey = Outside.service(this,"gus.map.contains.key.maptof");
		arrayContains = Outside.service(this,"gus.array.contains.arraytof");
		compContains = Outside.service(this,"gus.swing.comp.contains.comptof");
		dirContains = Outside.service(this,"gus.dir.contains.filetof");
	}

	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return new F0();
		
		if(obj instanceof List) return colContains.t(obj);
		if(obj instanceof Set) return colContains.t(obj);
		if(obj instanceof Map) return mapContainsKey.t(obj);
		if(obj instanceof Object[]) return arrayContains.t(obj);
		if(obj instanceof JComponent) return compContains.t(obj);
		if(obj instanceof File) return dirContains.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private class F0 implements F
	{
		public boolean f(Object obj) throws Exception
		{return false;}
	}
}
