package gus06.entity.gus.data.generate.string.random.alphanum8;

import gus06.framework.*;

public class EntityImpl implements Entity, G, T {

	public String creationDate() {return "20141016";}


	public static final int LENGTH = 8;



	public Object t(Object obj) throws Exception
	{
		int length = Integer.parseInt((String)obj);
		return randomString(length);
	}
	
	
	public Object g() throws Exception
	{return randomString(LENGTH);}
	
	
	
	private String randomString(int length)
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<length;i++) b.append(randomChar());
		return b.toString();
	}
	
	
	private char randomChar()
	{
		int r = random(26+26+10);
		if(r<10) return (char)(48+r);
		if(r<36) return (char)(65+r-10);
		return (char)(97+r-36);
	}
	
	
	private int random(int limit)
	{return (int) (Math.random()*limit);}
}
