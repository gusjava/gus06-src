package gus06.entity.gus.sys.filetool.ext.library1.holder;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.HashSet;
import java.io.File;
import javax.swing.JList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class EntityImpl implements Entity, ActionListener, I, P, G {

	public String creationDate() {return "20160914";}

	public static final String STRUCT = "struct";
	public static final String DISPLAY = "display";
	public static final String CONTENT = "content";
	public static final String DIVIDERLOC = "dividerloc";
	

	private Service listHolder;
	private Service editorHolder;
	private Service renderList;
	private Service custSplit;
	private Service dnd;


	
	private JSplitPane split;
	
	private List keys;
	private Map files;
	
	private Map map;
	


	public EntityImpl() throws Exception
	{
		listHolder = Outside.service(this,"*gus.swing.list.holder.collection");
		editorHolder = Outside.service(this,"*gus.file.editor.main");
		renderList = Outside.service(this,"gus.swing.list.cust.renderer.display");
		custSplit = Outside.service(this,"gus.swing.splitpane.cust.cust1");
		dnd = Outside.service(this,"gus.awt.dnd");
		
		JList list = (JList) listHolder.i();
		JComponent editorComp = (JComponent) editorHolder.i();
		
		renderList.p(list);
		
		dnd.v("g",this);
		dnd.v("p",null);
		dnd.p(list);
		
		split = new JSplitPane();
		custSplit.p(split);
		
		split.setRightComponent(editorComp);
		split.setLeftComponent(new JScrollPane(list));
		
		listHolder.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return split;}
	
	
	
	
	
	
	
	public void p(Object obj) throws Exception
	{
		map = (Map) obj;
		
		keys = new ArrayList();
		files = new HashMap();
		
		String struct = get0(STRUCT);
		if(struct!=null)
		{
			String[] nn = struct.split(";");
			for(String n:nn)
			{
				String display = get1(DISPLAY+"."+n);
				String path = get1(CONTENT+"."+n);
				File file = new File(path);
				
				keys.add(display);
				files.put(display,file);
			}
		}
		
		String dividerloc = get0(DIVIDERLOC);
		if(dividerloc!=null)
		{
			int loc = Integer.parseInt(dividerloc);
			split.setDividerLocation(loc);
		}
		
		listHolder.p(keys);
	}
	
	
	
	public Object g() throws Exception
	{
		return selectedFile();
	}
	
	
	private String get0(String key) throws Exception
	{
		if(map==null) throw new Exception("Map not initialized yet");
		if(!map.containsKey(key)) return null;
		return (String) map.get(key);
	}
	
	private String get1(String key) throws Exception
	{
		if(map==null) throw new Exception("Map not initialized yet");
		if(!map.containsKey(key)) throw new Exception("Key not found inside tool: "+key);
		return (String) map.get(key);
	}


	public void actionPerformed(ActionEvent e)
	{updateView();}
	
	
	
	private void updateView()
	{
		try
		{
			File file = selectedFile();
			editorHolder.p(file);
		}
		catch(Exception e)
		{Outside.err(this,"updateView()",e);}
	}


	private File selectedFile() throws Exception
	{
		String key = (String) listHolder.g();
		if(key==null) return null;
		return (File) files.get(key);
	}
}
