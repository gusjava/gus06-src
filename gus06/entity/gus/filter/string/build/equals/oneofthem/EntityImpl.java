package gus06.entity.gus.filter.string.build.equals.oneofthem;

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
		List l = parse((String)obj);
		return new FiltereOfThem(l);
	}
	
	
	private class FiltereOfThem implements F
	{
		private List elements;
		public FiltereOfThem(List elements)
		{this.elements = elements;}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = (String) obj;
			return elements.contains(str);
		}
	}
}
