package gus06.entity.gus.nnn.data.viewer.object.panel.src;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140804";}


	private Service srcPanel;


	public EntityImpl() throws Exception
	{srcPanel = Outside.service(this,"*gus.data.viewer.class1.panel.src");}
	
	
	public Object g() throws Exception
	{return srcPanel.g();}
	
	
	public Object i() throws Exception
	{return srcPanel.i();}
	
	
	public void p(Object obj) throws Exception
	{srcPanel.p(obj==null?null:obj.getClass());}
}
