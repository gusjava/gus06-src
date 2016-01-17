package gus06.entity.gus.appli.laboscript.gui.scriptgui;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20160101";}
	
	public static final String FILENAME = "script.gus";


	private Service editor;
	private File storeDir;
	private File scriptFile;


	public EntityImpl() throws Exception
	{
		editor = Outside.service(this,"*gus.file.editor.ext.gus");
		storeDir = (File) Outside.resource(this,"defaultdir");
		scriptFile = new File(storeDir,FILENAME);
		
		storeDir.mkdirs();
		editor.p(scriptFile);
	}
	
	public Object i() throws Exception
	{return editor.i();}
}
