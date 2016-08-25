package gus06.entity.gus.sys.expression1.apply.op._extract2_l;

import gus06.framework.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160611";}


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
			String regex = (String) obj;
			return extract(data,regex);		
		}
	}
	
	
	
	
	private String extract(String data, String regex) throws Exception
	{
		Pattern p = Pattern.compile(regex,Pattern.DOTALL);
		Matcher m = p.matcher(data);
		
		String result = null;
		int group = m.groupCount()>0?1:0;
		while(m.find()) result = m.group(group);
		return result;
	}
}
