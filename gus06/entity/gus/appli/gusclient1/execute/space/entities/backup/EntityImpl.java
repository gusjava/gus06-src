package gus06.entity.gus.appli.gusclient1.execute.space.entities.backup;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20150917";}


	
	private File backupDir;
	private File entityDir;

	
	public EntityImpl() throws Exception
	{
		backupDir = (File) Outside.resource(this,"entitybackupdir");
		entityDir = (File) Outside.resource(this,"entitysrcdir");
	}
	
	public void e() throws Exception
	{
		// backup all entities from entityDir to backupDir ...
	}
}
