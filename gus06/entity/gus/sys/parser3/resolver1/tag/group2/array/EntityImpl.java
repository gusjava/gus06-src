package gus06.entity.gus.sys.parser3.resolver1.tag.group2.array;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.io.File;
import java.util.Set;
import java.awt.Color;
import java.util.Date;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151030";}
	
	public static final String VALUE = "value";


	private Service cutMethod;

	public EntityImpl() throws Exception
	{
		cutMethod = Outside.service(this,"gus.sys.parser3.resolver1.cut.symbol1");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		List l1 = (List) o[0];
		List l2 = (List) o[1];
		T t = (T) o[2];
		
		if(l1.size()!=1) throw new Exception("Invalid array");
		String type = (String) value((Map) l1.get(0));
		
		List cut = buildCut(l2);
		int number = cut.size();
		
		
		
		if(type.equals("int"))
		{
			int[] arr = new int[number];
			for(int i=0;i<number;i++)
			arr[i] = to_int(t.t(cut.get(i)));
			return arr;
		}
		
		if(type.equals("double"))
		{
			double[] arr = new double[number];
			for(int i=0;i<number;i++)
			arr[i] = to_double(t.t(cut.get(i)));
			return arr;
		}
		
		if(type.equals("float"))
		{
			float[] arr = new float[number];
			for(int i=0;i<number;i++)
			arr[i] = to_float(t.t(cut.get(i)));
			return arr;
		}
		
		if(type.equals("bool"))
		{
			boolean[] arr = new boolean[number];
			for(int i=0;i<number;i++)
			arr[i] = to_bool(t.t(cut.get(i)));
			return arr;
		}
		
		if(type.equals("byte"))
		{
			byte[] arr = new byte[number];
			for(int i=0;i<number;i++)
			arr[i] = to_byte(t.t(cut.get(i)));
			return arr;
		}
		
		if(type.equals("char"))
		{
			char[] arr = new char[number];
			for(int i=0;i<number;i++)
			arr[i] = to_char(t.t(cut.get(i)));
			return arr;
		}
		
		
		
		
		if(type.equals("Object") || type.equals("o"))
		{
			Object[] arr = new Object[number];
			for(int i=0;i<number;i++)
			arr[i] = t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("String") || type.equals("s"))
		{
			String[] arr = new String[number];
			for(int i=0;i<number;i++)
			arr[i] = toString(t.t(cut.get(i)));
			return arr;
		}
		
		if(type.equals("File"))
		{
			File[] arr = new File[number];
			for(int i=0;i<number;i++)
			arr[i] = (File) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("URL"))
		{
			URL[] arr = new URL[number];
			for(int i=0;i<number;i++)
			arr[i] = (URL) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("Color"))
		{
			Color[] arr = new Color[number];
			for(int i=0;i<number;i++)
			arr[i] = (Color) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("Date"))
		{
			Date[] arr = new Date[number];
			for(int i=0;i<number;i++)
			arr[i] = (Date) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("Map"))
		{
			Map[] arr = new Map[number];
			for(int i=0;i<number;i++)
			arr[i] = (Map) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("Set"))
		{
			Set[] arr = new Set[number];
			for(int i=0;i<number;i++)
			arr[i] = (Set) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("List"))
		{
			List[] arr = new List[number];
			for(int i=0;i<number;i++)
			arr[i] = (List) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("E"))
		{
			E[] arr = new E[number];
			for(int i=0;i<number;i++)
			arr[i] = (E) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("F"))
		{
			F[] arr = new F[number];
			for(int i=0;i<number;i++)
			arr[i] = (F) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("G"))
		{
			G[] arr = new G[number];
			for(int i=0;i<number;i++)
			arr[i] = (G) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("H"))
		{
			H[] arr = new H[number];
			for(int i=0;i<number;i++)
			arr[i] = (H) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("I"))
		{
			I[] arr = new I[number];
			for(int i=0;i<number;i++)
			arr[i] = (I) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("P"))
		{
			P[] arr = new P[number];
			for(int i=0;i<number;i++)
			arr[i] = (P) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("T"))
		{
			T[] arr = new T[number];
			for(int i=0;i<number;i++)
			arr[i] = (T) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("R"))
		{
			R[] arr = new R[number];
			for(int i=0;i<number;i++)
			arr[i] = (R) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("S"))
		{
			S[] arr = new S[number];
			for(int i=0;i<number;i++)
			arr[i] = (S) t.t(cut.get(i));
			return arr;
		}
		
		if(type.equals("V"))
		{
			V[] arr = new V[number];
			for(int i=0;i<number;i++)
			arr[i] = (V) t.t(cut.get(i));
			return arr;
		}
		
		throw new Exception("Unsupported array type: "+type);
	}
	
	
	
	private Object value(Map m)
	{return m.get(VALUE);}
	
	
	private String toString(Object obj)
	{return obj==null?"null":obj.toString();}
	
	
	
	private List buildCut(List l) throws Exception
	{
		if(l.isEmpty()) return new ArrayList();
		
		List cut = (List) cutMethod.t(new Object[]{l,","});
		if(cut!=null) return cut;
		
		cut = new ArrayList();
		cut.add(l);
		return cut;
	}
	
	
	
	
	
	
	private int to_int(Object obj) throws Exception
	{
		if(obj instanceof Number)	return ((Number)obj).intValue();
		if(obj instanceof String)	return Integer.parseInt((String) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private double to_double(Object obj) throws Exception
	{
		if(obj instanceof Number)	return ((Number)obj).doubleValue();
		if(obj instanceof String)	return Double.parseDouble((String) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private float to_float(Object obj) throws Exception
	{
		if(obj instanceof Number)	return ((Number)obj).floatValue();
		if(obj instanceof String)	return Float.parseFloat((String) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private boolean to_bool(Object obj) throws Exception
	{
		if(obj instanceof Boolean)	return ((Boolean)obj).booleanValue();
		if(obj instanceof String)	return Boolean.parseBoolean((String) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private char to_char(Object obj) throws Exception
	{
		if(obj instanceof String && ((String)obj).length()==1)
			return ((String) obj).charAt(0);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private byte to_byte(Object obj) throws Exception
	{
		if(obj instanceof Byte)		return ((Byte)obj).byteValue();
		if(obj instanceof String)	return Byte.parseByte((String) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
