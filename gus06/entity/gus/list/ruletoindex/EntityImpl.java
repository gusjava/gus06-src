package gus06.entity.gus.list.ruletoindex;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160714";}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		int size = toSize(o[0]);
		Object rule = o[1];
		
		int index = findIndex(size,rule);
		return index==-1 ? null : new Integer(index);
	}
	
	
	private int toSize(Object obj) throws Exception
	{
		if(obj==null) return 0;
		if(obj instanceof Integer) return ((Integer) obj).intValue();
		
		if(obj instanceof List) return ((List) obj).size();
		if(obj instanceof String) return ((String) obj).length();
		if(obj instanceof StringBuffer) return ((StringBuffer) obj).length();
		if(obj instanceof Object[]) return ((Object[]) obj).length;
		
		if(obj instanceof byte[]) return ((byte[]) obj).length;
		if(obj instanceof boolean[]) return ((boolean[]) obj).length;
		if(obj instanceof char[]) return ((char[]) obj).length;
		if(obj instanceof short[]) return ((short[]) obj).length;
		if(obj instanceof boolean[]) return ((boolean[]) obj).length;
		if(obj instanceof int[]) return ((int[]) obj).length;
		if(obj instanceof long[]) return ((long[]) obj).length;
		if(obj instanceof double[]) return ((double[]) obj).length;
		if(obj instanceof float[]) return ((float[]) obj).length;
	
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	private int findIndex(int n, Object rule) throws Exception
	{
		if(n==0) return -1;
		int index = findIndex1(n,rule);
		while(index<0) index += n;
		return index>=n ? -1 : index;
	}
	
	
	private int findIndex1(int n, Object rule) throws Exception
	{
		if(rule instanceof Integer) return ((Integer) rule).intValue();
		if(rule instanceof String) return findIndex1_str(n,(String) rule);
		throw new Exception("Invalid rule type: "+rule.getClass().getName());
	}
	
	
	private int findIndex1_str(int n, String rule)
	{
		if(rule.startsWith("(") && rule.endsWith(")"))
			rule = rule.substring(1,rule.length()-1);
		
		if(rule.startsWith("[") && rule.endsWith("]"))
			rule = rule.substring(1,rule.length()-1);
		
		if(rule.equals("first")) return 0;
		if(rule.equals("last")) return n-1;
		if(rule.equals("random")) return random(n);
		if(rule.equals("middle1")) return middle1(n);
		if(rule.equals("middle2")) return middle2(n);
		
		rule = rule.trim();
		if(rule.startsWith("m"))
		{
			int c = Integer.parseInt(rule.substring(1));
			return -1*Math.abs(c);
		}
		return Integer.parseInt(rule);
	}
	
	
	private int random(int n)
	{return (int) (Math.random()*n);}
	
	private int middle1(int n)
	{return (n/2)-(n-1)%2;}
	
	private int middle2(int n)
	{return n/2;}
}
