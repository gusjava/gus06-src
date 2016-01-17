package gus06.entity.gus.data.viewer.exception;

import gus06.framework.*;
import javax.swing.*;
import java.awt.Insets;
import java.io.*;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140731";}


	private Exception data;

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
		data = (Exception) obj;
		if(data==null) {area.setText("");return;}
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		data.printStackTrace(pw);
		area.setText(sw.toString());
		pw.close();
	}
}
