package gus06.entity.gus.icon.loader;

import gus06.framework.*;
import javax.swing.Icon;


public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20160914";}

	private Service iconInside;
	private Service loaderOutside;
	

	public EntityImpl() throws Exception
	{
		iconInside = Outside.service(this,"gus.app.inside.icon");
		loaderOutside = Outside.service(this,"gus.icon.loader.outside");
	}
	
	
	public Object t(Object obj) throws Exception
	{return r((String) obj);}
	
	
	
	
	public Object r(String key) throws Exception
	{
		Icon icon1 = (Icon) loaderOutside.t(key);
		if(icon1!=null) return icon1;
		return (Icon) iconInside.t(key);
	}
	
}
