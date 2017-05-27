package gus06.entity.gus.file.op.empty;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150606";}


	public void p(Object obj) throws Exception
	{
		File file = (File) obj;
		
		boolean r = file.delete();
		if(!r) throw new Exception("Failed to delete file: "+file);
		
		r = file.createNewFile();
		if(!r) throw new Exception("Failed to create empty file: "+file);
	}
}
