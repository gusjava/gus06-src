package gus06.entity.gus.data.viewer.f;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140731";}


	private F data;

	public EntityImpl() throws Exception
	{
	}
	
	
	public Object g() throws Exception
	{return data;}
	
	
	public Object i() throws Exception
	{return new JPanel();}
	
	
	public void p(Object obj) throws Exception
	{
		data = (F) obj;
	}
}
