package gus06.manager.gus.gyem.m122.t.guslink;

import gus06.framework.T;
import gus06.manager.gus.gyem.GyemSystem;
import gus06.manager.gus.gyem.tools.Tool_File;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Module extends GyemSystem implements T {
	
	private static final String GUSLINK_FILENAME = "guslink.txt";
	
	
	public Object t(Object obj) throws Exception
	{
		File f = (File) obj;
		if(f==null) return null;

		List parents = buildParents(f);
		for(int i=0;i<parents.size();i++)
		{
			File f1 = (File) parents.get(i);
			File f2 = findLink(f1);
			if(f2!=null) return redirect(f,f1,f2);
		}
		
		if(f.isDirectory())
		{
			File f2 = findLink(f);
			if(f2!=null) return f2;
		}
		
		return f;
	}
	
	
	private File findLink(File dir) throws Exception
	{
		File linkFile = new File(dir,GUSLINK_FILENAME);
		if(!linkFile.isFile()) return null;
		
		String link = Tool_File.text(linkFile);
		if(link==null || link.equals("")) return null;
		
		return new File(link);
	}
	
	
	private File redirect(File f, File f1, File f2) throws Exception
	{
		String p = f.getAbsolutePath();
		String p1 = f1.getAbsolutePath();
		String r = p.substring(p1.length());
		
		return new File(f2,r);
	}
	
	
	
	private List buildParents(File f)
	{
		List list = new ArrayList();
		while(f.getParentFile()!=null)
		{
			f = f.getParentFile();
			list.add(f);
		}
		Collections.reverse(list);
		return list;
	}
	
	
}