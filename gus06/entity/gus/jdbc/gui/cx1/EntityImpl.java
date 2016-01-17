package gus06.entity.gus.jdbc.gui.cx1;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20150622";}


	private Service db;
	private Service bar;

	
	private JPanel panel;
	
	

	public EntityImpl() throws Exception
	{
		db = Outside.service(this,"*gus.jdbc.gui.cx1.db");
		bar = Outside.service(this,"*gus.jdbc.gui.cx1.bar");
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) db.i(),BorderLayout.CENTER);
		panel.add((JComponent) bar.i(),BorderLayout.SOUTH);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		db.p(obj);
		bar.p(obj);
	}
}
