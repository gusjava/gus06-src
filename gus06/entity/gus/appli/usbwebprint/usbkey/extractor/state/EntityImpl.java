package gus06.entity.gus.appli.usbwebprint.usbkey.extractor.state;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl extends S1 implements Entity, ActionListener, G, P {

	public String creationDate() {return "20140915";}


	private Service holder;


	public EntityImpl() throws Exception
	{
		holder = Outside.service(this,"*gus.data.holder");
		holder.addActionListener(this);
	}
	
	
	public Object g() throws Exception
	{return holder.g();}
	
	
	public void p(Object obj) throws Exception
	{holder.p(obj);}


	public void actionPerformed(ActionEvent e)
	{stateChanged();}
	
	
	private void stateChanged()
	{send(this,"stateChanged()");}
}
