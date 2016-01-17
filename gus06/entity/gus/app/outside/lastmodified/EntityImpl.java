package gus06.entity.gus.app.outside.lastmodified;

import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140705";}

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
	
	private Service classToUrl;
	private String time;

	public EntityImpl() throws Exception
	{
		classToUrl = Outside.service(this,"gus.convert.classtourl");
	}
	
	
	public Object g() throws Exception
	{
		if(time==null) init();
		return time;
	}
	
	
	private void init() throws Exception
	{
		URL url = (URL) classToUrl.t(Outside.class);
		URLConnection connection = url.openConnection();
		long lastModified = connection.getLastModified();
		time = sdf.format(new Date(lastModified));
	}
}
