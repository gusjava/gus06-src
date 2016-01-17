package gus06.entity.gus.data.editor.map.stringmap.button;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.util.Map;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntityImpl implements Entity, I, P, ActionListener {

	public String creationDate() {return "20150329";}


	private Service complete;
	
	private JButton button;
	private Map map;

	public EntityImpl() throws Exception
	{
		complete = Outside.service(this,"gus.map.string.completefromclipboard");
		
		button = new JButton("Complete");
		button.addActionListener(this);
	}
	
	
	public Object i() throws Exception
	{return button;}
	
	
	
	public void p(Object obj) throws Exception
	{map = (Map) obj;}
	
	
	
	public void actionPerformed(ActionEvent evt)
	{complete();}
	
	
	private void complete()
	{
		try
		{
			if(map==null) return;
			complete.p(map);
		}
		catch(Exception e)
		{Outside.err(this,"complete()",e);}
	}
}
