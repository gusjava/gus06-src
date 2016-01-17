package gus06.entity.gus.data.viewer.field.form;

import gus06.framework.*;
import javax.swing.JComponent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140821";}

	private Service formPanel;
	private Service getValue;
	private Field data;
	
	
	
	public EntityImpl() throws Exception
	{
		formPanel = Outside.service(this,"*gus.swing.panel.formpanel.map");
		getValue = Outside.service(this,"gus.reflection.field.getstaticvalue");
	}
	
	
	
	public Object g() throws Exception
	{return data;}
	
	
	public Object i() throws Exception
	{return formPanel.i();}
	
	
	public void p(Object obj) throws Exception
	{
		data = (Field) obj;
		if(data==null) resetGui();
		else updateGui();
	}
		
		
		
		
		
	private void resetGui() throws Exception
	{
		formPanel.e();
	}
    
    
	
	private void updateGui() throws Exception
	{
		formPanel.e();
		
		set("Field name",fieldName());
		set("Field modifiers",fieldModifiers());
		set("Field type",fieldType());
		
		if(isStatic()) set("Field value",fieldValue());
	}
	
	
	
	
	
	private void set(String key, String value) throws Exception
	{formPanel.v(key,value);}
    
	private void set_(String key, String value) throws Exception
	{formPanel.v("|"+key,value);}
	
	
	
	
	
	private String fieldName()
	{
		if(data==null) return "";
		return data.getName();
	}
	
	
	
	private String fieldType()
	{
		if(data==null) return "";
		return data.getType().getName();
	}
	
	
	
	private String fieldValue()
	{
		try
		{
			if(data==null) return "";
			return ""+getValue.t(data);
		}
		catch(Exception e) {return "ERR:"+e;}
	}
	
	
	private String fieldModifiers()
	{
		int mod = data.getModifiers();
		return modToString(mod)+"("+mod+")";
	}
	
	
	
	private String modToString(int mod)
	{
		StringBuffer b = new StringBuffer();
		
		if(Modifier.isFinal(mod)) b.append("final ");
		if(Modifier.isVolatile(mod)) b.append("volatile ");
		if(Modifier.isStatic(mod)) b.append("static ");
		if(Modifier.isPublic(mod)) b.append("public ");
		if(Modifier.isProtected(mod)) b.append("protected ");
		if(Modifier.isPrivate(mod)) b.append("private ");
		
		return b.toString();
	}
	
	
	private boolean isStatic()
	{return Modifier.isStatic(data.getModifiers());}
}
