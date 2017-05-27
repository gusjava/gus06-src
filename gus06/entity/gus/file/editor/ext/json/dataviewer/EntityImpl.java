package gus06.entity.gus.file.editor.ext.json.dataviewer;

import java.awt.BorderLayout;
import java.io.File;
import gus06.framework.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.ActionListener;
import java.util.Map;


public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20170308";}

	
	private Service jsonParser;
	private Service readFile;
	private Service objViewer;
	
	private File file;
	private Map data;
	

	public EntityImpl() throws Exception
	{
		jsonParser = Outside.service(this,"gus.sys.jsonparser1.evaluate");
		readFile = Outside.service(this,"gus.file.read.string.autodetect");
		objViewer = Outside.service(this,"*gus.data.viewer.object");
	}
	
	
	public Object i() throws Exception
	{return objViewer.i();}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		String s = (String) readFile.t(file);
		data = (Map) jsonParser.t(s);
		
		objViewer.p(data);
	}
}
