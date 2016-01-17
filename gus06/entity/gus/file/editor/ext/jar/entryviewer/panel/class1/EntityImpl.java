package gus06.entity.gus.file.editor.ext.jar.entryviewer.panel.class1;

import gus06.framework.*;
import javax.swing.JComponent;
import java.io.InputStream;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140809";}

	private Service jdkVersion;
	private Service formPanel;
	
	public EntityImpl() throws Exception
	{
		jdkVersion = Outside.service(this,"gus.file.class1.jdkversion");
		formPanel = Outside.service(this,"*gus.swing.panel.formpanel.map");
	}
	
	
	public Object i() throws Exception
	{return formPanel.i();}
	
	
	
	public void p(Object obj) throws Exception
	{
		InputStream is = (InputStream) obj;
	
		String version = (String) jdkVersion.t(is);
		formPanel.v("JDK version",version);
	}
}
