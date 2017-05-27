package gus06.entity.gus.sys.expression1.apply.op._searchdirs_byname;

import gus06.framework.*;
import java.io.File;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151205";}


	private Service perform;
	private Service buildFile;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.dir.perform.searchdirs.byname");
		buildFile = Outside.service(this,"gus.sys.expression1.file.build");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object value = o[0];
		Map opMap = (Map) o[1];
		
		if(value==null) return null;
		
		if(value instanceof String) return new T1(file((String) value, opMap));
		if(value instanceof File) return new T1(value);
		
		throw new Exception("Invalid data type: "+value.getClass().getName());
	}
	
	private File file(String s, Map opMap) throws Exception
	{return (File) buildFile.t(new Object[]{s,opMap});}
	
	
	private class T1 implements T
	{
		private Object value;
		public T1(Object value)
		{this.value = value;}
		
		public Object t(Object obj) throws Exception
		{
			String s = (String) obj;
			return perform.t(new Object[]{value,s});
		}
	}
}
