package gus06.entity.gus.app.setting.prop;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20170516";}


	private Service editor;
	private File appFile;


	public EntityImpl() throws Exception
	{
		editor = Outside.service(this,"*gus.file.editor.ext.properties");
		appFile = (File) Outside.resource(this,"appfile");
		
		if(!appFile.exists()) appFile.createNewFile();
		editor.p(appFile);
	}
	
	
	public Object i() throws Exception
	{return editor.i();}
}
