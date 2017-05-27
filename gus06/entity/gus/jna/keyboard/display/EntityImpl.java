package gus06.entity.gus.jna.keyboard.display;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class EntityImpl implements Entity, G, S {

	public String creationDate() {return "20161127";}

	private Service keyboard;
	private Service find;
	
	private List list;


	public EntityImpl() throws Exception
	{
		keyboard = Outside.service(this,"gus.jna.keyboard");
		find = Outside.service(this,"gus.jna.keyboard.display.find");
	}
	
	
	
	public Object g() throws Exception
	{
		String code = (String) keyboard.g();
		return (String) find.t(code);
	}

	public void addActionListener(ActionListener l)
	{keyboard.addActionListener(l);}

	public void removeActionListener(ActionListener l)
	{keyboard.removeActionListener(l);}
	
	public List listeners()
	{return keyboard.listeners();}
}
