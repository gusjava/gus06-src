package gus06.entity.gus.java.classpath.toclasspath1;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20170223";}

	
	
	public Object t(Object obj) throws Exception
	{
		String classpath = (String) obj;
		
		String[] nn = classpath.split("\\.");
		StringBuffer b = new StringBuffer(nn[0]);
		for(int i=1;i<nn.length;i++)
		{
			b.append("."+nn[i]);
			if(!isLower(nn[i])) break;
		}
		return b.toString();
	}
	
	private boolean isLower(String s)
	{return s.toLowerCase().equals(s);}
}