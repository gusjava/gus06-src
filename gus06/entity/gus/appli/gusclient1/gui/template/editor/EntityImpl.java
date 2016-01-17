package gus06.entity.gus.appli.gusclient1.gui.template.editor;

import gus06.framework.*;
import javax.swing.JComponent;
import java.io.File;


public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140905";}


	private Service textEditor;
	private Service templateManager;
	
	private String id;
	


	public EntityImpl() throws Exception
	{
		textEditor = Outside.service(this,"*gus.file.editor.ext.txt");
		templateManager = Outside.service(this,"gus.appli.gusclient1.template.manager");
	}
	
	
	public Object i() throws Exception
	{return textEditor.i();}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		id = (String) obj;
		if(id==null) resetGui();
		else updateGui();
	}
	
	
	private void resetGui() throws Exception
	{
		textEditor.p(null);
	}
	
	
	private void updateGui() throws Exception
	{
		File f = (File) templateManager.r("file."+id);
		textEditor.p(f);
	}

}
