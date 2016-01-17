package gus06.entity.gus.data.viewer.string.src.java;

import gus06.framework.*;
import javax.swing.*;
import java.awt.Insets;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140809";}


	private Service highSyntax;
	private Service buildScroll;

	private String data;

	private JTextPane area;
	private JScrollPane scroll;
	

	public EntityImpl() throws Exception
	{
		highSyntax = Outside.service(this,"gus.swing.textpane.cust.syntax.java.ostermiller");
		buildScroll = Outside.service(this,"gus.swing.textarea.buildscrollpane.linenb");
	
		area = new JTextPane();
		area.setMargin(new Insets(3,3,3,3));
		area.setEditable(false);
		
		highSyntax.p(area);
		
		scroll = (JScrollPane) buildScroll.t(area);
	}
	
	
		
	public Object g() throws Exception
	{return data;}
	
	
	public Object i() throws Exception
	{return scroll;}
	
	
	public void p(Object obj) throws Exception
	{
		data = (String) obj;
		if(data==null) {area.setText("");return;}
		
		area.setText(data);
		area.setCaretPosition(0);
	}
}
