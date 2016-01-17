package gus06.entity.gus.data.viewer.object.panel.info;

import gus06.framework.*;
import javax.swing.JComponent;


public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140731";}

	private Service formPanel;
	
 	private Object data;

	public EntityImpl() throws Exception
	{formPanel = Outside.service(this,"*gus.swing.panel.formpanel.map");}
	
	
	public Object g() throws Exception
	{return data;}
	
	
	public Object i() throws Exception
	{return formPanel.i();}
	
	
	public void p(Object obj) throws Exception
	{
		data = obj;
		if(data==null) resetGui();
		else updateGui();
	}
		
		
		
		
		
	private void resetGui() throws Exception
	{formPanel.e();}
    
    
	
	private void updateGui() throws Exception
	{
		formPanel.v("class name",className(data));
		formPanel.v("toString",toString(data));
		formPanel.v("hashCode",hashCode(data));
	}
    



	private String className(Object obj)
	{
		if(obj==null) return "null";
		return obj.getClass().getName();
	}	
	
	private String toString(Object obj)
	{
		if(obj==null) return "null";
		String s = obj.toString();
		if(s.length()<200) return s;
		return s.substring(0,200)+" ...";
	}
		
	private String hashCode(Object obj)
	{
		if(obj==null) return "null";
		return ""+obj.hashCode();
	}
}
