package gus06.entity.gus.appli.gusexplorer.gui.tabbedpane.filetoholder;

import java.io.File;
import gus06.framework.*;
import javax.swing.JComponent;
import java.util.Map;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141211";}


	private Service build;
	private Service fileToName;
	private Service shiftPanelFactory;
	
	
	public EntityImpl() throws Exception
	{
		build = Outside.service(this,"gus.sys.async.guibuilder.dataholder");
		fileToName = Outside.service(this,"gus.file.editor.main.filetoname");
		shiftPanelFactory = Outside.service(this,"factory#gus.swing.panel.shiftpanel");
	}
	
	
	
	public Object t(Object obj) throws Exception
	{return new Holder((File) obj);}
	
	private Object build(String name, Object data) throws Exception
	{return build.t(new Object[]{name,data});}
	
	private String name(File file) throws Exception
	{return (String) fileToName.t(file);}
	
	private I newGuiHolder() throws Exception
	{return (I) shiftPanelFactory.g();}
	
	
	
	
	
	
	private class Holder implements I, G, P
	{
		private Map map;
		private String name;
		private Object editor;
		private I guiHolder;
		
		public Holder(File file) throws Exception
		{
			name = name(file);
			editor = build(name,file);
			guiHolder = newGuiHolder();
			
			map = new HashMap();
			map.put(name,editor);
			
			putFile(file);
			updateGui();
		}
		
		
		public void p(Object obj) throws Exception
		{
			File file = (File) obj;
			String name0 = name(file);
			
			if(equals(name,name0)) putFile(file);
			else editorChanged(name0,file);
		}
		
		
		private boolean equals(Object o1, Object o2)
		{
			if(o1==null && o2==null) return true;
			if(o1==null || o2==null) return false;
			return o1.equals(o2);
		}
		
		
		
		private void editorChanged(String name0, File file) throws Exception
		{
			name = name0;
			putFile(null);
			
			if(name!=null && !map.containsKey(name))
			{
				editor = build(name,file);
				map.put(name,editor);
			}
			else editor = findEditor();
				
			putFile(file);
			updateGui();
		}
		
		
		private Object findEditor()
		{
			if(name==null) return null;
			return map.get(name);
		}
		
		
		private void putFile(File file) throws Exception
		{if(editor!=null) ((P)editor).p(file);}
		
		
		private void updateGui() throws Exception
		{
			Object comp = editor!=null?((I)editor).i():null;
			((P)guiHolder).p(comp);
		}
		
		
		public Object g() throws Exception
		{return ((G)editor).g();}
		
		public Object i() throws Exception
		{return guiHolder.i();}
	}
}
