package gus06.entity.gus.sys.webserver1.web2.zdyn.e.listing.sites;

import gus06.framework.*;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141024";}
	
	
	public Object t(Object obj) throws Exception
	{
		R mr = (R) obj;
		F mf = (F) obj;
		
		File rootDir = (File) mr.r("data dirs sites");
		File[] d = rootDir.listFiles();
		
		String[] names = new String[d.length];
		for(int i=0;i<d.length;i++) names[i] = d[i].getName();
		return names;
	}
}
