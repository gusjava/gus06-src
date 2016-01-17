package gus06.entity.gus.awt.robot.mouse.order;

import gus06.framework.*;
import java.awt.*;
import java.awt.event.InputEvent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20150831";}


	private Robot robot;
	
	public EntityImpl() throws Exception
	{
		robot = new Robot();
	}
	
	
	public void p(Object obj) throws Exception
	{
		String s = (String) obj;
		if(s==null) return;
		
		String[] lines = s.split("\n");
		for(String line:lines) handle(line);
	}
	
	
	private void handle(String s) throws Exception
	{
		s = s.trim();
		if(s.equals("")) return;
		
		if(s.equals("press")) {pressright();return;}
		if(s.equals("release")) {releaseright();return;}
		if(s.equals("click")) {clickright();return;}
		
		if(s.equals("pressright")) {pressright();return;}
		if(s.equals("releaseright")) {releaseright();return;}
		if(s.equals("clickright")) {clickright();return;}
		
		if(s.equals("pressleft")) {pressleft();return;}
		if(s.equals("releaseleft")) {releaseleft();return;}
		if(s.equals("clickleft")) {clickleft();return;}
		
		
		
		String t0 = t(0,s);
		
		if(t0.equals("position")) {position(t(1,s));return;}
		if(t0.equals("move")) {move(t(1,s));return;}
		if(t0.equals("wait")) {wait(t(1,s));return;}
		
		position(s);
	}
	
	
	
	
	
	
	private void position(String s) throws Exception
	{
		int[] a = toPos(s);
		robot.mouseMove(a[0],a[1]);
	}
	
	
	private void move(String s) throws Exception
	{
		int[] a = toPos(s);
		Point p = MouseInfo.getPointerInfo().getLocation();
		robot.mouseMove(p.x+a[0],p.y+a[1]);
	}
	
	private void wait(String s) throws Exception
	{
		long lapse = Long.parseLong(s);
		Thread.sleep(lapse);
	}
	
	
	
	
	private void pressright()
	{robot.mousePress(InputEvent.BUTTON1_MASK);}
	
	private void pressleft()
	{robot.mousePress(InputEvent.BUTTON3_MASK);}
	
	
	
	private void releaseright()
	{robot.mouseRelease(InputEvent.BUTTON1_MASK);}
	
	private void releaseleft()
	{robot.mouseRelease(InputEvent.BUTTON3_MASK);}
	
	
	
	private void clickright()
	{pressright();releaseright();}
	
	private void clickleft()
	{pressleft();releaseleft();}
	
	
	
	
	
	
	
	
	private String t(int i, String s) throws Exception
	{
		String[] n = s.split(" +");
		if(n.length<=i) throw new Exception("Invalid command: "+s);
		return n[i];
	}
	
	private int[] toPos(String s) throws Exception
	{
		String[] n = s.split(":");
		if(n.length!=2)  throw new Exception("Invalid position: "+s);
		return new int[]{int_(n[0]),int_(n[1])};
	}
	
	private int int_(String s)
	{return Integer.parseInt(s);}
}
