package gus06.entity.gus.web.download.urltotext.utf8;

import gus06.framework.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151126";}
	
	
	private Charset charset = Charset.forName("UTF-8");


	
	
	public Object t(Object obj) throws Exception
	{
		URL url = toURL(obj);
		return pageContent(url);
	}
	
	
	private URL toURL(Object obj) throws Exception
	{
		if(obj instanceof URL) return (URL)obj;
		if(obj instanceof URI) return ((URI)obj).toURL();
		if(obj instanceof String) return new URL((String)obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}

	
	
	private String pageContent(URL url) throws IOException
	{
		URLConnection con = url.openConnection();
		con.connect();
		
		InputStream is = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(is,charset);
		StringBuffer buffer = new StringBuffer();
		int b;
		while((b = isr.read())!=-1)
		{buffer.append((char)b);}
		isr.close();
		
		if(con instanceof HttpURLConnection)
			((HttpURLConnection)con).disconnect();
		return buffer.toString();
	}
}
