package gus06.entity.gus.jna.keyboard.buffer;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityImpl extends S1 implements Entity, ActionListener, G, F {

	public String creationDate() {return "20141217";}


	private Service keyboard;
	private Service getDisplay;
	
	private List list;


	public EntityImpl() throws Exception
	{
		keyboard = Outside.service(this,"gus.jna.keyboard");
		getDisplay = Outside.service(this,"gus.jna.keyboard.display");
		
		list = new ArrayList();
		keyboard.addActionListener(this);
	}
	
	
	public Object g() throws Exception
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<list.size();i++) b.append(list.get(i)+" ");
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		return list.contains(obj);
	}


	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if(s.equals("keyPressed()")) keyPressed();
		else if(s.equals("keyReleased()")) keyReleased();
	}
	
	
	
	
	
	
	private void keyPressed()
	{
		try
		{
			String display = display();
			if(!list.contains(display)) list.add(display);
			modified();
		}
		catch(Exception e)
		{Outside.err(this,"keyPressed()",e);}
	}
	
	
	private void keyReleased()
	{
		try
		{
			String display = display();
			list.remove(display);
			modified();
		}
		catch(Exception e)
		{Outside.err(this,"keyReleased()",e);}
	}
	
	
	
	private String display() throws Exception
	{
		String code = (String) keyboard.g();
		return (String) getDisplay.t(code);
	}
	
	
	
	private void modified()
	{send(this,"modified()");}
}
