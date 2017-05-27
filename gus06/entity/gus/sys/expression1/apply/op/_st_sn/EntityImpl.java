package gus06.entity.gus.sys.expression1.apply.op._st_sn;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160502";}


	private Service normalize1;
	private Service normalize2;
	private Service readText;
	
	public EntityImpl() throws Exception
	{
		normalize1 = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");
		normalize2 = Outside.service(this,"gus.string.transform.normalize.whitespace1");
		readText = Outside.service(this,"gus.file.read.string.autodetect");
	}
	
	private String normalize(String s) throws Exception
	{return (String) normalize2.t(normalize1.t(s));}


	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return new F_false();
		if(obj instanceof String) return new F1((String) obj);
		if(obj instanceof File) return new F1((String) readText.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class F1 implements F
	{
		private String s;
		
		public F1(String s) throws Exception
		{this.s = normalize(s);}
		
		public boolean f(Object obj) throws Exception
		{
			String s0 = normalize((String) obj);
			return s.startsWith(s0);
		}
	}
	
	private class F_false implements F
	{
		public boolean f(Object obj) throws Exception {return false;}
	}
}
