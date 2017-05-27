package gus06.entity.gus.feature.op.pipenext.g;

import gus06.framework.*;
import java.util.Map;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20161210";}


	private Service gp;
	private Service gt;
	private Service gh;
	private Service gf;
	private Service gr;
	private Service gmap;
	
	public EntityImpl() throws Exception
	{
		gp = Outside.service(this,"gus.feature.wrap.gp.e");
		gt = Outside.service(this,"gus.feature.wrap.gt.g");
		gh = Outside.service(this,"gus.feature.wrap.gh.g");
		gf = Outside.service(this,"gus.feature.wrap.gf.g");
		gr = Outside.service(this,"gus.feature.wrap.gr.g");
		gmap = Outside.service(this,"gus.feature.wrap.gmap.g");
	}


	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		G g = (G) o[0];
		
		if(o[1] instanceof P) return gp.t(o);
		if(o[1] instanceof T) return gt.t(o);
		if(o[1] instanceof F) return gf.t(o);
		if(o[1] instanceof H) return gh.t(o);
		if(o[1] instanceof R) return gr.t(o);
		if(o[1] instanceof Map) return gmap.t(o);
		
		throw new Exception("Invalid data type: "+o[1].getClass().getName());
	}
}
