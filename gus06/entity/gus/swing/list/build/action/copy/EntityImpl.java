package gus06.entity.gus.swing.list.build.action.copy;

import gus06.framework.*;
import javax.swing.JLabel;
import javax.swing.JList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160603";}

	public static final String DISPLAY = "Copy";
	
	
	private Service performCopy;
	private Service buildAction;
	
	public EntityImpl() throws Exception
	{
		performCopy = Outside.service(this,"gus.swing.list.perform.copy");
		buildAction = Outside.service(this,"gus.swing.action.builder1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		JList list = (JList) obj;
		return buildAction.t(new Object[]{DISPLAY,new Holder(list)});
	}
	
	
	private class Holder implements E
	{
		private JList list;
		public Holder(JList list) {this.list = list;}
		
		public void e() throws Exception
		{performCopy.p(list);}
	}
}
