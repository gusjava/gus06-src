package gus06.entity.gus.jna.keyboard.activity;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl implements Entity, ActionListener, F {

	public String creationDate() {return "20170409";}
	
	public static long WAIT = 30000;


	private Service keyboard;

	private long last = -1;


	public EntityImpl() throws Exception
	{
		keyboard = Outside.service(this,"gus.jna.keyboard");
		keyboard.addActionListener(this);
	}
	
	
	public synchronized boolean f(Object obj) throws Exception
	{
		long t = System.currentTimeMillis();
		return t-last<WAIT;
	}


	public void actionPerformed(ActionEvent e)
	{perform();}
	
	
	private synchronized void perform()
	{last = System.currentTimeMillis();}
}
