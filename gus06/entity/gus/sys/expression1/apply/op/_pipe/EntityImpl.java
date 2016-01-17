package gus06.entity.gus.sys.expression1.apply.op._pipe;

import gus06.framework.*;
import java.util.Map;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151118";}


	private Service pipe_t;
	private Service pipe_h;
	private Service pipe_map;
	private Service pipe_list;
	
	
	public EntityImpl() throws Exception
	{
		pipe_t = Outside.service(this,"gus.feature.op.pipe.t");
		pipe_h = Outside.service(this,"gus.feature.op.pipe.h");
		pipe_map = Outside.service(this,"gus.feature.op.pipe.map");
		pipe_list = Outside.service(this,"gus.feature.op.pipe.list");
	}

	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		obj = o[0];
		
		if(obj==null) return null;
		
		if(obj instanceof T[]) return pipe_t.t(obj);
		if(obj instanceof H[]) return pipe_h.t(obj);
		if(obj instanceof Map[]) return pipe_map.t(obj);
		if(obj instanceof List[]) return pipe_list.t(obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
}
