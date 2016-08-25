package gus06.entity.gus.sys.expression1.apply.op._utf8;

import gus06.framework.*;
import java.nio.charset.Charset;
import java.io.File;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}
	
	public final static Charset CHARSET = Charset.forName("UTF-8");


	private Service readTextUTF8;
	private Service urlToTextUTF8;
	
	public EntityImpl() throws Exception
	{
		readTextUTF8 = Outside.service(this,"gus.file.read.string.cs.utf8");
		urlToTextUTF8 = Outside.service(this,"gus.web.download.urltotext.utf8");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		if(obj instanceof File)
		{
			File file = (File) obj;
			return file.isFile()?readTextUTF8.t(file):null;
		}
		if(obj instanceof URL)
		{
			URL url = (URL) obj;
			return urlToTextUTF8.t(url);
		}
		if(obj instanceof byte[])
		{
			return new String((byte[]) obj,CHARSET);
		}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
