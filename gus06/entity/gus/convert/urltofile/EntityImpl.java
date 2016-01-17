package gus06.entity.gus.convert.urltofile;

import gus06.framework.*;
import java.net.*;
import java.io.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140909";}


	private Service tmpFile;
	private Service transfert;
	private Service normalizeName;


	public EntityImpl() throws Exception
	{
		tmpFile = Outside.service(this,"gus.file.tmpfile");
		transfert = Outside.service(this,"gus.io.transfer");
		normalizeName = Outside.service(this,"gus.string.transform.normalize.filename");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		URL url = (URL) obj;
		String fileName = (String) normalizeName.t(url.getFile());
		File file = (File) tmpFile.t(fileName);
		
		try
		{
			HttpURLConnection con = (HttpURLConnection) rebuildURL(url).openConnection();
			con.connect();

			FileOutputStream fos = new FileOutputStream(file);  
			InputStream is = con.getInputStream(); 

			transfert.p(new Object[]{is,fos});
			con.disconnect();

			if(file.length()==0) throw new Exception("Empty file for url: "+url);
		}
		catch(Exception e)
		{
			String message = "url "+url+" failed to be downloaded into file "+file;
			throw new Exception(message,e);
		}
		return file;
	}
	
	
	
	
	private URL rebuildURL(URL url) throws Exception
	{
		String s = url.toString();
		return new URL(s.replace(" ","%20"));
	}
}
