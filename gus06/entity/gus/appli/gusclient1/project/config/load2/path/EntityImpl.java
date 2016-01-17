package gus06.entity.gus.appli.gusclient1.project.config.load2.path;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150312";}


	private Service loadProp;
	private Service buildPathMap;


	public EntityImpl() throws Exception
	{
		loadProp = Outside.service(this,"gus.appli.gusclient1.project.config.load2.prop");
		buildPathMap = Outside.service(this,"gus.app.path.build.fromprop");
	}
	
	
	public Object g() throws Exception
	{
		Map prop = (Map) loadProp.g();
		return buildPathMap.t(prop);
	}
}
