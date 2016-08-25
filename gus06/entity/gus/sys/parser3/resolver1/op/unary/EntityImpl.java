package gus06.entity.gus.sys.parser3.resolver1.op.unary;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}

	public static final String TYPE = "type";
	public static final String VALUE = "value";
	public static final String TYPE_SYMBOL = "symbol";
	
	
	private Service resolveOpp;
	private Service resolveApply;
	private Service resolveApplier;
	private Service resolveEntityUnique;
	private Service resolveEntityMultiple;
	
	
	public EntityImpl() throws Exception
	{
		resolveOpp = Outside.service(this,"gus.sys.parser3.resolver1.op.unary.opp");
		resolveApply = Outside.service(this,"gus.sys.parser3.resolver1.op.unary.apply");
		resolveApplier = Outside.service(this,"gus.sys.parser3.resolver1.op.unary.applier");
		resolveEntityUnique = Outside.service(this,"gus.sys.parser3.resolver1.op.unary.entity.unique");
		resolveEntityMultiple = Outside.service(this,"gus.sys.parser3.resolver1.op.unary.entity.multiple");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		Map op = (Map) o[0];
		Map tag = (Map) o[1];
		T t = (T) o[2];
		
		try
		{
			if(!hasType(op,TYPE_SYMBOL))
				throw new Exception("Invalid first tag for unary operation: "+op);
		
			Object symbol = value(op);
		
			if(symbol.equals("-")) return resolveOpp.t(new Object[]{tag,t});
			if(symbol.equals("&")) return resolveApply.t(new Object[]{tag,t});
			if(symbol.equals("�")) return resolveApplier.t(new Object[]{tag,t});
			if(symbol.equals("@")) return resolveEntityUnique.t(new Object[]{tag,t});
			if(symbol.equals("�")) return resolveEntityMultiple.t(new Object[]{tag,t});
		
			throw new Exception("Invalid symbol for unary operation: "+symbol);
		}
		catch(Exception e)
		{
			String message = "UNARY EXP: op="+op+" tag="+tag;
			throw new Exception(message,e);
		}
	}
	
	
	
	private Object value(Map m)
	{return m.get(VALUE);}
	
	private String type(Map m)
	{return (String) m.get(TYPE);}
	
	private boolean hasValue(Map m, Object value)
	{return value(m).equals(value);}
	
	private boolean hasType(Map m, String type)
	{return type(m).equals(type);}
}
