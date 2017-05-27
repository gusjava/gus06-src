package gus06.entity.gus.app.outside.lastmodified;

import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20140705";}

	
	private Service classToUrl;
	private Date date;

	public EntityImpl() throws Exception
	{
		classToUrl = Outside.service(this,"gus.convert.classtourl");
	}
	
	
	public Object g() throws Exception
	{
		if(date==null) init();
		return date;
	}
	
	
	private void init() throws Exception
	{
		URL url = (URL) classToUrl.t(Outside.class);
		URLConnection connection = url.openConnection();
		long lastModified = connection.getLastModified();
		date = new Date(lastModified);
	}
}
