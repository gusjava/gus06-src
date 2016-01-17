package gus06.entity.gus.data.viewer.g.output;

import gus06.framework.*;
import javax.swing.JComponent;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20150829";}

	private Service viewer;

	public EntityImpl() throws Exception
	{viewer = Outside.service(this,"*gus.data.viewer.object");}
	
	
	public Object i() throws Exception
	{return viewer.i();}

	
	
	public void p(Object obj) throws Exception
	{
		try
		{
			viewer.p(null);
			Object result = ((G) obj).g();
			viewer.p(result);
		}
		catch(Exception e)
		{viewer.p(e);}
	}
}