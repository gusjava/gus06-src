package gus06.entity.gus.app.jarfile.listing.java.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140828";}

	private Service appJar;
	private List list;

	public EntityImpl() throws Exception
	{
		appJar = Outside.service(this,"gus.app.jarfile");
	}
	
	
	public Object g() throws Exception
	{
		if(list==null) init();
		return list;
	}
	
	
	private void init() throws Exception
	{
		list = new ArrayList();
		
		File file = (File) appJar.g();
		JarFile jar = new JarFile(file,true,JarFile.OPEN_READ);
		
		Enumeration en = jar.entries();
		while(en.hasMoreElements())
		{
			JarEntry entry = (JarEntry)en.nextElement();
			if(isTarget(entry)) list.add(entry.getName());
		}
		Collections.sort(list);
		jar.close();
	}
	
	
	
	public static final String START = "gus06/manager/";
	public static final String END = ".java";
	
	private boolean isTarget(JarEntry entry)
	{
		if(entry.isDirectory()) return false;
		String name = entry.getName();
		return name.startsWith(START) && name.endsWith(END);
	}
}
