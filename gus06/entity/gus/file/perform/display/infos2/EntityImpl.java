package gus06.entity.gus.file.perform.display.infos2;

import gus06.framework.*;
import java.io.File;
import javax.swing.JOptionPane;
import java.util.Map;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151004";}


	private Service viewer;
	private Service dialog;
	
	public EntityImpl() throws Exception
	{
		viewer = Outside.service(this,"*gus.file.viewer.infos2");
		dialog = Outside.service(this,"gus.swing.dialog.blocked1.close");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File file = (File) obj;
		if(!file.isFile()) throw new Exception("Invalid file: "+file);
		
		viewer.p(file);
		dialog.p(viewer.i());
	}
}
