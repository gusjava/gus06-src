package gus06.entity.gus.app.execute.fullscreen;

import javax.swing.JFrame;
import gus06.framework.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20151015";}


	private Service fullScreen;
	private JFrame mainFrame;
	
	
	public EntityImpl() throws Exception
	{
		fullScreen = Outside.service(this,"gus.awt.fullscreen");
		mainFrame = (JFrame) Outside.resource(this,"mainframe");
	}

	
	public void e() throws Exception
	{
		fullScreen.p(mainFrame.getContentPane());
	}
}
