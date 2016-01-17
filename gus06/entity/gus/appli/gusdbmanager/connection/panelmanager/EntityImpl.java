package gus06.entity.gus.appli.gusdbmanager.connection.panelmanager;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import gus06.framework.*;

public class EntityImpl implements Entity, T, F {

	public String creationDate() {return "20150613";}

	
	private Service cxManager;
	private Service buildPanel;
	
	private Map panel_holder;
	private Map holder_panel;
	
	
	
	public EntityImpl() throws Exception
	{
		cxManager = Outside.service(this,"gus.appli.gusdbmanager.connection.manager");
		buildPanel = Outside.service(this,"gus.appli.gusdbmanager.gui.cx");
		
		panel_holder = new HashMap();
		holder_panel = new HashMap();
	}

	
	
	
	public Object t(Object obj) throws Exception
	{
		if(panel_holder.containsKey(obj))
			return panel_holder.get(obj);
			
		Object holder = toHolder(obj);
		if(!holder_panel.containsKey(holder))
		{
			Object panel = buildPanel.t(holder);
			holder_panel.put(holder,panel);
			panel_holder.put(panel,holder);
		}
		return holder_panel.get(holder);
	}
	
	
	
	private Object toHolder(Object obj) throws Exception
	{
		if(obj instanceof String)
			return cxManager.r((String) obj);
		if(obj instanceof G) return obj;
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	
	public boolean f(Object obj) throws Exception
	{
		Object holder = panel_holder.get(obj);
		if(!connected(holder)) return true;
		
		String closeMessage = findCloseMessage(holder);
		int r = JOptionPane.showConfirmDialog(null,closeMessage);
		return r==JOptionPane.YES_OPTION;
	}
	
	
	private String findCloseMessage(Object holder) throws Exception
	{
		String[] n = display(holder).split("#",2);
		return "Close connection tab ?\n"+n[n.length-1];
	}
	
	
	
	private boolean connected(Object holder) throws Exception
	{return ((F) holder).f(null);}
	
	private String display(Object holder) throws Exception
	{return (String) ((R) holder).r("display");}
}
