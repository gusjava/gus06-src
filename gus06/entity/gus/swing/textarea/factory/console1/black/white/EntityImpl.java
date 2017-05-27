package gus06.entity.gus.swing.textarea.factory.console1.black.white;

import gus06.framework.*;
import javax.swing.JTextArea;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20161109";}


	private Service cust;

	public EntityImpl() throws Exception
	{
		cust = Outside.service(this,"gus.swing.textcomp.cust.console1.black.white");
	}
	
	
	public Object i() throws Exception
	{
		JTextArea area = new JTextArea();
		cust.p(area);
		return area;
	}
}
