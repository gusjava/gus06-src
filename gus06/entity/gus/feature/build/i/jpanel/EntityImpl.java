package gus06.entity.gus.feature.build.i.jpanel;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class EntityImpl implements Entity, G, I {

	public String creationDate() {return "20150708";}


	public Object g() throws Exception
	{return this;}
	
	public Object i() throws Exception
	{return new JPanel();}
}
