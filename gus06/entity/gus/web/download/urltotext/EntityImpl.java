package gus06.entity.gus.web.download.urltotext;

import gus06.framework.*;
import java.net.URL;
import java.net.URLConnection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140919";}


	private Service findURL;
	private Service connect;
	private Service perform;

	public EntityImpl() throws Exception
	{
		findURL = Outside.service(this,"gus.find.url");
		connect = Outside.service(this,"gus.url.connect.as.mozilla50");
		perform = Outside.service(this,"gus.web.download.urltotext.perform");
	}

	public Object t(Object obj) throws Exception
	{
		URL url = (URL) findURL.t(obj);
		URLConnection con = (URLConnection) connect.t(url);
		return (String) perform.t(con);
	}
}
