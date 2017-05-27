package gus06.entity.gus.sys.parser3.resolver1.op.seq.sum.motley.intarray;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170106";}


	
	public Object t(Object obj) throws Exception
	{
		Object[] oo = (Object[]) obj;
		
		int[] array = (int[]) oo[0];
		int len = array.length;
		
		int[] output = new int[len];
		for(int i=0;i<len;i++) output[i] = array[i];
		
		for(int i=1;i<oo.length;i++) add(len,output,oo[i]);
		return output;
	}
	
	
	private void add(int len, int[] arr, Object o) throws Exception
	{
		if(o==null) throw new Exception("Invalid null value");
		
		if(o instanceof Integer)
		{
			int n = ((Integer) o).intValue();
			for(int i=0;i<len;i++) arr[i] += n;
			return;
		}
		
		if(o instanceof int[])
		{
			int[] nn = (int[]) o;
			if(nn.length!=len)
				throw new Exception("Invalid array lengths for sum: "+nn.length+" & "+len);
			for(int i=0;i<len;i++) arr[i] += nn[i];
			return;
		}
		
		throw new Exception("Invalid data type: "+o.getClass().getName());
	}
}
