package gus06.entity.gus.string.transform.line.rm.common.lastpart;

import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20151105";}
	
	public static final String DELIM = "\n";


	private Service findCommon;
	
	public EntityImpl() throws Exception
	{findCommon = Outside.service(this,"gus.data.compare.string.common.lastpart");}

	
	
	public Object t(Object obj) throws Exception
	{
		String s = (String) obj;
		String[] n = s.split(DELIM,-1);
		
		String common = (String) findCommon.t(n);
		if(common.equals("")) return s;
		int length = common.length();
		
		StringBuffer b = new StringBuffer();
		for(int i=0;i<n.length;i++)
		{
			String line = n[i].substring(0,n[i].length()-length);
			b.append(line+DELIM);
		}
		
		if(b.length()>0) b.deleteCharAt(b.length()-1);
		return b.toString();
	}
}
