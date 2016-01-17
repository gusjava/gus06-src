package gus06.entity.gus.app.entity.label;

import gus06.framework.*;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20140829";}


	private Service paintLabel;
	private JLabel label;
	private String name;
	
	public EntityImpl() throws Exception
	{
		paintLabel = Outside.service(this,"gus.swing.label.cust2.display");
		
		label = new JLabel(" ");
		label.setBorder(BorderFactory.createRaisedBevelBorder());
	}
	
	
	public Object i() throws Exception
	{return label;}
	
	
	public void p(Object obj) throws Exception
	{
		name = (String) obj;
		
		if(name==null) paintLabel.v(" ",label);
		else paintLabel.v("entity#"+name,label);
	}
}
