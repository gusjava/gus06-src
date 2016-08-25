package gus06.entity.gus.filter.string.build.mask2_i;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20160404";}


	private Service validator;

	public EntityImpl() throws Exception
	{validator = Outside.service(this,"gus.filter.string.build.mask2.validator");}

	
	public Object t(Object obj) throws Exception
	{
		String s = ((String) obj).toLowerCase();
		return new F1(s);
	}
	
	
	private class F1 implements F
	{
		private String value;
		private int valueLength;
		
		public F1(String value)
		{
			this.value = value;
			valueLength = value.length();
		}
		
		public boolean f(Object obj) throws Exception
		{
			if(obj==null) return false;
			String str = ((String) obj).toLowerCase();
			
			if(str.length()!=valueLength) return false;
			
			for(int i=0;i<valueLength;i++)
			{
				char c1 = value.charAt(i);
				char c2 = str.charAt(i);
				if(!isValidChar(c1,c2)) return false;
			}
			return true;
		}
	}
	
	private boolean isValidChar(char c1, char c2) throws Exception
	{return validator.f(new char[]{c1,c2});}
}
