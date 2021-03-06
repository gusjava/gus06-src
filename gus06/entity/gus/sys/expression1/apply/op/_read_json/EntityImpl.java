package gus06.entity.gus.sys.expression1.apply.op._read_json;

import gus06.framework.*;
import java.io.File;
import java.net.URL;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151125";}


	private Service jsonParser;
	private Service readFile;
	private Service urlToText;
	
	public EntityImpl() throws Exception
	{
		jsonParser = Outside.service(this,"gus.sys.jsonparser1.evaluate");
		readFile = Outside.service(this,"gus.file.read.string.autodetect");
		urlToText = Outside.service(this,"gus.web.download.urltotext.utf8");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof String) return stringToData((String) obj);
		if(obj instanceof File) return fileToData((File) obj);
		if(obj instanceof URL) return urlToData((URL) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private Object urlToData(URL url) throws Exception
	{
		String s = (String) urlToText.t(url);
		return jsonParser.t(s);
	}
	
	private Object fileToData(File file) throws Exception
	{
		String s = (String) readFile.t(file);
		return jsonParser.t(s);
	}
	
	private Object stringToData(String s) throws Exception
	{
		return jsonParser.t(s);
	}
}
