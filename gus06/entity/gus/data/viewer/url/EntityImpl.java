package gus06.entity.gus.data.viewer.url;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.net.URL;

public class EntityImpl implements Entity, I, P, G {

	public String creationDate() {return "20140731";}


	private Service shiftPanel;
	private Service webPanel;
	private Service imagePanel;
	private Service isImage;
	
	private Object data;
	

	public EntityImpl() throws Exception
	{
		shiftPanel = Outside.service(this,"*gus.swing.panel.shiftpanel");
		imagePanel = Outside.service(this,"*gus.web.imagepanel1");
		webPanel = Outside.service(this,"*gus.web.webpanel1");
		isImage = Outside.service(this,"gus.url.isimage");
	}
	
	
	public Object g() throws Exception
	{return data;}
	
	
	public Object i() throws Exception
	{return shiftPanel.i();}
	
	
	public void p(Object obj) throws Exception
	{
		data = (URL) obj;
		if(data==null) resetGui();
		else updateGui();
	}
	
	
	private void resetGui() throws Exception
	{
		webPanel.p(null);
		imagePanel.p(null);
	}
	
	
	
	private void updateGui() throws Exception
	{
		if(isImage.f(data))
		{
			imagePanel.p(data);
			shiftPanel.p(imagePanel);
		}
		else
		{
			webPanel.p(data);
			shiftPanel.p(webPanel);
		}
	}
}
