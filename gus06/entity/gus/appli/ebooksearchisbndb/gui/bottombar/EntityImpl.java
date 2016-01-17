package gus06.entity.gus.appli.ebooksearchisbndb.gui.bottombar;

import gus06.framework.*;
import javax.swing.JPanel;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150509";}

	private JPanel panel;

	public EntityImpl() throws Exception
	{
		panel = new JPanel();
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
