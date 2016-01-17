package gus06.entity.gus.file.editor.ext.csv;

import gus06.framework.*;
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class EntityImpl implements Entity, I, P
{
	public String creationDate() {return "20150702";}

	private Service csvParser;
	private Service csvGenerator;
	private Service string2Editor;
	private Service readFile;
	
	private File file;
	private JPanel panel;
	
	
	
	public EntityImpl() throws Exception
	{
		csvParser = Outside.service(this,"gus.file.convert.csv2.parser");
		csvGenerator = Outside.service(this,"gus.file.convert.csv2.generator");
		string2Editor = Outside.service(this,"gus.data.editor.string2.editor1");
		readFile = Outside.service(this,"gus.file.read.string");
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) string2Editor.i(),BorderLayout.CENTER);
	}

	public Object i() throws Exception
	{return panel;}


	

	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		String[][] tab = buildContent();
		
		string2Editor.p(tab);
		string2Editor.v("editable","false");
	}
	
	
	
	
	private String[][] buildContent() throws Exception
	{
		if(file==null || !file.exists()) return new String[0][0];
		String s = (String) readFile.t(file);
		if(s.equals("")) return new String[0][0];
		return (String[][]) csvParser.t(s);
	}
}
