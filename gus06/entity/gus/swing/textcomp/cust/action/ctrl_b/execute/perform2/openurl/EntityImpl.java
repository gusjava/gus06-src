package gus06.entity.gus.swing.textcomp.cust.action.ctrl_b.execute.perform2.openurl;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150527";}


	private Service browseUrl;


	public EntityImpl() throws Exception
	{
		browseUrl = Outside.service(this,"gus.awt.desktop.browse");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String line = (String) obj;
		try
		{
			browseUrl.p(new URL(line));
			return true;
		}
		catch(Exception e)
		{return false;}
	}
}
