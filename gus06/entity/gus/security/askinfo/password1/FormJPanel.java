package gus06.entity.gus.security.askinfo.password1;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class FormJPanel extends JPanel {

	public FormJPanel()
	{
		super();
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new FormLayout(20, 5)); 
	}
	
	public void addLabel(String name, JComponent comp)
	{
		add(new JLabel(name));
		add(comp);
	}
}