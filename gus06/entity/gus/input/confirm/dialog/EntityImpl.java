package gus06.entity.gus.input.confirm.dialog;

import gus06.framework.*;
import javax.swing.JOptionPane;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20140801";}
	
	
	public boolean f(Object obj) throws Exception
	{
		if(obj instanceof String)
		{
			int r = JOptionPane.showConfirmDialog(null,(String) obj);
			return r==JOptionPane.YES_OPTION;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
