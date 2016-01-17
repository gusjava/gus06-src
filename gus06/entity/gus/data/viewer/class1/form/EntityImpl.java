package gus06.entity.gus.data.viewer.class1.form;

import gus06.framework.*;
import javax.swing.JComponent;
import java.net.*;
import java.security.*;


public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140806";}


	private Service formPanel;
	
	private Service jarURL;
	private Service classURL;
	private Service javaURL;
	
 	private Class data;


	public EntityImpl() throws Exception
	{
		formPanel = Outside.service(this,"*gus.swing.panel.formpanel.map");
		
		jarURL = Outside.service(this,"gus.java.fromclass.jarurl");
		classURL = Outside.service(this,"gus.java.fromclass.classurl");
		javaURL = Outside.service(this,"gus.java.fromclass.javaurl");
	}
	
	
	public Object g() throws Exception
	{return data;}
	
	
	public Object i() throws Exception
	{return formPanel.i();}
	
	
	public void p(Object obj) throws Exception
	{
		data = (Class) obj;
		if(data==null) resetGui();
		else updateGui();
	}
		
		
		
		
		
	private void resetGui() throws Exception
	{
		formPanel.e();
	}
    
    
	
	private void updateGui() throws Exception
	{
		set("Class name",className());
		set("Class loader",classLoaderName());
		set("Parent",superClassName());
		set_("Interfaces",findInterfaces());
		
		set("Jar URL",jarURL());
		set("Class URL",classURL());
		set("Java URL",javaURL());
	}
	
	
	private void set(String key, String value) throws Exception
	{formPanel.v(key,value);}
    
	private void set_(String key, String value) throws Exception
	{formPanel.v("|"+key,value);}
	
	
	
	
    
    	private String jarURL() throws Exception
	{return toString(jarURL.t(data));}
	
	private String classURL() throws Exception
	{return toString(classURL.t(data));}
	
	private String javaURL() throws Exception
	{return toString(javaURL.t(data));}
	
	
	
	
	
		
	private String className()
	{return data.getName();}



	private String superClassName()
	{
		Class cc = data.getSuperclass();
		if(cc==null) return "null";
		return cc.getName();
	}
	

	
	private String classLoaderName()
	{
		ClassLoader cl = data.getClassLoader();
		if(cl==null) return "bootstrap";
		return cl.getClass().getName();
	}	
	
	
	

	
	

	
	
	
	private String findInterfaces()
	{
		Class[] inter = data.getInterfaces();
		StringBuffer b = new StringBuffer();
		for(int i=0;i<inter.length;i++)
		{
			String name = inter[i].getSimpleName();
			b.append(" "+name);
		}
		return b.toString();
	}
	
		
	
	private String toString(Object obj)
	{
		if(obj==null) return "null";
		String s = obj.toString();
		if(s.length()<200) return s;
		return s.substring(0,200)+" ...";
	}
}
