package gus06.entity.gus.sys.expression1.apply.op._co_oneofthem_i;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160503";}


	
	private Service cuttingMethod;
	private Service readText;
	
	public EntityImpl() throws Exception
	{
		cuttingMethod = Outside.service(this,"gus.string.split.method1");
		readText = Outside.service(this,"gus.file.read.string.generic");
	}


	
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
		private String value;
		
		public F1(String value) throws Exception
		{this.value = value.toLowerCase();}
		
		public boolean f(Object obj) throws Exception
		{
			String s0 = ((String) obj).toLowerCase();
			String[] words = (String[]) cuttingMethod.t(s0);
			for(int i=0;i<words.length;i++)
				if(value.contains(words[i])) return true;
			return false;
		}
	}
	
	private class F_false implements F
	{
		public boolean f(Object obj) throws Exception {return false;}
	}
}
