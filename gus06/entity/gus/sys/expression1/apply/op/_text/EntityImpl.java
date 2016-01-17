package gus06.entity.gus.sys.expression1.apply.op._text;

import gus06.framework.*;
import java.io.File;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service readText;
	private Service urlToText;
	
	public EntityImpl() throws Exception
	{
		readText = Outside.service(this,"gus.file.read.string.autodetect");
		urlToText = Outside.service(this,"gus.web.download.urltotext");
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
			return file.isFile()?readText.t(file):null;
		}
		if(obj instanceof URL)
		{
			URL url = (URL) obj;
			return urlToText.t(url);
		}
		if(obj instanceof byte[])
		{
			return new String((byte[]) obj);
		}
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
