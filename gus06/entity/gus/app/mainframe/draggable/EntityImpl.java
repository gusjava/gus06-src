package gus06.entity.gus.app.mainframe.draggable;

import gus06.framework.*;
import javax.swing.JFrame;

public class EntityImpl implements Entity {

	public String creationDate() {return "20160505";}


	private Service dragframe;

	public EntityImpl() throws Exception
	{
		dragframe = Outside.service(this,"gus.swing.comp.cust.dragframe");
		
		JFrame frame = (JFrame) Outside.resource(this,"mainframe");
		dragframe.p(frame);
	}
}
