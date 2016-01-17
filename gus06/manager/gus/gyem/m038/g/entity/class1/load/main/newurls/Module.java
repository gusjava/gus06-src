package gus06.manager.gus.gyem.m038.g.entity.class1.load.main.newurls;

import java.io.File;
import java.util.*;
import java.net.URL;

import gus06.framework.G;
import gus06.framework.R;
import gus06.manager.gus.gyem.GyemSystem;

public class Module extends GyemSystem implements G {


	private Set found;



	public Object g() throws Exception
	{
		if(found==null) found = new HashSet();
		
		File apiDir = getApiDir();
		if(apiDir==null || !apiDir.isDirectory()) return null;
		
		File[] ff = apiDir.listFiles();
		if(ff==null) return null;
		
		List newFiles = new ArrayList();
		
		for(File f:ff) if(!found.contains(f)) newFiles.add(f);
		if(newFiles.isEmpty()) return null;
		
		found.addAll(newFiles);
		
		URL[] url = new URL[newFiles.size()];
		for(int i=0;i<url.length;i++)
		{
			File f = (File) newFiles.get(i);
			url[i] = f.toURI().toURL();
		}
		return url;
	}
	
	
	
	
	
	private File getApiDir() throws Exception
	{return (File) ((R) module(M102_R_FILEPROVIDER)).r(PATH_GYEM_APIDIR);}
}