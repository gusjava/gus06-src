package gus06.entity.gus.feature.op.pipenext.f;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161210";}


	private Service fh;
	private Service ft;
	private Service fr;
	private Service fp;
	private Service fe;
	private Service fg;
	private Service fmap;
	
	private Service fhh;
	private Service ftt;
	private Service frr;
	private Service fpp;
	private Service fee;
	private Service fgg;
	private Service fmapmap;
	
	
	public EntityImpl() throws Exception
	{
		fh = Outside.service(this,"gus.feature.wrap.fh.h");
		ft = Outside.service(this,"gus.feature.wrap.ft.t");
		fr = Outside.service(this,"gus.feature.wrap.fr.r");
		fp = Outside.service(this,"gus.feature.wrap.fp.p");
		fe = Outside.service(this,"gus.feature.wrap.fe.p");
		fg = Outside.service(this,"gus.feature.wrap.fg.t");
		fmap = Outside.service(this,"gus.feature.wrap.fmap.t");
		
		fhh = Outside.service(this,"gus.feature.wrap.fhh.h");
		ftt = Outside.service(this,"gus.feature.wrap.ftt.t");
		frr = Outside.service(this,"gus.feature.wrap.frr.r");
		fpp = Outside.service(this,"gus.feature.wrap.fpp.p");
		fee = Outside.service(this,"gus.feature.wrap.fee.p");
		fgg = Outside.service(this,"gus.feature.wrap.fgg.t");
		fmapmap = Outside.service(this,"gus.feature.wrap.fmapmap.t");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		F f = (F) o[0];
		
		if(o[1] instanceof E) return fe.t(o);
		if(o[1] instanceof P) return fp.t(o);
		if(o[1] instanceof G) return fg.t(o);
		if(o[1] instanceof T) return ft.t(o);
		if(o[1] instanceof H) return fh.t(o);
		if(o[1] instanceof R) return fr.t(o);
		if(o[1] instanceof Map) return fmap.t(o);
		
		if(o[1] instanceof E[]) return fee.t(tab(o));
		if(o[1] instanceof P[]) return fpp.t(tab(o));
		if(o[1] instanceof G[]) return fgg.t(tab(o));
		if(o[1] instanceof T[]) return ftt.t(tab(o));
		if(o[1] instanceof H[]) return fhh.t(tab(o));
		if(o[1] instanceof R[]) return frr.t(tab(o));
		if(o[1] instanceof Map[]) return fmapmap.t(o);
		
		throw new Exception("Invalid data type: "+o[1].getClass().getName());
	}
	
	
	
	private Object[] tab(Object[] o) throws Exception
	{
		F f = (F) o[0];
		Object[] k = (Object[]) o[1];
		if(k.length!=2) throw new Exception("Wrong data number: "+k.length);
		
		return new Object[]{f,k[0],k[1]};
	}
}
