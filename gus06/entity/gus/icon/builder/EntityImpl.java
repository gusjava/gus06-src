package gus06.entity.gus.icon.builder;

import gus06.framework.*;
import javax.swing.Icon;


public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20140913";}

	private Service iconInside;
	private Service iconsToIcon;
	

	public EntityImpl() throws Exception
	{
		iconInside = Outside.service(this,"gus.app.inside.icon");
		iconsToIcon = Outside.service(this,"gus.convert.iconstoicon");
	}
	
	
	public Object t(Object obj) throws Exception
	{return r((String) obj);}
	
	
	
	
	public Object r(String key) throws Exception
	{
		if(!key.contains("_")) return load(key);
		
		String[] n = key.split("_");
		String id0 = n[n.length-1];
		String id1 = key.substring(0,key.length()-id0.length()-1);
		
		Icon icon0 = load("PART_"+id0);
		if(icon0==null) return load(key);
		
		Icon icon1 = load(id1);
		if(icon1==null) return load(key);
		
		return iconsToIcon.t(new Icon[]{icon1,icon0});
	}
	
	
	private Icon load(String key) throws Exception
	{return (Icon) iconInside.t(key);}
}
