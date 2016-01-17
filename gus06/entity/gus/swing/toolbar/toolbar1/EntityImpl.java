package gus06.entity.gus.swing.toolbar.toolbar1;

import javax.swing.JComponent;
import gus06.framework.*;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150625";}
	
	
	public Object i() throws Exception
	{return new JToolBar1();}
}