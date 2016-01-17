package gus06.entity.gus.sys.webserver1.web2.zdyn.e.template.span.code.op.readstring;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141106";}


	private Service readString;
	
	public EntityImpl() throws Exception
	{readString = Outside.service(this,"gus.sys.webserver1.web2.zdyn.e.operator2.file.readstring");}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Map span = (Map) o[0];
		String info = (String) o[1];
		
		Object main = span.get("main");
		Object args = span.get("args");
		Object vars = span.get("vars");
		return readString.t(new Object[]{main,info,args,vars});
	}
}
