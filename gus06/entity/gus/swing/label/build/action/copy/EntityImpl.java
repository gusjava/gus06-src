package gus06.entity.gus.swing.label.build.action.copy;

import gus06.framework.*;
import javax.swing.JLabel;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140821";}

	public static final String DISPLAY = "Copy";
	
	
	private Service performCopy;
	private Service buildAction;
	
	public EntityImpl() throws Exception
	{
		performCopy = Outside.service(this,"gus.swing.label.perform.copy");
		buildAction = Outside.service(this,"gus.swing.action.builder1");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		JLabel label = (JLabel) obj;
		return buildAction.t(new Object[]{DISPLAY,new Holder(label)});
	}
	
	
	private class Holder implements E
	{
		private JLabel label;
		public Holder(JLabel label) {this.label = label;}
		
		public void e() throws Exception
		{performCopy.p(label);}
	}
}
