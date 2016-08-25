package gus06.entity.gus.app.mainframe.undecorated;

import gus06.framework.*;
import javax.swing.JFrame;

public class EntityImpl implements Entity {

	public String creationDate() {return "20160505";}


	
	public EntityImpl() throws Exception
	{
		JFrame frame = (JFrame) Outside.resource(this,"mainframe");
		frame.setUndecorated(true);
	}
	
}
