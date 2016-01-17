package gus06.entity.gus.appli.entityhistory.map.holder;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl extends S1 implements Entity, P, G {

	public String creationDate() {return "20150430";}

	public static final String FILENAME = "entitydates.properties";


	private Service readFile;
	private Service writeFile;
	
	private Map map;
	
	private File storeDir;
	private File propFile;
	

	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.properties");
		writeFile = Outside.service(this,"gus.file.write.properties");
		
		storeDir = (File) Outside.resource(this,"defaultdir");
		propFile = new File(storeDir,FILENAME);
		
		if(propFile.exists())
		map = (Map) readFile.t(propFile);
	}
	
	
	public Object g() throws Exception
	{return map;}
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		writeFile.p(new Object[]{propFile,map});
		mapModified();
	}
	
	
	
	private void mapModified()
	{send(this,"mapModified()");}
}
