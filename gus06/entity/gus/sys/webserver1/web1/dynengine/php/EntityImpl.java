package gus06.entity.gus.sys.webserver1.web1.dynengine.php;

import gus06.framework.*;
import java.util.Map;
import java.io.File;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140929";}

	public static final String MESSAGE = "PHP engine not implemented yet";

	private Service readFile;

	public EntityImpl() throws Exception
	{
		readFile = Outside.service(this,"gus.file.read.string.array");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		File file = (File) o[0];
		Map input = (Map) o[1];
		
		String[] lines = (String[]) readFile.t(file);
		StringBuffer b = new StringBuffer();
		b.append(MESSAGE);
		return b.toString();
	}
}
