package gus06.entity.gus.file.editor.ext.jar.entryviewer.panel.default1;

import gus06.framework.*;
import javax.swing.JComponent;
import java.io.InputStream;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140809";}


	private Service isToString;
	private Service stringViewer;
	
	public EntityImpl() throws Exception
	{
		isToString = Outside.service(this,"gus.io.transfer.tostring");
		stringViewer = Outside.service(this,"*gus.data.viewer.string");
	}
	
	
	public Object i() throws Exception
	{return stringViewer.i();}
	
	
	public void p(Object obj) throws Exception
	{
		InputStream is = (InputStream) obj;
		String text = (String) isToString.t(is);
		stringViewer.p(text);
	}
}
