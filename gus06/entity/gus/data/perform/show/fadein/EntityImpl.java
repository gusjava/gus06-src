package gus06.entity.gus.data.perform.show.fadein;

import gus06.framework.*;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JDialog;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161004";}


	private Service perform;
	private Service windowFadein;
	
	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.swing.frame.show.fadein");
		windowFadein = Outside.service(this,"gus.awt.window.fadein");
	}
	
	
	public void p(Object obj) throws Exception
	{
		if(obj instanceof I)
		{perform.p(obj);return;}
		
		if(obj instanceof JComponent)
		{perform.p(obj);return;}
		
		if(obj instanceof JFrame)
		{perform.p(obj);return;}
		
		if(obj instanceof JDialog)
		{showDialog((JDialog) obj);return;}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private void showDialog(JDialog dialog) throws Exception
	{
		windowFadein.p(dialog);
	}
}
