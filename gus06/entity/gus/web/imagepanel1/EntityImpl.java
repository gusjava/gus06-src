package gus06.entity.gus.web.imagepanel1;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class EntityImpl implements Entity, I, P, G, ActionListener {

	public String creationDate() {return "20150214";}


	private Service shiftPanel;
	private Service screen;
	
	private Service buildWaitPanel;
	private Service urlToImage;
	private Service async;
	
	
	private Object data;
	private Object holder;
	private JPanel waitPanel;
	
	
	
	public EntityImpl() throws Exception
	{
		shiftPanel = Outside.service(this,"*gus.swing.panel.shiftpanel");
		screen = Outside.service(this,"*gus.swing.panel.screen.image");
		
		buildWaitPanel = Outside.service(this,"gus.swing.panel.build.waitpanel1");
		urlToImage = Outside.service(this,"gus.convert.urltoimage");
		async = Outside.service(this,"gus.sys.async.t");
		
		waitPanel = (JPanel) buildWaitPanel.i();
	}
	
	
	
	
	public Object g() throws Exception
	{return data;}
	
	
	
	public Object i() throws Exception
	{return shiftPanel.i();}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		if(holder!=null) ((S)holder).removeActionListener(this);
		holder = null;
		
		if(obj==null)
		{
			data = null;
			shiftPanel.p(null);
			return;
		}
		if(obj instanceof URL)
		{
			data = obj;
			holder = async.t(new Object[]{urlToImage,obj});
			((S)holder).addActionListener(this);
			shiftPanel.p(waitPanel);
			return;
		}
		if(obj instanceof BufferedImage)
		{
			data = obj;
			screen.p(obj);
			shiftPanel.p(screen);
			return;
		}
		if(obj instanceof ImageIcon)
		{
			data = obj;
			screen.p(obj);
			shiftPanel.p(screen);
			return;
		}
		throw new Exception("Invalid data type: "+obj.getClass().getName());
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{updateGui();}
	
	
	
	
	private void updateGui()
	{
		try
		{
			Object image = ((G)holder).g();
			screen.p(image);
			shiftPanel.p(screen);
		}
		catch(Exception e)
		{Outside.err(this,"updateGui()",e);}
	}
}
