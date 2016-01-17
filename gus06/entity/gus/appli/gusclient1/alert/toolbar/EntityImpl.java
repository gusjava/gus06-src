package gus06.entity.gus.appli.gusclient1.alert.toolbar;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EntityImpl implements Entity, I, ActionListener {

	public String creationDate() {return "20140808";}


	private Service clearOnClick;
	private Service alertManager;

	private JLabel label;

	public EntityImpl() throws Exception
	{
		alertManager = Outside.service(this,"gus.appli.gusclient1.alert.manager");
		clearOnClick = Outside.service(this,"gus.swing.label.cust.onclick.clear");
		
		label = new JLabel(" ");
		clearOnClick.p(label);
	
		alertManager.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return label;}
	
	
	
		
	public void actionPerformed(ActionEvent e)
	{displayAlert();}
	
	
	private void displayAlert()
	{
		try
		{
			String name = (String) alertManager.r("name");
			Object src = alertManager.r("src");
		
			label.setText(name);
		}
		catch(Exception e)
		{Outside.err(this,"displayAlert()",e);}
	}
}
