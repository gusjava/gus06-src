package gus06.entity.gus.file.mime.tika.detect.asmediatype;

import gus06.framework.*;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MediaTypeRegistry;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150819";}


	private Service detect;

	public EntityImpl() throws Exception
	{
		detect = Outside.service(this,"gus.file.mime.tika.detect.asstring");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		String mime = (String) detect.t(obj);
		return MediaType.parse(mime);
	}
}
