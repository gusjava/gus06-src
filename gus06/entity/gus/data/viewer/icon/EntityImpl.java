package gus06.entity.gus.data.viewer.icon;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.Icon;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140731";}


	private Icon data;
	private JLabel label;

	public EntityImpl() throws Exception
	{label = new JLabel(" ");}
	
	
	public Object g() throws Exception
	{return data;}
	
	
	public Object i() throws Exception
	{return label;}
	
	
	public void p(Object obj) throws Exception
	{
		data = (Icon) obj;
		label.setIcon(data);
	}
}
