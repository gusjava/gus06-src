package gus06.entity.gus.swing.textcomp.cust.action.ctrl_space.enlargeselection.perform.xml;

import gus06.framework.*;
import javax.swing.text.JTextComponent;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20160426";}


	private Service goForward;
	private Service goBack;
	
	public EntityImpl() throws Exception
	{
		goForward = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_space.enlargeselection.perform.xml.goforward");
		goBack = Outside.service(this,"gus.swing.textcomp.cust.action.ctrl_space.enlargeselection.perform.xml.goback");
	}



	
	public void p(Object obj) throws Exception
	{
		JTextComponent comp = (JTextComponent) obj;
		String s = comp.getSelectedText();
		
		if(!s.startsWith("<") || !s.endsWith(">"))
			throw new Exception("Invalid xml tag: "+s);
		
		String s0 = s.substring(1,s.length()-1).trim();
		
		if(s0.charAt(0)=='/')
		{
			String name = s0.substring(1).trim();
			goBack.p(new Object[]{comp,name});
		}
		else if(s0.endsWith("/"))
		{
			return;
		}
		else
		{
			String name = s0.split("[ \\t\\n]")[0];
			goForward.p(new Object[]{comp,name});
		}
	}
}
