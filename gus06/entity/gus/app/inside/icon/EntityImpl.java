package gus06.entity.gus.app.inside.icon;

import java.net.URL;

import javax.swing.ImageIcon;

import gus06.framework.*;

public class EntityImpl implements Entity, T, R {

	public String creationDate() {return "20140719";}


	private Service inside;
	
	public EntityImpl() throws Exception
	{inside = Outside.service(this,"inside");}
	
	
	public Object t(Object obj) throws Exception
	{
		String iconId = (String) obj;
		String path = "icon/"+iconId+".gif";
		
		URL url = (URL) inside.t("url."+path);
		if(url==null) return null;
		
		return new ImageIcon(url);
	}
	
	public Object r(String key) throws Exception
	{return t(key);}
}
