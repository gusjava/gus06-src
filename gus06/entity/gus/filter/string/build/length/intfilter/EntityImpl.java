package gus06.entity.gus.filter.string.build.length.intfilter;


import gus06.framework.*;



public class EntityImpl implements Entity, T {



	public String creationDate() {return "20150526";}

	
	private Service intF;

	
	public EntityImpl() throws Exception
	{
		intF = Outside.service(this,"gus.filter.string.build.number.integer.filter1");
	}


	public Object t(Object obj) throws Exception
	{
		F filter = (F) intF.t(obj);
		return new F_length(filter);
	}



	private class F_length implements F
	{
		private F filter;
		public F_length(F filter)
		{this.filter = filter;}

		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			int length = (obj.toString()).length();
			return filter.f(""+length);
		}
	}
}
