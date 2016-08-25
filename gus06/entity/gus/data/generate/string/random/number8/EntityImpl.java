package gus06.entity.gus.data.generate.string.random.number8;

import gus06.framework.*;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20160726";}


	public static final int LENGTH = 8;



	public Object t(Object obj) throws Exception
	{
		int length = Integer.parseInt((String)obj);
		return randomNumber(length);
	}
	
	
	public Object g() throws Exception
	{return randomNumber(LENGTH);}
	
	
	
	private String randomNumber(int length)
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<length;i++) b.append(""+randomInt());
		return b.toString();
	}
	
	private int randomInt()
	{return (int) (Math.random()*10);}
}
