package gus06.entity.gus.sys.expression1.apply.op._append_text;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160415";}
	


	private Service writeFile;
	
	public EntityImpl() throws Exception
	{
		writeFile = Outside.service(this,"gus.file.write.string.append.cs.default0");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File) return new Writer((File) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class Writer implements P
	{
		private File file;
		public Writer(File file) {this.file = file;}
		
		public void p(Object obj) throws Exception
		{writeFile.p(new Object[]{file,obj});}
	}
}
