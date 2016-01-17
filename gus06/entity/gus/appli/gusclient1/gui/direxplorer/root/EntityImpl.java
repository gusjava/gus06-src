package gus06.entity.gus.appli.gusclient1.gui.direxplorer.root;

import java.io.File;
import javax.swing.JComponent;
import gus06.framework.*;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140723";}

	private Service explorer;
	private File dir;
	
	
	public EntityImpl() throws Exception
	{
		explorer = Outside.service(this,"*gus.dir.explorer.simple");
		dir = (File) Outside.resource(this,"path#path.rootdir");

		if(!dir.exists()) dir.mkdirs();
		explorer.p(dir);
	}
	
	public Object i() throws Exception
	{return explorer.i();}
}
