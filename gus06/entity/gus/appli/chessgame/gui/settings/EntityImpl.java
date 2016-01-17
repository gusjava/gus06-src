package gus06.entity.gus.appli.chessgame.gui.settings;

import gus06.framework.*;
import javax.swing.JPanel;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150409";}

	private JPanel panel;

	public EntityImpl() throws Exception
	{
		panel = new JPanel();
	}
	
	
	public Object i() throws Exception
	{return panel;}
}
