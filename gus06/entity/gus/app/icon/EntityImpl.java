package gus06.entity.gus.app.icon;

import gus06.framework.*;
import java.util.Map;
import javax.swing.Icon;

public class EntityImpl implements Entity, G {

	public String creationDate() {return "20150607";}

	public static final String APPICON = "app.icon";
	
	
	private Service ip;
	private Map prop;
	private Icon icon;
	
	
	
	public EntityImpl() throws Exception
	{
		ip = Outside.service(this,"gus.icon.provider");
		prop = (Map) Outside.resource(this,"prop");
	}
	
	
	public Object g() throws Exception
	{
		if(icon==null) init();
		return icon;
	}
	
	
	private void init() throws Exception
	{
		if(!has(APPICON)) return;
		
		String iconId = prop(APPICON);
		icon = (Icon) ip.r(iconId);
	}
	
	
	
	private String prop(String key)
	{return (String) prop.get(key);}
	
	private boolean has(String key)
	{return prop.containsKey(key);}
}
