package gus06.entity.gus.sys.expression1.apply.op._id_to_file;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160212";}
	
	public static final String C_FILE_MAPPER = "file_mapper";


	private Service getContext;

	public EntityImpl() throws Exception
	{
		getContext = Outside.service(this,"gus.sys.script1.access.opmap.context");
	}
	

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object data = o[0];
		Map opMap = (Map) o[1];
		
		if(data==null) return null;
		if(data instanceof String) return findFile((String) data, opMap);
		
		throw new Exception("Invalid data type: "+data.getClass().getName());
	}
	
	
	
	private File findFile(String id, Map opMap) throws Exception
	{
		Map context = (Map) getContext.t(opMap);
		
		T t = (T) get(context,C_FILE_MAPPER);
		if(t==null) throw new Exception("File mapper not found inside context map");
		
		return (File) t.t(id);
	}
	
	
	private Object get(Map m, String k)
	{return m.containsKey(k)?m.get(k):null;}
}
