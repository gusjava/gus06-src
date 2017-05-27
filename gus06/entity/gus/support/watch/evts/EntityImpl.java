package gus06.entity.gus.support.watch.evts;

import gus06.framework.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161216";}

	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=3) throw new Exception("Wrong data number: "+o.length);
		
		S support = (S) o[0];
		E execute = (E) o[1];
		
		Holder holder = new Holder(execute);
		support.addActionListener(holder);
	}
	
	
	private class Holder implements ActionListener
	{
		private E execute;
		
		public Holder(E execute)
		{this.execute = execute;}
		
		public void actionPerformed(ActionEvent e)
		{execute(execute);}
	}
	
	
	private void execute(E execute)
	{
		try{execute.e();}
		catch(Exception e)
		{Outside.err(this,"execute(E)",e);}
	}
}
