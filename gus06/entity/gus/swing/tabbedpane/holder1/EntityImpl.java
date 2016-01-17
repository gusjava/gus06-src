package gus06.entity.gus.swing.tabbedpane.holder1;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.Icon;


public class EntityImpl implements Entity, I, V {

	public String creationDate() {return "20140730";}


	private Service iconProvider;

	private JTabbedPane comp;
	
	
	public EntityImpl() throws Exception
	{
		iconProvider = Outside.service(this,"gus.icon.provider");
		comp = new JTabbedPane();
	}
	
	
	public Object i() throws Exception
	{return comp;}
	
	
	private Icon icon(String id) throws Exception
	{return (Icon) iconProvider.t(id);}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		JComponent c = (JComponent) obj;
		if(!key.contains("#")) {comp.addTab(key,c);return;}
		
		String[] n = key.split("#",2);
		comp.addTab(n[1],icon(n[0]),c);
	}
}
