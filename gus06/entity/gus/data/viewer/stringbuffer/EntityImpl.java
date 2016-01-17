package gus06.entity.gus.data.viewer.stringbuffer;

import gus06.framework.*;
import javax.swing.*;
import java.awt.Insets;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20150906";}


	private StringBuffer data;

	private JTextArea area;
	private JScrollPane scroll;
	

	public EntityImpl() throws Exception
	{
		area = new JTextArea();
		area.setMargin(new Insets(3,3,3,3));
		area.setEditable(false);
		scroll = new JScrollPane(area);
	}
	
	
	public Object g() throws Exception
	{return data;}
	
	
	public JComponent i() throws Exception
	{return scroll;}
	
	
	public void p(Object obj) throws Exception
	{
		data = (StringBuffer) obj;
		if(data==null) {area.setText("");return;}
		
		area.setText(data.toString());
		area.setCaretPosition(0);
	}
}
