package gus06.manager.gus.gyem.m006.e.started;

import java.awt.event.ActionListener;
import java.util.List;

import gus06.framework.S;
import gus06.framework.E;
import gus06.framework.S1;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements E, S {

	public static final String EVENT = "started";
	
	private S1 s1 = new S1();
	
	
	public void e() throws Exception
	{s1.send(this,EVENT);}

	public void addActionListener(ActionListener listener)
	{s1.addActionListener(listener);}

	public void removeActionListener(ActionListener listener)
	{s1.removeActionListener(listener);}

	public List listeners()
	{return s1.listeners();}
}