package gus06.entity.gus.sys.expression1.apply.op._gen_num1;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160730";}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof Integer) return generate(toInt(obj));
		if(obj instanceof String) return generate(toInt(obj));
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private int toInt(Object obj)
	{return Integer.parseInt(""+obj);}
	
	
	private String generate(int length)
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<length;i++) b.append(randomChar());
		return b.toString();
	}
	
	
	private char randomChar()
	{
		int r = random(11);
		if(r<10) return (char)(48+r);
		return '_';
	}
	
	
	private int random(int limit)
	{return (int) (Math.random()*limit);}
}
