package gus06.entity.gus.file.editor.ext.tool;

import gus06.framework.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.util.List;
import java.util.HashMap;


public class EntityImpl implements Entity, I, P, G, ActionListener {

	public String creationDate() {return "20141229";}
	
	
	public static final String PATH_THIS = "path.this";
	public static final String PATH_PARENT = "path.parent";


	private Service readFile;
	private Service writeFile;
	private Service tabHolder;
	private Service gui1;
	private Service gui2;
	
	private JPanel panel;
	
	private File file;
	private Map map;
	


	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.properties");
		writeFile = Outside.service(this,"gus.file.write.properties");
		
		tabHolder = Outside.service(this,"*gus.swing.tabbedpane.holder1");
		gui1 = Outside.service(this,"*gus.sys.filetool.main.gui");
		gui2 = Outside.service(this,"*gus.file.editor.ext.properties.gui");
		
		map = (Map) Outside.resource(this,"supportmap");
		addActionListener();
		
		gui2.p(map);
		
		tabHolder.v("Tool",gui1.i());
		tabHolder.v("Properties",gui2.i());
	}
	
	
	
	public Object i() throws Exception
	{return tabHolder.i();}
	
	
	public Object g() throws Exception
	{return file;}
	
	
	
	public void p(Object obj) throws Exception
	{
		file = (File) obj;
		if(file==null) resetMap();
		else updateMap();
	}
	
	
	
	private void resetMap() throws Exception
	{
		removeActionListener();
		map.clear();
		addActionListener();
		
		gui1.p(null);
	}
	
	
	
	
	
	private void updateMap() throws Exception
	{
		Map m = readFile();
		if(m==null) m = new HashMap();
		
		m.put(PATH_THIS,file.getAbsolutePath());
		m.put(PATH_PARENT,file.getParentFile().getAbsolutePath());
		
		removeActionListener();
		map.clear();
		map.putAll(m);
		addActionListener();
		
		gui1.p(map);
	}
	
	
	
	
	private void addActionListener()
	{((S) map).addActionListener(this);}
	
	private void removeActionListener()
	{((S) map).removeActionListener(this);}
	
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{if(file!=null) writeFile();}
	
	
	
	private Map readFile() throws Exception
	{return (Map) readFile.t(file);}

	
	
	private void writeFile()
	{
		try
		{writeFile.p(new Object[]{file,map});}
		catch(Exception e)
		{Outside.err(this,"writeFile()",e);}
	}
}
