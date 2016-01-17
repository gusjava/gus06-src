package gus06.entity.gus.file.icon.jar;

import java.io.File;
import javax.swing.Icon;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150615";}

	
	private Icon icon_jar;
	
	public EntityImpl() throws Exception
	{
		icon_jar = (Icon) Outside.resource(this,"icon#FILE_jar");
	}
	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		return icon_jar;
	}
}
