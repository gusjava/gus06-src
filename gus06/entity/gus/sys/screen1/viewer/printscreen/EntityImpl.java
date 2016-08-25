package gus06.entity.gus.sys.screen1.viewer.printscreen;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import gus06.framework.*;
import javax.swing.JPanel;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20160605";}

	public static final long LAPSE = 100;
	public static final double FACTOR = 0.20;


	private Service printScreen;
	private Service screenPanel;
	
	private Timer timer;
	private JPanel panel;
	private Dimension dim;

	public EntityImpl() throws Exception
	{
		printScreen = Outside.service(this,"gus.awt.robot.printscreen");
		screenPanel = Outside.service(this,"gus.swing.panel.screen.image");
		
		panel = (JPanel) screenPanel.i();
		
		Rectangle rec = getScreenRect();
		int x = (int)(rec.getWidth()*FACTOR);
		int y = (int)(rec.getHeight()*FACTOR);
		dim = new Dimension(x,y);
		
		panel.setMinimumSize(dim);
		panel.setMaximumSize(dim);
		panel.setPreferredSize(dim);

		TimerTask task = new TimerTask(){
			public void run() {update();}
		};
		
		timer = new Timer("TIMER_"+getClass().getName());
		timer.schedule(task,new Date(),LAPSE);
	}



	public Object i() throws Exception
	{return screenPanel.i();}


	
	private void update()
	{
		try{screenPanel.p(printScreen.g());}
		catch(Exception e)
		{Outside.err(this,"update()",e);}
	}
	
	
	private Rectangle getScreenRect()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		GraphicsConfiguration gc = device.getDefaultConfiguration();
		return gc.getBounds();
	}
}
