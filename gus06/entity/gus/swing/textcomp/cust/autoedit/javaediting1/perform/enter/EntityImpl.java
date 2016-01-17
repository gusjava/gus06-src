package gus06.entity.gus.swing.textcomp.cust.autoedit.javaediting1.perform.enter;

import gus06.framework.*;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140816";}


	private Service perform_textArea;
	private Service perform_textPane;

	public EntityImpl() throws Exception
	{
		perform_textArea = Outside.service(this,"gus.swing.textcomp.cust.autoedit.javaediting1.perform.enter.textarea");
		perform_textPane = Outside.service(this,"gus.swing.textcomp.cust.autoedit.javaediting1.perform.enter.textpane");
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof JTextArea) perform_textArea.p(obj);
		else if(obj instanceof JTextPane) perform_textPane.p(obj);
	}
}
