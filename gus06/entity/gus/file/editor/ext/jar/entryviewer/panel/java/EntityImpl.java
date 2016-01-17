package gus06.entity.gus.file.editor.ext.jar.entryviewer.panel.java;

import gus06.framework.*;
import javax.swing.JComponent;
import java.io.InputStream;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140809";}


	private Service isToString;
	private Service srcViewer;


	public EntityImpl() throws Exception
	{
		isToString = Outside.service(this,"gus.io.transfer.tostring");
		srcViewer = Outside.service(this,"*gus.data.viewer.string.src.java");
	}
	
	
	public Object i() throws Exception
	{return srcViewer.i();}
	
	
	
	public void p(Object obj) throws Exception
	{
		InputStream is = (InputStream) obj;
		String src = (String) isToString.t(is);
		srcViewer.p(src);
	}
}
