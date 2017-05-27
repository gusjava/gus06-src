package gus06.entity.gus.appli.gusexplorer.execute.config.replace;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20160829";}
	
	public static final String MESSAGE = "Please, choose a config name to be replaced:";
	public static final String TITLE = "Config chooser";


	private Service manager;
	private Service chooser;

	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.gusexplorer.config.manager");
		chooser = Outside.service(this,"gus.input.choose.dialog");
	}
	
	
	public void e() throws Exception
	{
		List names = (List) manager.g();
		String name = (String) chooser.t(new Object[]{MESSAGE,TITLE,names});
		if(name==null || name.equals("")) return;
		
		manager.v("save",name);
	}
}
