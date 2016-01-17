package gus06.entity.gus.jdbc.mysql.format.sql.sequence;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import gus06.framework.*;

public class EntityImpl implements Entity, T {

	public String creationDate() {return "20150624";}

	
	private Service format;
	
	public EntityImpl() throws Exception
	{format = Outside.service(this,"gus.jdbc.mysql.format.sql.value");}
	


	public Object t(Object obj) throws Exception
	{
		if(obj instanceof String) return formatSequence((String)obj);
		if(obj instanceof List) return formatSequence((List)obj);
		if(obj instanceof Set) return formatSequence((Set)obj);
		if(obj instanceof String[]) return formatSequence((String[])obj);
		
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	private String formatSequence(String seq) throws Exception
	{
		if(!seq.contains(";")) return format(seq);
		return formatSequence(seq.split(";"));
	}
	
	
	private String formatSequence(List seq) throws Exception
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<seq.size();i++)
		b.append(format((String)seq.get(i))+",");
		
		b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	
	private String formatSequence(Set seq) throws Exception
	{
		StringBuffer b = new StringBuffer();
		Iterator it = seq.iterator();
		while(it.hasNext())
		b.append(format((String)it.next())+",");
		
		b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	
	private String formatSequence(String[] seq) throws Exception
	{
		StringBuffer b = new StringBuffer();
		for(int i=0;i<seq.length;i++)
		b.append(format(seq[i])+",");
		
		b.deleteCharAt(b.length()-1);
		return b.toString();
	}
	
	
	private String format(String value) throws Exception
	{return (String) format.t(value);}
}
