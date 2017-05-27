package gus06.entity.gus.sys.expression1.apply.op._fchildrennames;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160408";}


	private Service listing;
	private Service buildFile;
	
	public EntityImpl() throws Exception
	{
		listing = Outside.service(this,"gus.dir.listing0.files.names");
		buildFile = Outside.service(this,"gus.sys.expression1.file.build");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof File)
			return listing.t(value);
			
		if(value instanceof String)
			return listing.t(file((String) value,opMap));
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	private File file(String s, Map opMap) throws Exception
	{return (File) buildFile.t(new Object[]{s,opMap});}
}
