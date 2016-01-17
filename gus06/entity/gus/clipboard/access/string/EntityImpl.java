package gus06.entity.gus.clipboard.access.string;

import gus06.framework.*;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class EntityImpl implements Entity, P, G {

	public String creationDate() {return "20140801";}
	
	
	public Object g() throws Exception
	{
		try{return c().getData(DataFlavor.stringFlavor);}
		catch(Exception e) {return null;}
	}
	
	
	public void p(Object obj) throws Exception
	{copy((String) obj);}
	
	
	private Clipboard c()
	{return Toolkit.getDefaultToolkit().getSystemClipboard();}
	
	
	private void copy(String s)
	{
		StringSelection t = new StringSelection(s);
		c().setContents(t,t);
	}
}
