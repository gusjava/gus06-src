package gus06.entity.gus.sys.popup1.gui.panel;

import gus06.framework.*;
import java.util.Map;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.util.List;
import javax.swing.JComponent;

public class EntityImpl implements Entity, P, I {

	public String creationDate() {return "20161005";}

	public static final int GAP = 10;
	public static final Color BACKGROUND = Color.WHITE;


	private Service buildNotif;
	
	private JPanel panel;
	

	public EntityImpl() throws Exception
	{
		buildNotif = Outside.service(this,"gus.sys.popup1.gui.buildnotif");
		
		panel = new JPanel(new GridLayout(0,1,GAP,GAP));
		panel.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));
		panel.setBackground(BACKGROUND);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		List notifs = (List) obj;
		
		panel.removeAll();
		
		for(int i=0;i<notifs.size();i++)
		initNotif((Map) notifs.get(i));
	}
	
	
	private void initNotif(Map notif) throws Exception
	{
		JComponent comp = (JComponent) buildNotif.t(notif);
		panel.add(comp);
	}
}
