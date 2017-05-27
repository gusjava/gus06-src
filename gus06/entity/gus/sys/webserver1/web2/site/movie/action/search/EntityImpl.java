package gus06.entity.gus.sys.webserver1.web2.site.movie.action.search;

import gus06.framework.*;
import java.sql.Connection;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20141010";}


	private Service apiSearch;


	public EntityImpl() throws Exception
	{
		apiSearch = Outside.service(this,"gus.web.allocine.api.search");
	}
	
	
	public void p(Object obj) throws Exception
	{
		R mr = (R) obj;
		V mv = (V) obj;
		F mf = (F) obj;
		
		if(!mf.f("params_post query")) return;
		
		String query = (String) mr.r("params_post query");
		
		Object result = apiSearch.t(query);
		mv.v("data d result",result);
	}
}
