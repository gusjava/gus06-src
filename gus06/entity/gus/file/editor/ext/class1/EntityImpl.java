package gus06.entity.gus.file.editor.ext.class1;

import gus06.framework.*;
import java.io.File;
import javax.swing.JComponent;


public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140807";}

	
	private Service jdkVersion;
	private Service formPanel;
	
	private File file;
	


	public EntityImpl() throws Exception
	{
		jdkVersion = Outside.service(this,"gus.file.class1.jdkversion");
		formPanel = Outside.service(this,"*gus.swing.panel.formpanel.map");
	}
	
	
	public Object i() throws Exception
	{return formPanel.i();}
	
	
	
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		if(file==null) {resetGui();return;}
		
		String version = (String) jdkVersion.t(file);
		formPanel.v("JDK version",version);
	}
	
	
	
	private void resetGui() throws Exception
	{formPanel.e();}
}