package gus06.entity.gus.jna.keyboard.buffer;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityImpl extends S1 implements Entity, ActionListener, G {

	public String creationDate() {return "20141217";}


	private Service keyboard;
	private List list;


	public EntityImpl() throws Exception
	{
		keyboard = Outside.service(this,"gus.jna.keyboard");
		keyboard.addActionListener(this);
		
		list = new ArrayList();
	}
	
	
	public Object g() throws Exception
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<list.size();i++) b.append(list.get(i)+" ");
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
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
			String code = (String) keyboard.g();
			String display = display(code);
			
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
			String code = (String) keyboard.g();
			String display = display(code);
			
			list.remove(display);
			modified();
		}
		catch(Exception e)
		{Outside.err(this,"keyReleased()",e);}
	}
	
	
	
	private void modified()
	{send(this,"modified()");}
	
	
	
	
	
	
	
	
	private String display(String code) throws Exception
	{
		String d = display_(code);
		if(d==null) return null;
		return d.replace("CONTROL","CTRL");
	}
	
	private String display_(String code) throws Exception
	{
		Field[] f = KeyEvent.class.getFields();
		for(int i=0;i<f.length;i++)
		if(f[i].get(null).toString().equals(code)) return f[i].getName().replace("VK_","");
		return null;
	}
}
