package gus06.entity.gus.sys.expression1.apply.op._nco_n;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160418";}
	
	
	private Service normalize;
	private Service readText;
	
	public EntityImpl() throws Exception
	{
		normalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");
		readText = Outside.service(this,"gus.file.read.string.autodetect");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new F1((String) obj);
		if(obj instanceof File) return new F1((String) readText.t(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class F1 implements F
	{
		private String s;
		public F1(String s) throws Exception
		{this.s = (String) normalize.t(s);}
		
		public boolean f(Object obj) throws Exception
		{
			String s0 = (String) normalize.t(obj);
			return !s.contains(s0);
		}
	}
}
