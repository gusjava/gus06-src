package gus06.entity.gus.web.allocine.api.search;

import gus06.framework.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20141010";}
	
	public static final int MAX = 50;


	private Service cache;
	private Service perform;
	private Service jsonParser;
	

	public EntityImpl() throws Exception
	{
		cache = Outside.service(this,"gus.web.allocine.api.search.cache");
		perform = Outside.service(this,"gus.web.allocine.api.search.perform");
		jsonParser = Outside.service(this,"gus.file.convert.json.parser");
	}
	


	public Object t(Object obj) throws Exception
	{
		String search = (String) obj;
		if(search.equals("")) return new ArrayList();
		
		String json = findJson(search);
		
		Map data = (Map) jsonParser.t(json);
		if(data==null) return new ArrayList();
		
		Map feed = (Map) data.get("feed");
		if(feed==null) return new ArrayList();
		
		List movie = (List) feed.get("movie");
		if(movie==null) return new ArrayList();
		
		
		int total = int_(feed.get("totalResults"));
		if(total == movie.size()) return movie;
		
		
		int page = 1;
		int left = total - movie.size();
		
		while(left>0 && movie.size()<MAX)
		{
			page++;
			String json1 = findJson(search+"|"+page);
			Map data1 = (Map) jsonParser.t(json1);
			
			Map feed1 = (Map) data1.get("feed");
			List movie1 = (List) feed1.get("movie");
			
			while(left < movie1.size()) movie1.remove(0);
			
			movie.addAll(movie1);
			left -= movie1.size();
		}
		
		return movie;
	}
	
	
	
	
	
	
	private String findJson(String search) throws Exception
	{
		String cachedJson = (String) cache.r(search);
		if(cachedJson!=null) return cachedJson;
		
		String json = (String) perform.t(search);
		if(json!=null) cache.v(search,json);
		return json;
	}
	
	
	private int int_(Object obj)
	{return Integer.parseInt((String) obj);}
}
