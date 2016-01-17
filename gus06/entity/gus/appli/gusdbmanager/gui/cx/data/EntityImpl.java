package gus06.entity.gus.appli.gusdbmanager.gui.cx.data;

import gus06.framework.*;
import javax.swing.JPanel;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150613";}


	public EntityImpl() throws Exception
	{
	}
	
	
	public Object t(Object obj) throws Exception
	{
		return new JPanel();
	}
}
