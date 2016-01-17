package gus06.entity.gus.sys.webserver1.main;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntityImpl implements Entity, ActionListener {

	public String creationDate() {return "20140928";}


	private Service engine;
	private Service receiver;
	private Service pooler;


	public EntityImpl() throws Exception
	{
		engine = Outside.service(this,"gus.sys.webserver1.engine");
		receiver = Outside.service(this,"gus.sys.webserver1.engine.receiver");
		pooler = Outside.service(this,"gus.sys.webserver1.engine.pooler");
		
		receiver.addActionListener(this);
		engine.e();
	}


	public void actionPerformed(ActionEvent e)
	{perform();}
	
	
	
	private void perform()
	{
		try
		{
			Object input = receiver.g();
			pooler.p(input);
		}
		catch(Exception e)
		{Outside.err(this,"perform()",e);}
	}
}
