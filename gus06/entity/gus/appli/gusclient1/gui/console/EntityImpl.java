package gus06.entity.gus.appli.gusclient1.gui.console;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import gus06.framework.*;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class EntityImpl implements Entity, I, ActionListener {

	public String creationDate() {return "20140717";}
	
	
	public static final KeyStroke UP = KeyStroke.getKeyStroke(KeyEvent.VK_UP,0);
	public static final KeyStroke DOWN = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0);
	public static final KeyStroke ESCAPE = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0);
	public static final int MAX = 10;
    

	
	private Service buildOutput;
	private Service custArea;
	private Service perform;
	
	private JPanel panel;
	private JTextArea area;
	private JTextField field;
	
	private PrintStream areaOut;
	private List history;
	
	
	
	public EntityImpl() throws Exception
	{
		buildOutput = Outside.service(this,"gus.io.outputstream.textarea1");
		custArea = Outside.service(this,"gus.swing.textcomp.cust.console1.blue");
		perform = Outside.service(this,"gus.appli.gusclient1.gui.console.perform");
		
		area = new JTextArea();
		area.setEditable(false);
		
		field = new JTextField();
		field.addActionListener(this);
		
		custArea.p(area);
		custArea.p(field);
		
		panel = new JPanel(new BorderLayout());
		panel.add(new JScrollPane(area),BorderLayout.CENTER);
		panel.add(field,BorderLayout.SOUTH);

		history = new ArrayList();
		areaOut = new PrintStream((OutputStream) buildOutput.t(area));
		
		AbstractAction actionUp = new AbstractAction(){public void actionPerformed(ActionEvent e){up();}};
		AbstractAction actionDown = new AbstractAction(){public void actionPerformed(ActionEvent e){down();}};
		AbstractAction actionClear = new AbstractAction(){public void actionPerformed(ActionEvent e){clear();}};
        
		field.getInputMap().put(UP,actionUp);
		field.getInputMap().put(DOWN,actionDown);
		field.getInputMap().put(ESCAPE,actionClear);
		
		perform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				boolean isRunning = e.getActionCommand().equals("start()");
				updateGui(isRunning);
			}
		});
	}
	
	
	
	public Object i() throws Exception
	{return panel;}

	
	public void actionPerformed(ActionEvent e)
	{perform();}
	
	
	
	private void perform()
	{
		try
		{
			String line = field.getText();
			updateHistory(line);
			field.setText("");
			
			if(line.equals("clear"))
			{area.setText("");return;}
			
			perform.p(new Object[]{line,areaOut});
		}
		catch(Exception e)
		{Outside.err(this,"perform()",e);}
	}
	
	
	
	
	
	private void updateHistory(String line)
	{
		while(history.contains(line))
			history.remove(line);
		history.add(line);
		while(history.size()>MAX)
			history.remove(history.size()-1);
	}
	
	
	private void up()
	{
		if(history.isEmpty()) return;
		
		field.setText((String) history.get(0));
		Collections.rotate(history,1);
	}
	
	
	private void down()
	{
		if(history.isEmpty()) return;
		
		field.setText((String) history.get(history.size()-1));
		Collections.rotate(history,-1);
	}
	
	
	private void clear()
	{
		field.setText("");
	}
	
	
	private void updateGui(boolean isRunning)
	{
		Color fg = isRunning?Color.YELLOW.darker():Color.WHITE;
		area.setForeground(fg);
		field.setForeground(fg);
		field.setCaretColor(fg);
	}
}
