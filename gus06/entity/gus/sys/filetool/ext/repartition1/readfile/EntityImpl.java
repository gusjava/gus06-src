package gus06.entity.gus.sys.filetool.ext.repartition1.readfile;

import gus06.framework.*;
import java.io.File;
import java.io.FileInputStream;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151020";}

	
	public Object t(Object obj) throws Exception
	{
		File file = (File) obj;
		int size = (int) file.length();
		
		int[] a = new int[size];
		FileInputStream fis = new FileInputStream(file);
		for(int i=0;i<size;i++) a[i] = ((int) fis.read())-48;
		fis.close();
		return a;
	}
}
