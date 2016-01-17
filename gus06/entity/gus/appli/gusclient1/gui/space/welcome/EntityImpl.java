package gus06.entity.gus.appli.gusclient1.gui.space.welcome;

import gus06.framework.*;

import javax.swing.JComponent;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140718";}
	
	public static final String ID = "welcome";
	
	
	private Service buildInfoPane;
	private JComponent infoComp;
	
	

	public EntityImpl() throws Exception
	{
		buildInfoPane = Outside.service(this,"gus.appli.gusclient1.gui.space.documentation.build.infopane");
		
		infoComp = (JComponent) buildInfoPane.t(ID);
	}
	
	
	public Object i() throws Exception
	{return infoComp;}
}
