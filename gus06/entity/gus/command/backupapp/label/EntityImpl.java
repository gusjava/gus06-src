package gus06.entity.gus.command.backupapp.label;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;


public class EntityImpl implements Entity, I, ActionListener {

	public String creationDate() {return "20140927";}

	private Service compiler;
	private JLabel label;
	private Icon icon;

	public EntityImpl() throws Exception
	{
		compiler = Outside.service(this,"gus.command.backupapp");
		icon = (Icon) Outside.resource(this,"icon#ACTION_backup");
	
		label = new JLabel(" ");
		compiler.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return label;}
	
	
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if(s.equals("start()")) start();
		else if(s.equals("end()")) end();
	}
	
	private void start()
	{
		label.setIcon(icon);
		label.setToolTipText("Backuping application");
	}
	
	private void end()
	{
		label.setIcon(null);
		label.setToolTipText(null);
	}
}
