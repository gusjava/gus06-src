package gus06.entity.gus.app.jarfile.listing.resources.iconmap.gyem;

import java.io.File;
import java.util.*;
import gus06.framework.*;


public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140910";}
	
	public static final String START = "gus06/resource/gus/gyem/icon/";
	
	
	private Service iconMap;
	private Map map;


	public EntityImpl() throws Exception
	{iconMap = Outside.service(this,"gus.app.jarfile.listing.resources.iconmap");}
	
	
	public Object g() throws Exception
	{
		if(map==null) init();
		return map;
	}
	
	private void init() throws Exception
	{map = (Map) iconMap.t(START);}
}
