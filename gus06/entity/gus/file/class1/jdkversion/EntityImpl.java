package gus06.entity.gus.file.class1.jdkversion;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140807";}


	private Service classVersion;

	public EntityImpl() throws Exception
	{classVersion = Outside.service(this,"gus.file.class1.classversion");}
	
	
	public Object t(Object obj) throws Exception
	{
		int[] v = (int[]) classVersion.t(obj);
		int majorVersion = v[0];
    	
		switch(majorVersion) {
			case 52:return "J2SE 8";
			case 51:return "J2SE 7";
			case 50:return "J2SE 6";
			case 49:return "J2SE 5";
			case 48:return "JDK 1.4";
			case 47:return "JDK 1.3";
			case 46:return "JDK 1.2";
			case 45:return "JDK 1.1";
			default:throw new Exception("Unsupported major version: "+majorVersion);
		}
	}
}
