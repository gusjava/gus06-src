package gus06.entity.gus.jdbc.gui.cx1.db;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl implements Entity, ActionListener, I, P {

	public String creationDate() {return "20150622";}
	
	public static final int POSITION = 300;


	private Service list;
	private Service table;

	private JSplitPane split;
	
	private G holder;
	
	
	public EntityImpl() throws Exception
	{
		list = Outside.service(this,"*gus.jdbc.gui.cx1.db.list");
		table = Outside.service(this,"*gus.jdbc.gui.cx1.db.table");
		
		split = new JSplitPane();
		split.setDividerSize(3);
		split.setDividerLocation(POSITION);

		split.setLeftComponent((JComponent) list.i());
		split.setRightComponent((JComponent) table.i());
		
		list.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return split;}
	
	
	public void p(Object obj) throws Exception
	{
		holder = (G) obj;
		
		list.p(holder);
		table.p(null);
	}


	public void actionPerformed(ActionEvent e)
	{selectionChanged();}
	
	
	
	
	private void selectionChanged()
	{
		try
		{
			String selected = (String) list.g();
			
			if(selected!=null)
			table.p(new Object[]{holder,selected});
			else table.p(null);
		}
		catch(Exception e)
		{Outside.err(this,"selectionChanged()",e);}
	}
}
