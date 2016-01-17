package gus06.entity.gus.file.lnk.create.shortcut2.appjar;

import java.io.File;
import javax.swing.Icon;
import gus06.framework.*;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150607";}


	private Service createShortcut;
	private Service findJar;
	private Service findIco;
	private String name;
	
	
	public EntityImpl() throws Exception
	{
		createShortcut = Outside.service(this,"gus.file.lnk.create.shortcut2");
		findJar = Outside.service(this,"gus.app.jarfile");
		findIco = Outside.service(this,"gus.app.ico");
		name = (String) Outside.resource(this,"property#app.name");
	}
	

	public void p(Object obj) throws Exception
	{
		File lnk = (File) obj;
		
		if(lnk.isDirectory() && name!=null)
		lnk = new File(lnk,name+".lnk");
		
		File jar = (File) findJar.g();
		File ico = (File) findIco.g();
		
		createShortcut.p(new Object[]{jar,lnk,ico});
	}
}
