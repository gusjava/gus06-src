package gus06.entity.gus.sys.expression1.apply.op._mutate_abcd;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161215";}

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	
	private Service perform;
	
	public EntityImpl() throws Exception
	{perform = Outside.service(this,"gus.data.string.mutation.perform");}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return new T1(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private class T1 implements T
	{
		private Object value;
		public T1(Object value) {this.value = value;}
		
		public Object t(Object obj) throws Exception
		{return perform.t(new Object[]{value,ALPHABET,obj});}
	}
}
