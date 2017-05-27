package gus06.entity.gus.data.perform.add;

import gus06.framework.*;
import java.util.List;
import java.util.Set;
import java.awt.Rectangle;
import javax.swing.text.JTextComponent;
import javax.swing.text.Document;
import java.awt.Container;

public class EntityImpl implements Entity, P, T {

	public String creationDate() {return "20160128";}
	
	
	private Service performList;
	private Service performSet;
	private Service performRect;
	private Service performContainer;
	
	public EntityImpl() throws Exception
	{
		performList = Outside.service(this,"gus.list.add");
		performSet = Outside.service(this,"gus.set.add");
		performRect = Outside.service(this,"gus.awt.rectangle.add");
		performContainer = Outside.service(this,"gus.awt.container.add");
	}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)		{performList.p(o);return;}
		if(input instanceof Set)		{performSet.p(o);return;}
		if(input instanceof Rectangle)		{performRect.p(o);return;}
		if(input instanceof StringBuffer)	{performSb(o);return;}
		if(input instanceof JTextComponent)	{performTextComp(o);return;}
		if(input instanceof Container)		{performContainer.p(o);return;}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Object input = o[0];
		
		if(input instanceof List)
			return performList.t(obj);
		
		if(input instanceof Set)
			return performSet.t(obj);
		
		if(input instanceof String)
		{
			String s = (String) o[1];
			return input+s;
		}
		if(input instanceof Number)
		{
			Number s = (Number) o[1];
			return add((Number) input,s);
		}
		
		throw new Exception("Invalid data type: "+input.getClass().getName());
	}
	
	
	
	
	private void performSb(Object[] o)
	{
		StringBuffer sb = (StringBuffer) o[0];
		String s = (String) o[1];
		
		sb.append(s);
	}
	
	
	private void performTextComp(Object[] o) throws Exception
	{
		JTextComponent comp = (JTextComponent) o[0];
		String s = (String) o[1];
		
		Document doc = comp.getDocument();
		int len = doc.getLength();
		doc.insertString(len,s,null);
	}
	
	
	
	
	
	
	private Object add(Number n1, Number n2) throws Exception
	{
		if(n1 instanceof Integer && n2 instanceof Integer)
			return new Integer(n1.intValue() + n2.intValue());
		
		if(n1 instanceof Float && n2 instanceof Float)
			return new Float(n1.floatValue() + n2.floatValue());
		
		if(n1 instanceof Double || n2 instanceof Double)
			return new Double(n1.doubleValue() + n2.doubleValue());
		
		if(n1 instanceof Long || n2 instanceof Long)
			return new Long(n1.longValue() + n2.longValue());
		
		return new Double(n1.doubleValue() + n2.doubleValue());
	}
}
