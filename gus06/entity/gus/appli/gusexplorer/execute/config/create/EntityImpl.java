package gus06.entity.gus.appli.gusexplorer.execute.config.create;

import gus06.framework.*;
import javax.swing.JOptionPane;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20160420";}


	private Service manager;

	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.config.manager");
	}
	
	
	public void e() throws Exception
	{
		String name = input();
		if(name==null || name.equals("")) return;
		
		manager.v("save",name);
	}
	
	private String input()
	{
		String title = "Config's name:";
		return JOptionPane.showInputDialog(null,"",title,JOptionPane.PLAIN_MESSAGE);
	}
}
