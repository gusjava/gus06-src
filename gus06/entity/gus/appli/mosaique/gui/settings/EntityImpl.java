package gus06.entity.gus.appli.mosaique.gui.settings;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20141123";}
	


	private Service form;
	private Service paramNumber;
	
	private JPanel panel;
	
	
	
	public EntityImpl() throws Exception
	{
		form = Outside.service(this,"*gus.swing.panel.formpanel");
		paramNumber = Outside.service(this,"gus.appli.mosaique.parameter.number");
		
		form.v("Taille de la grille",left((JComponent) paramNumber.i()));
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) form.i(),BorderLayout.CENTER);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	private JPanel left(JComponent c)
	{
		JPanel p = new JPanel(new BorderLayout());
		p.add(c,BorderLayout.WEST);
		return p;
	}
}
