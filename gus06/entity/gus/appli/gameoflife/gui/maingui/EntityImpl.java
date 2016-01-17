package gus06.entity.gus.appli.gameoflife.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;


public class EntityImpl implements Entity, ActionListener, I {

	public String creationDate() {return "20150323";}

    
	public static final long SLEEP = 50;
	public static final int SIZE = 200;

	
	
	
	
	private Service transition;
	private Service screen;


	private JPanel panel;
	private JButton button;
	
	private Timer timer;
	private TimerTask task;
	private boolean[][] state;
	
	
	

	public EntityImpl() throws Exception
	{
		transition = Outside.service(this,"gus.appli.gameoflife.transition");
		screen = Outside.service(this,"*gus.appli.gameoflife.gui.screen");
		
		timer = new Timer("TIMER_"+getClass().getName());

		button = new JButton("Démarrer");
		button.setFont(button.getFont().deriveFont((float) 15));
		button.addActionListener(this);
		
		panel = new JPanel(new BorderLayout());
		panel.add((JComponent) screen.i(),BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
	}
	
	
	public Object i() throws Exception
	{return panel;}


	public void actionPerformed(ActionEvent e)
	{start();}
	
	
	
	
	private synchronized void start()
	{
		if(task!=null) task.cancel();
		task = new TimerTask() {public void run() {next();}};
		
		state = initialState();
		timer.schedule(task,new Date(),SLEEP);
	}
	
	
	
	
	private synchronized void next()
	{
		try
		{
			screen.p(state);
			state = (boolean[][]) transition.t(state);
		}
		catch(Exception e)
		{Outside.err(this,"next()",e);}
	}
	

	
	
	
	private boolean[][] initialState()
	{
		boolean[][] b = new boolean[SIZE][SIZE];
		for(int i=0;i<b.length;i++)
		for(int j=0;j<b.length;j++)
		b[i][j] = Math.random()<0.5;
		return b;
	}
}
