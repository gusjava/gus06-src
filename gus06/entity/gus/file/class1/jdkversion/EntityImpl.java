package gus06.entity.gus.file.class1.jdkversion;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140807";}


	private Service classVersion;
	private Service mapping;

	public EntityImpl() throws Exception
	{
		classVersion = Outside.service(this,"gus.file.class1.classversion");
		mapping = Outside.service(this,"gus.java.jdk.versionmapping");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		int[] v = (int[]) classVersion.t(obj);
		int majorVersion = v[0];
    	
		return mapping.t(""+majorVersion);
	}
}
