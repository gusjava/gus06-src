package gus06.manager.gus.gyem.m095.g.maingui.builder2;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_Throwable;

public class Module extends GyemSystem implements T {

	public Object t(Object obj) throws Exception
	{
		Exception ex = (Exception) obj;
		String s = Tool_Throwable.description(ex);
		JTextArea area = new JTextArea(s);
		
		area.setEditable(false);
		area.setForeground(Color.RED);
		area.setBackground(Color.BLACK);
		area.setFont(area.getFont().deriveFont((float) 14));
		
		return new JScrollPane(area);
	}
}