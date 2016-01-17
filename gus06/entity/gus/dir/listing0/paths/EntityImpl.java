package gus06.entity.gus.dir.listing0.paths;

import java.io.File;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151106";}


	public Object t(Object obj) throws Exception
	{
		File dir = (File) obj;
		File[] f = dir.listFiles();
		
		String[] n = new String[f.length];
		for(int i=0;i<f.length;i++) n[i] = f[i].getAbsolutePath();
		
		return n;
	}
}
