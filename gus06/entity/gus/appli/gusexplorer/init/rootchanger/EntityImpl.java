package gus06.entity.gus.appli.gusexplorer.init.rootchanger;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151003";}


	private Service performChangeRoot;
	private Service manager;


	public EntityImpl() throws Exception
	{
		performChangeRoot = Outside.service(this,"gus.swing.tree.perform.file.changeroot");
		manager = Outside.service(this,"gus.appli.gusexplorer.data.manager");
		
		performChangeRoot.v("rootChanger",this);
	}
	
	
	public void p(Object obj) throws Exception
	{
		File[] f = (File[]) obj;
		if(f.length!=2) throw new Exception("Wrong number: "+f.length);
		
		manager.v("modify",f);
	}
}
