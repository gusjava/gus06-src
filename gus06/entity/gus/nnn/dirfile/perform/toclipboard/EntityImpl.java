package gus06.entity.gus.nnn.dirfile.perform.toclipboard;

import gus06.framework.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140927";}


	private Service toCLipboard;


	public EntityImpl() throws Exception
	{toCLipboard = Outside.service(this,"gus.clipboard.access.listfiles");}
	
	
	public void p(Object obj) throws Exception
	{toCLipboard.p(toList(obj));}
	
	
	
	
	private List toList(Object obj) throws Exception
	{
		if(obj instanceof List) return (List) obj;
		if(obj instanceof File[]) return toList((File[]) obj);
		if(obj instanceof File) return toList((File) obj);
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	private List toList(File[] ff)
	{
		List list = new ArrayList();
		for(File f:ff) list.add(f);
		return list;
	}
	
	private List toList(File f)
	{
		List list = new ArrayList();
		list.add(f);
		return list;
	}
}
