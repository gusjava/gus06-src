package gus06.entity.gus.data.viewer.object;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import java.util.*;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140731";}


	private Service viewerBuilder;
	private Service infoViewer;
	private Service classViewer;
	
	private JTabbedPane tabbedPane;
	private Object data;

	
	public EntityImpl() throws Exception
	{
		viewerBuilder = Outside.service(this,"*gus.data.viewer.object.builder.async");
		infoViewer = Outside.service(this,"*gus.data.viewer.object.panel.info");
		classViewer = Outside.service(this,"*gus.data.viewer.object.panel.class1");
		
		tabbedPane = new JTabbedPane();
	}
	
	
	public Object i() throws Exception
	{return tabbedPane;}
	
	
	public Object g() throws Exception
	{return data;}
	
	
	
	public void p(Object obj) throws Exception
	{
		data = obj;
		Map viewers = (Map) viewerBuilder.t(data);
		
		tabbedPane.removeAll();
		
		if(viewers!=null)
		{
			String title = "VIEWERS ("+viewers.size()+")";
			tabbedPane.addTab(title,viewersTab(viewers));
		}	
		infoViewer.p(data);
		classViewer.p(data);
				
		tabbedPane.addTab("INFOS",(JComponent) infoViewer.i());
		tabbedPane.addTab("CLASS",(JComponent) classViewer.i());
	}
	
	
	
	
	private JTabbedPane viewersTab(Map viewers) throws Exception
	{
		JTabbedPane tab = new JTabbedPane();
		ArrayList keys = new ArrayList(viewers.keySet());
		for(int i=0;i<keys.size();i++)
		{
			String key = (String) keys.get(i);
			I viewer = (I) viewers.get(key);
			tab.addTab(key,(JComponent) viewer.i());
		}
		return tab;
	}
}
