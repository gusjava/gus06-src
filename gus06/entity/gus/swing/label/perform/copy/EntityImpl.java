package gus06.entity.gus.swing.label.perform.copy;

import gus06.framework.*;
import javax.swing.JLabel;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140821";}

	private Service toClipboard;
	
	public EntityImpl() throws Exception
	{
		toClipboard = Outside.service(this,"gus.clipboard.access.string");
	}
	
	
	public void p(Object obj) throws Exception
	{
		JLabel label = (JLabel) obj;
		toClipboard.p(label.getText());
	}
}
