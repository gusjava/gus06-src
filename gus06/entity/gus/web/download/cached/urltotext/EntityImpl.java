package gus06.entity.gus.web.download.cached.urltotext;

import gus06.framework.*;
import java.net.URL;
import java.net.URLConnection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170114";}


	private Service cache;
	private Service findURL;
	private Service connect;
	private Service perform;

	public EntityImpl() throws Exception
	{
		cache = Outside.service(this,"gus.sys.cache1");
		findURL = Outside.service(this,"gus.find.url");
		connect = Outside.service(this,"gus.url.connect.as.mozilla50");
		perform = Outside.service(this,"gus.web.download.urltotext.perform");
	}


	public Object t(Object obj) throws Exception
	{
		URL url = (URL) findURL.t(obj);
		
		String v = (String) cache.r(url.toString());
		if(v!=null) return v;
		
		URLConnection con = (URLConnection) connect.t(url);
		String page = (String) perform.t(con);
		
		cache.v(url.toString(),page);
		return page;
	}
}
