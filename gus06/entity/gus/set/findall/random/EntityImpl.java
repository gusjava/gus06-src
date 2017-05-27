package gus06.entity.gus.set.findall.random;

import gus06.framework.*;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170506";}


	private Service ruleToIndex;
	
	public EntityImpl() throws Exception
	{
		ruleToIndex = Outside.service(this,"gus.list.ruletoindex");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		Set input = (Set) o[0];
		int nb = ((Integer) ruleToIndex.t(obj)).intValue();
		
		int size = input.size();
		List input1 = new ArrayList(input);
		Set output = new HashSet();
		
		while(output.size()<nb)
		{
			Integer n = new Integer(random(size));
			Object element = input1.get(n.intValue());
			output.add(element);
		}
		return output;
	}
	
	
	
	private int random(int limit)
	{return (int) (Math.random()*limit);}
}
