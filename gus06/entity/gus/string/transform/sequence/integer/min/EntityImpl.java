package gus06.entity.gus.string.transform.sequence.integer.min;

import gus06.framework.*;
import java.util.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150927";}


	private Service toIntArray;
	
	
	public EntityImpl() throws Exception
	{
		toIntArray = Outside.service(this,"gus.convert.stringtointarray.seq");
	}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		int[] array = (int[]) toIntArray.t(s);
		return ""+min(array);
	}
	
	private int min(int[] array)
	{
		int min = Integer.MAX_VALUE;
		for(int n:array) if(n<min) min = n;
		return min;
	}
}
