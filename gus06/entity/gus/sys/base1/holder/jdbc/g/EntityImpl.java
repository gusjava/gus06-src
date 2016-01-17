package gus06.entity.gus.sys.base1.holder.jdbc.g;

import gus06.framework.*;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150808";}


	private Service infos;
	private Service sourceBuilder;
	
	private G source;

	
	public EntityImpl() throws Exception
	{
		sourceBuilder = Outside.service(this,"gus.sys.base1.source.jdbc.builder");
		infos = Outside.service(this,"gus.sys.base1.holder.jdbc.g.infos");
		
		source = (G) sourceBuilder.t(infos);
	}
	
	public Object g() throws Exception
	{return source.g();}
}
