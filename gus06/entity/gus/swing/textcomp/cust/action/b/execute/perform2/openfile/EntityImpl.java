package gus06.entity.gus.swing.textcomp.cust.action.b.execute.perform2.openfile;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, F {

	public String creationDate() {return "20150527";}


	private Service openFile;


	public EntityImpl() throws Exception
	{
		openFile = Outside.service(this,"gus.awt.desktop.open");
	}
	
	
	public boolean f(Object obj) throws Exception
	{
		String line = (String) obj;
		try
		{
			File f = getFile(line);
			if(f==null) return false;
			openFile.p(f);
			return true;
		}
		catch(Exception e)
		{return false;}
	}
	
	
	
	
	private File getFile(String line)
	{
		File f = new File(line);
		if(f.exists()) return f;
		
		if(line.length()>2 && line.charAt(1)==':')
		{
			line = line.substring(2);
			File[] rr = File.listRoots();
			for(File r:rr)
			{
				f = new File(r+line);
				if(f.exists()) return f;
			}
		}
		return null;
	}
}
