package gus06.entity.gus.sys.webserver1.web2.session.access;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, R, P {

	public String creationDate() {return "20140930";}


	private Service removeDir;
	private Service accessBuilder;
	private Service emptyDir;
	
	private File storeDir;
	
	

	public EntityImpl() throws Exception
	{
		removeDir = Outside.service(this,"gus.dirfile.perform.remove");
		accessBuilder = Outside.service(this,"gus.app.persister1.builder");
		emptyDir = Outside.service(this,"gus.dir.perform.empty");
		
		storeDir = (File) Outside.resource(this,"path#path.web2.dir.sessions");
		if(storeDir.exists()) emptyDir.p(storeDir);
	}
	
	
	
	public synchronized void p(Object obj) throws Exception
	{
		String id = (String) obj;
		File sessionDir = new File(storeDir,id);
		if(sessionDir.exists()) removeDir.p(sessionDir);
	}
	
	
	public synchronized Object r(String key) throws Exception
	{
		File sessionDir = new File(storeDir,key);
		if(!sessionDir.exists()) sessionDir.mkdirs();
		return accessBuilder.t(sessionDir);
	}
}
