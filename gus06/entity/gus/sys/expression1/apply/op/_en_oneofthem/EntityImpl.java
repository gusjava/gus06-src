package gus06.entity.gus.sys.expression1.apply.op._en_oneofthem;

import gus06.framework.*;
import java.util.Map;
import java.util.List;
import java.util.Set;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160503";}


	
	
	private Service cuttingMethod;
	
	public EntityImpl() throws Exception
	{
		cuttingMethod = Outside.service(this,"gus.string.split.method1");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof String) return new F1((String) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private class F1 implements F
	{
		private String value;
		
		public F1(String value) throws Exception
		{this.value = value;}
		
		public boolean f(Object obj) throws Exception
		{
			String s0 = (String) obj;
			String[] words = (String[]) cuttingMethod.t(s0);
			for(int i=0;i<words.length;i++)
				if(value.endsWith(words[i])) return true;
			return false;
		}
	}
}
