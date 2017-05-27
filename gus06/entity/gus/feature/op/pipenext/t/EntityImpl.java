package gus06.entity.gus.feature.op.pipenext.t;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161210";}


	private Service th;
	private Service tt;
	private Service tf;
	private Service tr;
	private Service tp;
	private Service tmap;
	private Service loop_t;
	
	public EntityImpl() throws Exception
	{
		th = Outside.service(this,"gus.feature.wrap.th.t");
		tt = Outside.service(this,"gus.feature.wrap.tt.t");
		tf = Outside.service(this,"gus.feature.wrap.tf.f");
		tr = Outside.service(this,"gus.feature.wrap.tr.t");
		tp = Outside.service(this,"gus.feature.wrap.tp.p");
		tmap = Outside.service(this,"gus.feature.wrap.tmap.t");
		loop_t = Outside.service(this,"gus.feature.op.loop.t");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		T t = (T) o[0];
		
		if(o[1] instanceof P) return tp.t(o);
		if(o[1] instanceof T) return tt.t(o);
		if(o[1] instanceof F) return tf.t(o);
		if(o[1] instanceof H) return th.t(o);
		if(o[1] instanceof R) return tr.t(o);
		if(o[1] instanceof Map) return tmap.t(o);
		if(o[1] instanceof Integer) return loop_t.t(o);
		
		throw new Exception("Invalid data type: "+o[1].getClass().getName());
	}
}
