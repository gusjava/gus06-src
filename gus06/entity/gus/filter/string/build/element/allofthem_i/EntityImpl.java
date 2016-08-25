package gus06.entity.gus.filter.string.build.element.allofthem_i;

import java.util.List;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150526";}


	private Service parseSequence;
	
	public EntityImpl() throws Exception
	{
		parseSequence = Outside.service(this,"gus.data.transform.string.sequence.parser.semicolon");
	}

	
	private List parse(String s) throws Exception
	{return (List) parseSequence.t(s);}

	
	
	public Object t(Object obj) throws Exception
	{
		List l = parse(((String)obj).toLowerCase());
		return new Filter(l);
	}
	
	
	private class Filter implements F
	{
		private List elements;
		public Filter(List elements)
		{this.elements = elements;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			List l = parse(((String) obj).toLowerCase());
			for(int i=0;i<elements.size();i++)
				if(!l.contains(elements.get(i))) return false;
			return true;
		}
	}
}
