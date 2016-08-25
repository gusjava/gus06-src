package gus06.entity.gus.string.transform.textlang.detect;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160629";}


	private Service perform;

	public EntityImpl() throws Exception
	{
		perform = Outside.service(this,"gus.sys.langdetect1.engine");
	}
	
	public Object t(Object obj) throws Exception
	{
		return perform.t(obj);
	}
}
