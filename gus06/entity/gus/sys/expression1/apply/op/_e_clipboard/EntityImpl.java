package gus06.entity.gus.sys.expression1.apply.op._e_clipboard;

import gus06.framework.*;
import java.util.Map;
import java.io.File;
import java.util.Collection;
import java.awt.Image;
import java.util.List;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20151115";}


	private Service perform;
	
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.clipboard.access");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof File) return new E1(obj);
		if(obj instanceof File[]) return new E1(obj);
		if(obj instanceof List) return new E1(obj);
		if(obj instanceof String) return new E1(obj);
		if(obj instanceof Image) return new E1(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	public Object r(String key) throws Exception
	{
		if(key.equals("types")) return new Class[]{File.class,File[].class,List.class,String.class,Image.class};
		if(key.equals("keys")) return new String[]{"types"};
		throw new Exception("Unknown key: "+key);
	}
	
	
	private class E1 implements E
	{
		private Object o;
		public E1(Object o) {this.o = o;}
		
		public void e() throws Exception
		{perform.p(o);}
	}
}
