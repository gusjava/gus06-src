package gus06.entity.gus.dirfile.perform.display.infos2;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151004";}


	private Service handleFile;
	private Service handleDir;


	public EntityImpl() throws Exception
	{
		handleFile = Outside.service(this,"gus.file.perform.display.infos2");
		handleDir = Outside.service(this,"gus.dir.perform.display.infos2");
	}
	
	
	public void p(Object obj) throws Exception
	{
		File f = (File) obj;
		if(f.isFile()) handleFile.p(f);
		else handleDir.p(f);
	}
}
