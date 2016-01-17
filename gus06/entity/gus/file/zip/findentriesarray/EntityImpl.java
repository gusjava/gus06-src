package gus06.entity.gus.file.zip.findentriesarray;

import gus06.framework.*;
import java.util.*;
import java.io.File;
import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.nio.charset.Charset;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141024";}
	
	public static final Charset CHARSET = Charset.forName("Cp437");
	public static final Charset CHARSET1 = Charset.forName("US-ASCII");


	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		ZipFile zipFile = new ZipFile(file,ZipFile.OPEN_READ,CHARSET);

		ArrayList list = new ArrayList();
		Enumeration en = zipFile.entries();
		while(en.hasMoreElements())
		{
			ZipEntry entry = (ZipEntry) en.nextElement();
			list.add(entry.getName());
		}
		Collections.sort(list);
		zipFile.close();
		return list;
	}
}
