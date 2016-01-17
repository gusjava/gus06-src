package gus06.entity.gus.sys.store.gui.maingui;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140907";}


	private Service initRule;
	private Service findObj;


	private JComponent comp;

	public EntityImpl() throws Exception
	{
		initRule = Outside.service(this,"gus.sys.store.gui.maingui.initrule");
		findObj = Outside.service(this,"gus.sys.store.obj.find");
		
		String rule = (String) initRule.g();
		comp = (JComponent) findObj.t(rule);
	}
	
	
	public Object i() throws Exception
	{return comp;}
}
