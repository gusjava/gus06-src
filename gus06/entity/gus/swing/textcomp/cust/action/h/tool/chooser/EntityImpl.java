package gus06.entity.gus.swing.textcomp.cust.action.h.tool.chooser;

import gus06.framework.*;
import java.util.List;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20141105";}

	public static final String ENTITYSTART = "gus.string.transform.";
	public static final String MESSAGE = "Please, choose transform:";
	public static final String TITLE = "Transform chooser";
	
	
	private Service dialog;
	private Service entityListing;
	private Service entityunique;
	private Service persister;
	
	private List list;
	private String[] values;
	private int nb;
	
	private String result;



	public EntityImpl() throws Exception
	{
		dialog = Outside.service(this,"gus.input.choose.dialog");
		entityListing = Outside.service(this,"gus.app.jarfile.listing.entities.filter.st");
		entityunique = Outside.service(this,"entityunique");
		persister = Outside.service(this,"gus.app.persister1");
		
		list = (List) entityListing.t(ENTITYSTART);
		nb = list.size();
		
		values = new String[nb];
		for(int i=0;i<nb;i++)
		values[i] = formatName(name(i));
		
		result = getPersist();
	}
	
	
	
	private String name(int i)
	{return (String) list.get(i);}
	
	private String formatName(String name)
	{return name.substring(ENTITYSTART.length()).replace(".","_");}
	
	
	
	public Object g() throws Exception
	{
		if(nb==0) return null;
		
		String selected = result!=null?result:values[0];
		String r = (String) dialog.t(new Object[]{MESSAGE,TITLE,values,selected});
		if(r==null) return null;
		
		Object entity = getEntity(r);
		if(entity==null) return null;
		
		result = r;
		setPersist(r);
		
		return entity;
	}
	
	
	
	
	private Object getEntity(String s) throws Exception
	{
		for(int i=0;i<values.length;i++)
		if(s.equals(values[i])) return entityunique.t(name(i));
		return null;
	}
	
	
	
	
	
	private void setPersist(String s) throws Exception
	{persister.v(getClass().getName(),s);}
	
	private String getPersist() throws Exception
	{return (String) persister.r(getClass().getName());}
}