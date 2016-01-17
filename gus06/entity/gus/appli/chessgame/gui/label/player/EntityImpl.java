package gus06.entity.gus.appli.chessgame.gui.label.player;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20150410";}


	private Service manager;

	private JLabel label;

	

	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.chessgame.manager");
		
		label = new JLabel(" ");
		
		manager.addActionListener(this);
		updateGui();
	}
	
	
	public Object i() throws Exception
	{return label;}


	public void actionPerformed(ActionEvent e)
	{updateGui();}
	
	
	private void updateGui()
	{
		try
		{
			String player = (String) manager.r("player");
			label.setText("Current player: "+player);
		}
		catch(Exception e)
		{Outside.err(this,"updateGui()",e);}
	}

}
