package gus06.entity.gus.file.editor.ext.jar.entryviewer.panel;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, I, V {

	public String creationDate() {return "20140807";}

	private Service shiftPanel;
	
	private Service panelJava;
	private Service panelClass;
	private Service panelGif;
	private Service panelDefault;
	

	public EntityImpl() throws Exception
	{
		shiftPanel = Outside.service(this,"*gus.swing.panel.shiftpanel");
	
		panelJava = Outside.service(this,"*gus.file.editor.ext.jar.entryviewer.panel.java");
		panelClass = Outside.service(this,"*gus.file.editor.ext.jar.entryviewer.panel.class1");
		panelGif = Outside.service(this,"*gus.file.editor.ext.jar.entryviewer.panel.gif");
		panelDefault = Outside.service(this,"*gus.file.editor.ext.jar.entryviewer.panel.default1");
	}
	
	
	public Object i() throws Exception
	{return shiftPanel.i();}
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key==null) {resetGui();return;}
		
		Service s = findService(key);
		s.p(obj);
		shiftPanel.p(s);
	}
	
	
	private void resetGui() throws Exception
	{shiftPanel.p(null);}
	
	
	private Service findService(String key)
	{
		if(key.equals("java")) return panelJava;
		if(key.equals("class")) return panelClass;
		if(key.equals("gif")) return panelGif;
		if(key.equals("png")) return panelGif;
		
		return panelDefault;
	}
}
