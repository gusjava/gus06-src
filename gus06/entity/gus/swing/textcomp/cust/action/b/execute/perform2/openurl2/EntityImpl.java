package gus06.entity.gus.swing.textcomp.cust.action.b.execute.perform2.openurl2;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150618";}


	private Service browseUrl;
	private Service toClipboard;


	public EntityImpl() throws Exception
	{
		browseUrl = Outside.service(this,"gus.awt.desktop.browse");
		toClipboard = Outside.service(this,"gus.clipboard.access");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String line = (String) obj;
		
		String[] n = line.split(" ");
		if(n.length!=2) return false;
		
		String url = n[0];
		String info = n[1];
		
		try
		{
			toClipboard.p(info);
			browseUrl.p(new URL(url));
			return true;
		}
		catch(Exception e)
		{return false;}
	}
}
