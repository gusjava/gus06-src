package gus06.entity.gus.appli.chessgame.gui.label.state;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20150412";}


	private Service manager;

	private JLabel label;

	

	public EntityImpl() throws Exception
	{
		manager = Outside.service(this,"gus.appli.chessgame.manager");
		
		label = new JLabel(" ");
		label.setFont(label.getFont().deriveFont(Font.BOLD));
		
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
			String state = (String) manager.r("state");
			if(state.equals("check"))
			{
				label.setText("Check");
				label.setForeground(Color.ORANGE);
			}
			else if(state.equals("mate"))
			{
				label.setText("Checkmate");
				label.setForeground(Color.RED);
			}
			else
			{
				label.setText(" ");	
			}
		}
		catch(Exception e)
		{Outside.err(this,"updateGui()",e);}
	}

}
