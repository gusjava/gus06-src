package gus06.entity.gus.appli.allocinesearch.movie.buildsummary;

import gus06.framework.*;
import java.util.Map;
import java.util.HashMap;
import java.net.URL;
import java.util.List;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150215";}


	private Service formatDate;
	private Service formatNumber;


	public EntityImpl() throws Exception
	{
		formatDate = Outside.service(this,"gus.string.transform.format.timestamp.locale.french");
		formatNumber = Outside.service(this,"gus.string.transform.format.number.decimal2");
	}
	
	
	public Object t(Object obj) throws Exception
	{
		Map movie = (Map) obj;
		StringBuffer b = new StringBuffer();
		
		b.append("R\u00e9alis\u00e9");
		
		if(movie.containsKey("directors")) b.append(" par "+movie.get("directors"));
		if(movie.containsKey("productionYear")) b.append(" en "+movie.get("productionYear"));
		
		b.append("\n");
		
		if(movie.containsKey("actors")) b.append("Avec "+movie.get("actors")+"\n");
		if(movie.containsKey("release")) b.append("Sortie le "+formatDate.t(movie.get("release"))+"\n");
		if(movie.containsKey("userRating")) b.append("Note des internautes: "+formatNumber.t(movie.get("userRating"))+"\n");
		
		return b.toString();
	}
}
