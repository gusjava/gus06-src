package gus06.entity.gus.feature.op.pipenext.h;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161210";}


	private Service hh;
	private Service ht;
	private Service hf;
	private Service hr;
	private Service hp;
	private Service hmap;
	private Service loop_h;
	
	public EntityImpl() throws Exception
	{
		hh = Outside.service(this,"gus.feature.wrap.hh.h");
		ht = Outside.service(this,"gus.feature.wrap.tt.t");
		hf = Outside.service(this,"gus.feature.wrap.tf.f");
		hr = Outside.service(this,"gus.feature.wrap.tr.t");
		hp = Outside.service(this,"gus.feature.wrap.tp.p");
		hmap = Outside.service(this,"gus.feature.wrap.tmap.t");
		loop_h = Outside.service(this,"gus.feature.op.loop.h");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		H h = (H) o[0];
		
		if(o[1] instanceof H) return hh.t(o);
		if(o[1] instanceof P) return hp.t(o);
		if(o[1] instanceof T) return ht.t(o);
		if(o[1] instanceof F) return hf.t(o);
		if(o[1] instanceof R) return hr.t(o);
		if(o[1] instanceof Map) return hmap.t(o);
		if(o[1] instanceof Integer) return loop_h.t(o);
		
		throw new Exception("Invalid data type: "+o[1].getClass().getName());
	}
}
