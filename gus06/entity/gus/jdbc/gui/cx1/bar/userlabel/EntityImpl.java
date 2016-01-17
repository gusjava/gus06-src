package gus06.entity.gus.jdbc.gui.cx1.bar.userlabel;

import java.sql.Connection;
import javax.swing.JLabel;
import javax.swing.JComponent;
import gus06.framework.*;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20150622";}


	private Service userDisplay;
	private Service repaint;
	
	private JLabel label;
	

	public EntityImpl() throws Exception
	{
		userDisplay = Outside.service(this,"gus.jdbc.connection.grants.display");
		repaint = Outside.service(this,"gus.swing.label.cust2.display");
		
		label = new JLabel(" ");
	}
	

	public Object i() throws Exception
	{return label;}


	
	public void p(Object obj) throws Exception
	{
		G g = (G) obj;
		Connection cx = (Connection) g.g();
		String display = (String) userDisplay.t(cx);
		repaint.v(display,label);
	}
}
