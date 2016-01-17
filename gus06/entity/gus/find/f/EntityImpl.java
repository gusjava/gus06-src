package gus06.entity.gus.find.f;

import gus06.framework.*;
import java.io.FileFilter;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150708";}


	private Service boolToF;
	private Service fileFilterToF;


	public EntityImpl() throws Exception
	{
		boolToF = Outside.service(this,"gus.feature.wrap.bool.gpf");
		fileFilterToF = Outside.service(this,"gus.convert.filefiltertof");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		if(obj==null) return null;
		if(obj instanceof F) return obj;
		if(obj instanceof Boolean) return boolToF.t(obj);
		if(obj instanceof FileFilter) return fileFilterToF.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
