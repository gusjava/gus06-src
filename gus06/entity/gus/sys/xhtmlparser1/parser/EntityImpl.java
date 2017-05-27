package gus06.entity.gus.sys.xhtmlparser1.parser;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170226";}


	private Service split;
	private Service regroup;

	public EntityImpl() throws Exception
	{
		split = Outside.service(this,"gus.sys.xhtmlparser1.parser.split");
		regroup = Outside.service(this,"gus.sys.xhtmlparser1.parser.regroup");
	}
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		Object list = split.t(s);
		return regroup.t(list);
	}
}