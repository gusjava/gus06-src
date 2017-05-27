package gus06.entity.gus.sys.filetool.ext.scriptlauncher1.handle.remove;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20161119";}


	private Service confirm;
	private Service perform;

	public EntityImpl() throws Exception
	{
		confirm = Outside.service(this,"gus.input.confirm.dialog");
		perform = Outside.service(this,"gus.dir.perform.removefiles0.clear");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File root = (File) o[0];
		String key = (String) o[1];
		
		boolean ok = confirm.f("Confirmez s'il vous plait la suppression du script:\n"+key);
		if(!ok) return false;
		
		File dir = new File(root,key.replace(".",File.separator));
		perform.p(dir);
		
		return true;
	}
}
