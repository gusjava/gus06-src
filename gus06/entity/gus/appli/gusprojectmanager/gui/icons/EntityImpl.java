package gus06.entity.gus.appli.gusprojectmanager.gui.icons;

import gus06.framework.*;
import javax.swing.JComponent;
import java.io.File;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20150614";}

	public static final String KEY = "icondir";
	

	private Service getFile;
	private Service viewer;
	private File dir;
	

	public EntityImpl() throws Exception
	{
		getFile = Outside.service(this,"gus.sys.option.getfile");
		viewer = Outside.service(this,"*gus.dir.explorer.resource2.icon");
		
		dir = (File) getFile.r(KEY);
		viewer.p(dir);
	}
	
	
	public Object i() throws Exception
	{return viewer.i();}
}
