package gus06.entity.gus.sys.parser3.resolver1.op.seq.pipe;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151029";}

	private Service pipe_t;
	private Service pipe_h;
	private Service pipe_map;
	private Service pipe_list;
	
	private Service loop_t;
	private Service loop_h;
	
	private Service toArray_t;
	private Service toArray_h;
	private Service toArray_map;
	private Service toArray_list;


	public EntityImpl() throws Exception
	{
		pipe_t = Outside.service(this,"gus.feature.op.pipe.t");
		pipe_h = Outside.service(this,"gus.feature.op.pipe.h");
		pipe_map = Outside.service(this,"gus.feature.op.pipe.map");
		pipe_list = Outside.service(this,"gus.feature.op.pipe.list");
		
		loop_t = Outside.service(this,"gus.feature.op.loop.t");
		loop_h = Outside.service(this,"gus.feature.op.loop.h");
		
		toArray_t = Outside.service(this,"gus.convert.objarraytotarray.strict");
		toArray_h = Outside.service(this,"gus.convert.objarraytoharray.strict");
		toArray_map = Outside.service(this,"gus.convert.objarraytomaparray.strict");
		toArray_list = Outside.service(this,"gus.convert.objarraytolistarray.strict");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		List cut = (List) o[0];
		T t = (T) o[1];
		
		Object[] oo = new Object[cut.size()];
		for(int i=0;i<cut.size();i++) oo[i] = t.t(cut.get(i));
		
		
		if(oo.length==2 && oo[1] instanceof Integer)
		{
			if(oo[0] instanceof T) return loop_t.t(oo);
			if(oo[0] instanceof H) return loop_h.t(oo);
			
			throw new Exception("Invalid pipe chain");
		}
		
		T[] tt = (T[]) toArray_t.t(oo);
		if(tt!=null) return pipe_t.t(tt);
		
		H[] hh = (H[]) toArray_h.t(oo);
		if(hh!=null) return pipe_h.t(hh);
		
		Map[] maps = (Map[]) toArray_map.t(oo);
		if(maps!=null) return pipe_map.t(maps);
		
		List[] lists = (List[]) toArray_list.t(oo);
		if(lists!=null) return pipe_list.t(lists);
		
		throw new Exception("Invalid pipe chain");
	}
}
