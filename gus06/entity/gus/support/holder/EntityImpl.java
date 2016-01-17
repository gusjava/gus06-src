package gus06.entity.gus.support.holder;

import gus06.framework.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntityImpl extends S1 implements Entity, P, ActionListener {

	public String creationDate() {return "20140804";}

	private S s;
	
	
	public void p(Object obj) throws Exception
	{
		if(s!=null) s.removeActionListener(this);
		s = null;
	
		if(obj!=null && obj instanceof S)
		{s = (S) obj;s.addActionListener(this);}
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{perform();}
	
	
	private void perform()
	{send(this,"perform()");}
}
