package gus06.entity.gus.data.buildholder.int1;

import gus06.framework.*;

public class EntityImpl implements Entity, T, G {

	public String creationDate() {return "20161013";}


	
	public Object t(Object obj) throws Exception
	{return new Holder((Integer)obj);}

	
	
	public Object g() throws Exception
	{return new Holder(new Integer(0));}
	
	
	
	private class Holder extends S1 implements T, P, G
	{
		private Integer data;
		
		public Holder(Integer data)
		{this.data = data;}
		
		public Object g() throws Exception
		{return data;}
		
		public void p(Object obj) throws Exception
		{t(obj);}
		
		public Object t(Object obj) throws Exception
		{
			Integer data1 = (Integer) obj;
			int change = getChange(data1);
			if(change!=0)
			{
				data = data1;
				modified();
			}
			return new Integer(change);
		}
		
		private int getChange(Integer data1)
		{
			int b = data.intValue();
			int b1 = data1.intValue();
			return b1==b ? 0 : b1>b ? 1 : -1;
		}
		
		private void modified()
		{send(this,"modified()");}
	}
}
