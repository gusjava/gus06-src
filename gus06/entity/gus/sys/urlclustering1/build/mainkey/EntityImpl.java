package gus06.entity.gus.sys.urlclustering1.build.mainkey;

import gus06.framework.*;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170113";}


	private Service getDepth;
	private Service getExt;


	public EntityImpl() throws Exception
	{
		getDepth = Outside.service(this,"gus.url.depth");
		getExt = Outside.service(this,"gus.url.getextension");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		URL url = (URL) obj;
		
		String protocol = url.getProtocol();
		String host = url.getHost();
		Integer depth = (Integer) getDepth.t(url);
		String ext = (String) getExt.t(url);
		
		return protocol+"|"+host+"|"+ext+"|"+depth;
	}
}
