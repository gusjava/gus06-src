package gus06.manager.gus.gyem.m096.g.maingui.defaultgui;

import java.awt.BorderLayout;
import java.awt.Insets;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.framework.G;

public class Module extends GyemSystem implements G {

	
	private JPanel panel;
	
	public Object g() throws Exception
	{
		if(panel==null) init();
		return panel;
	}
	
	
	private void init() throws Exception
	{
		String text = (String) ((G) module(M121_G_DEFAULTGUI_EMPTYTEXT)).g();
		panel = new EmptyPanel(text);
	}
	
	
	public class EmptyPanel extends JPanel
	{
		public EmptyPanel(String text)
		{
			super(new BorderLayout());

			JEditorPane area = new JEditorPane();
			area.setText(text);

			area.setEditable(false);
			area.setBackground(getBackground());
			area.setMargin(new Insets(5,5,5,5));
			area.setFont(area.getFont().deriveFont((float)20));
			
			add(area,BorderLayout.CENTER);
		}
	}
}