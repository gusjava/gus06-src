package gus06.entity.gus.swing.button.build.exitbutton;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20150609";}
	
	public JComponent i() throws Exception
	{
		JButton b = new JButton("Exit");
		b.addActionListener(this);
		return b;
	}

	public void actionPerformed(ActionEvent e)
	{System.exit(0);}
}
