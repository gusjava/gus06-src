package gus06.entity.gus.web.download.urltofile;

import java.io.File;
import java.net.URL;
import gus06.framework.*;
import java.net.URLConnection;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170202";}


	private Service findURL;
	private Service buildTmpFile;
	private Service connect;
	private Service perform;
	
	public EntityImpl() throws Exception
	{
		findURL = Outside.service(this,"gus.find.url");
		buildTmpFile = Outside.service(this,"gus.url.build.tmpfile");
		connect = Outside.service(this,"gus.url.connect.as.mozilla50");
		perform = Outside.service(this,"gus.web.download.urltofile.perform");
	}


	public Object t(Object obj) throws Exception
	{
		URL url = (URL) findURL.t(obj);
		File file = (File) buildTmpFile.t(url);
		
		try
		{
			URLConnection con = (URLConnection) connect.t(url);
			perform.p(new Object[]{con,file});
			if(file.length()==0) throw new Exception("Empty file for url: "+url);
		}
		catch(Exception e)
		{
			String message = "url "+url+" failed to be downloaded into file "+file;
			throw new Exception(message,e);
		}
		return file;
	}
}
