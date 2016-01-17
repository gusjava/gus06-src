package gus06.entity.gus.sys.expression1.apply;

import gus06.framework.*;
import java.util.Collection;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151031";}
	
	

	private Service op2Int;
	private Service op2Double;
	private Service op2String;


	public EntityImpl() throws Exception
	{
		op2Int = Outside.service(this,"gus.sys.expression1.apply.op2.integer");
		op2Double = Outside.service(this,"gus.sys.expression1.apply.op2.double1");
		op2String = Outside.service(this,"gus.sys.expression1.apply.op2.string");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
				
		Map opMap = (Map) o[0];
		Object value = o[1];
		String op = findOp(o[2]);
		
		T opT = findOpT(op,opMap);
		return opT.t(new Object[]{value,opMap});
	}
	
	
	
	
	private T findOpT(String op, Map opMap) throws Exception
	{
		if(opMap.containsKey(op)) return (T) opMap.get(op);
		if(isInt(op)) return (T) op2Int.t(op);
		if(isDouble(op)) return (T) op2Double.t(op);
		
		return (T) op2String.t(op);
	}
	
	
	public boolean isInt(String op)
	{
		try{Integer.parseInt(op);return true;}
		catch(NumberFormatException e){}
		return false;
	}
	
	public boolean isDouble(String op)
	{
		try{Double.parseDouble(op);return true;}
		catch(NumberFormatException e){}
		return false;
	}
	
	
	
	
	private String findOp(Object obj) throws Exception
	{
		if(obj instanceof String) return (String) obj;
		if(obj instanceof Number) return obj.toString();
		if(obj instanceof Collection) return colToOp((Collection)obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private String colToOp(Collection col) throws Exception
	{
		if(col.size()!=1) throw new Exception("Could not convert collection to operator");
		return findOp(col.iterator().next());
	}
}
