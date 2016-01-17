package gus06.entity.gus.appli.gusclient1.gui.direxplorer.resource;

import java.io.File;
import javax.swing.JComponent;
import gus06.framework.*;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140730";}

	private Service explorer;
	private File dir;
	
	
	public EntityImpl() throws Exception
	{
		explorer = Outside.service(this,"*gus.dir.explorer.resource.dir1");
		dir = (File) Outside.resource(this,"path#path.dev.resourcedir2");

		if(!dir.exists()) dir.mkdirs();
		explorer.p(dir);
	}
	
	public Object i() throws Exception
	{return explorer.i();}
}
