package gus06.entity.gus.file.jar.findentriesarray;

import gus06.framework.*;
import java.util.*;
import java.io.File;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140807";}


	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		JarFile jarFile = new JarFile(file,true,JarFile.OPEN_READ);

		ArrayList list = new ArrayList();
		Enumeration en = jarFile.entries();
		while(en.hasMoreElements())
		{
			JarEntry entry = (JarEntry) en.nextElement();
			list.add(entry.getName());
		}
		Collections.sort(list);
		jarFile.close();
		return list;
	}
}
