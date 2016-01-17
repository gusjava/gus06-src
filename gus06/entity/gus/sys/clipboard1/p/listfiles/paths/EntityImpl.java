package gus06.entity.gus.sys.clipboard1.p.listfiles.paths;

import gus06.framework.*;
import java.util.List;
import java.io.File;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20151016";}


	private Service accessString;
	
	public EntityImpl() throws Exception
	{
		accessString = Outside.service(this,"gus.clipboard.access.string");
	}
	
	
	public void p(Object obj) throws Exception
	{
		List files = (List) obj;
		String paths = toPaths(files);
		accessString.p(paths);
	}
	
	
	
	private String toPaths(List files)
	{
		if(files.size()==0) return "";
		if(files.size()==1) return ((File) files.get(0)).getAbsolutePath();
		
		StringBuffer b = new StringBuffer();
		
		for(int i=0;i<files.size();i++)
		{
			File f = (File) files.get(i);
			b.append(f.getAbsolutePath()+"\n");
		}
		return b.toString().trim();
	}
}
