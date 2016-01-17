package gus06.entity.gus.awt.desktop.print;

import gus06.framework.*;
import java.awt.Desktop;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151010";}


	private Service toFile;

	public EntityImpl() throws Exception
	{toFile = Outside.service(this,"gus.find.file");}	
	
	
	public void p(Object obj) throws Exception
	{
		if(!Desktop.isDesktopSupported())
			throw new Exception("Could not use command browse: desktop not supported");
		if(!Desktop.getDesktop().isSupported(Desktop.Action.PRINT))
			throw new Exception("Could not use command print: desktop OPEN action not supported");

		File file = (File) toFile.t(obj);
		Desktop.getDesktop().print(file);
	}
}
