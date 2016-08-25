package gus06.entity.gus.sys.expression1.apply.op._extractline_en_i;

import gus06.framework.*;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160805";}


	private Service readText;

	public EntityImpl() throws Exception
	{
		readText = Outside.service(this,"gus.file.read.string.generic");
	}



	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new T1((String) obj);
		if(obj instanceof File) return new T1((String) readText.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class T1 implements T
	{
		private String data;
		public T1(String data) {this.data = data;}
		
		public Object t(Object obj) throws Exception
		{
			String s = (String) obj;
			return extract(data,s);		
		}
	}
	
	
	
	
	private List extract(String data, String s) throws Exception
	{
		String[] lines = data.split("[\n\r]+",-1);
		List list = new ArrayList();
		for(String line:lines)
		if(line.toLowerCase().endsWith(s.toLowerCase())) list.add(line);
		return list;
	}
}
