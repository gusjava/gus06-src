package gus06.entity.gus.sys.script1.context.builder1.a.mapper;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160211";}


	private Service buildMapper;
	


	public EntityImpl() throws Exception
	{
		buildMapper = Outside.service(this,"factory#gus.sys.filemapper1.holder");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map context = (Map) obj;
		
		return buildMapper.g();
	}
}
