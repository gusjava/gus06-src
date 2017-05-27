package gus06.entity.gus.support.watch.evt;

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
		String id = (String) o[1];
		E execute = (E) o[2];
		
		Holder holder = new Holder(id,execute);
		support.addActionListener(holder);
	}
	
	
	private class Holder implements ActionListener
	{
		private String id;
		private E execute;
		
		public Holder(String id, E execute)
		{
			this.id = id;
			this.execute = execute;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			String s = e.getActionCommand();
			if(s.equals(id)) execute(execute);
		}
	}
	
	
	private void execute(E execute)
	{
		try{execute.e();}
		catch(Exception e)
		{Outside.err(this,"execute(E)",e);}
	}
}
