package gus06.entity.gus.awt.bufferedimage.color.avg.rgb.cache;

import gus06.framework.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141122";}


	private Service trans;
	private HashMap cache;


	public EntityImpl() throws Exception
	{
		trans = Outside.service(this,"gus.awt.bufferedimage.color.avg.rgb");
		cache = new HashMap();
	}

	
	public Object t(Object obj) throws Exception
	{
		if(!cache.containsKey(obj))
			cache.put(obj,trans.t(obj));
		return cache.get(obj);
	}
}
