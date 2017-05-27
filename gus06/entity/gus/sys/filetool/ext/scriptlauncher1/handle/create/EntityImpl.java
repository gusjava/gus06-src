package gus06.entity.gus.sys.filetool.ext.scriptlauncher1.handle.create;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161119";}


	private Service askInput;

	public EntityImpl() throws Exception
	{
		askInput = Outside.service(this,"gus.input.text.dialog");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File root = (File) o[0];
		String scriptName = (String) o[1];
		
		String newKey = (String) askInput.t("Please, enter script name:");
		if(newKey==null) return null;
		
		initScript(root,newKey,scriptName);
		return newKey;
	}
	
	
	
	private void initScript(File root, String newKey, String scriptName) throws Exception
	{
		File dir = new File(root,newKey.replace(".",File.separator));
		dir.mkdirs();
		
		File file = new File(dir,scriptName);
		file.createNewFile();
	}
}
