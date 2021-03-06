package gus06.entity.gus.app.info.author.email.label;

import gus06.framework.*;
import javax.swing.JLabel;
import java.util.Map;

public class EntityImpl implements Entity, I {

	public String creationDate() {return "20140918";}

	public static final String PROPKEY = "app.author.email";


	private Service custWeb;
	private Map prop;

	
	public EntityImpl() throws Exception
	{
		custWeb = Outside.service(this,"gus.swing.label.cust.link.mail");
		prop = (Map) Outside.resource(this,"prop");
	}
	
	
	public Object i() throws Exception
	{
		if(!has(PROPKEY)) return null;
		JLabel label = new JLabel(get(PROPKEY));
		custWeb.p(label);
		return label;
	}
	
	
	
	private boolean has(String key)
	{return prop.containsKey(key);}
	
	private String get(String key)
	{return (String) prop.get(key);}
}
