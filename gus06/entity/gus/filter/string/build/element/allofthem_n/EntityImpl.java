package gus06.entity.gus.filter.string.build.element.allofthem_n;

import java.util.List;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}


	private Service charNormalize;
	private Service parseSequence;
	
	public EntityImpl() throws Exception
	{
		charNormalize = Outside.service(this,"gus.string.transform.normalize.diacritics.lower");
		parseSequence = Outside.service(this,"gus.data.transform.string.sequence.parser.semicolon");
	}


	private String normalize(String s) throws Exception
	{return (String) charNormalize.t(s);}
	
	private List parse(String s) throws Exception
	{return (List) parseSequence.t(s);}
	
	
	
	public Object t(Object obj) throws Exception
	{
		List l = parse(normalize((String)obj));
		return new F_allOfThem(l);
	}
	
	
	private class F_allOfThem implements F
	{
		private List elements;
		public F_allOfThem(List elements)
		{this.elements = elements;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			List l = parse(normalize(obj.toString()));
			for(int i=0;i<elements.size();i++)
				if(!l.contains(elements.get(i))) return false;
			return true;
		}
	}
}
