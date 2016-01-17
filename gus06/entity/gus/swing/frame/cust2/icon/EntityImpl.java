package gus06.entity.gus.swing.frame.cust2.icon;

import gus06.framework.*;
import java.awt.Image;
import javax.swing.JFrame;

public class EntityImpl implements Entity, V {

	public String creationDate() {return "20140803";}


	private Service imageProvider;

	public EntityImpl() throws Exception
	{imageProvider = Outside.service(this,"gus.icon.provider.image");}
	
	
	public void v(String key, Object obj) throws Exception
	{perform(key,(JFrame) obj);}
	
	
	private void perform(String info, JFrame frame) throws Exception
	{frame.setIconImage(image(info));}
	
	
	private Image image(String id) throws Exception
	{return (Image) imageProvider.t(id);}
}
