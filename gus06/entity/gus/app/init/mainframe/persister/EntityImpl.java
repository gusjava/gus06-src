package gus06.entity.gus.app.init.mainframe.persister;

import gus06.framework.*;
import javax.swing.JFrame;


public class EntityImpl implements Entity {

	public String creationDate() {return "20140912";}

	public static final String PERSIST_KEY = "mainframe.bounds";

	private Service persistFrame;
	
	private JFrame frame;
	


	public EntityImpl() throws Exception
	{
		persistFrame = Outside.service(this,"gus.swing.frame.persister.bounds");
		
		frame = (JFrame) Outside.resource(this,"mainframe");
		persistFrame.v(PERSIST_KEY,frame);
	}
}
