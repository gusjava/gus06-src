package gus06.entity.gus.java.jdk.versionmapping;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170223";}
	
	
	public Object t(Object obj) throws Exception
	{
		int majorVersion = Integer.parseInt(""+obj);
    	
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