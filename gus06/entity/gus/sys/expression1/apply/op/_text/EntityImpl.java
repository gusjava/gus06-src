package gus06.entity.gus.sys.expression1.apply.op._text;

import gus06.framework.*;
import java.io.File;
import java.net.URL;
import javax.swing.JComponent;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151110";}


	private Service readText;
	private Service urlToText;
	private Service compToText;
	
	public EntityImpl() throws Exception
	{
		readText = Outside.service(this,"gus.file.read.string.generic");
		urlToText = Outside.service(this,"gus.web.download.urltotext");
		compToText = Outside.service(this,"gus.swing.comp.gettext");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		return text(obj);
	}
	
	
	
	
	private String text(Object obj) throws Exception
	{
		if(obj instanceof File)
			return (String) readText.t(obj);
		if(obj instanceof URL)
			return (String) urlToText.t(obj);
		if(obj instanceof JComponent)
			return (String) compToText.t(obj);
		if(obj instanceof byte[])
			return new String((byte[]) obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
