package gus06.entity.gus.appli.gusclient1.execute.showconsole;

import gus06.framework.*;
import javax.swing.*;

public class EntityImpl implements Entity, E {

	public String creationDate() {return "20140803";}

	public static final String DISPLAY = "GUI_console#Console";


	private Service consoleGui;
	private Service custFrame;
	private Service getPseudo;
	
	private JFrame frame;
	

	public EntityImpl() throws Exception
	{
		consoleGui = Outside.service(this,"*gus.appli.gusclient1.gui.console");
		custFrame = Outside.service(this,"gus.swing.frame.cust2.display");
		getPseudo = Outside.service(this,"gus.entitydev.pseudo.find");
		
		frame = new JFrame();
		custFrame.v(display(),frame);
		
		JComponent comp = (JComponent) consoleGui.i();
		if(comp instanceof Scrollable)
			comp = new JScrollPane(comp);
		
		frame.setContentPane(comp);
		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
	}
	
	
	
	public void e() throws Exception
	{
		frame.setVisible(true);
	}
	
	
	
	private String display() throws Exception
	{
		String pseudo = (String) getPseudo.g();
		if(pseudo==null) return DISPLAY;
		return DISPLAY+" "+pseudo;
	}
}
