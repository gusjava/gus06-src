package gus06.entity.gus.url.connect.as.mozilla50.full;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170113";}
	
	public static final String USERAGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0";

	private Service perform;
	
	public EntityImpl() throws Exception
	{perform = Outside.service(this,"gus.url.connect.as");}	
	
	public Object t(Object obj) throws Exception
	{return perform.t(new Object[]{obj,USERAGENT});}
}
