package gus06.entity.gus.appli.gusclient1.execute.space.documentation.extract.resources;

import gus06.framework.*;
import javax.swing.JOptionPane;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140910";}


	private Service extract;


	public EntityImpl() throws Exception
	{
		extract = Outside.service(this,"gus.app.jarfile.extract1.resources2");
	}
	
	
	public void e() throws Exception
	{
		extract.e();
		JOptionPane.showMessageDialog(null,"Resource extraction is over");
	}
}
