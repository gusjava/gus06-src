package gus06.entity.gus.convert.executetoaction2;

import gus06.framework.*;
import javax.swing.Action;
import javax.swing.AbstractAction;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntityImpl implements Entity, T {

	public String creationDate() {return "20140811";}

	
	public Object t(Object obj) throws Exception
	{return new Action1((E) obj);}
	
	
	private class Action1 extends AbstractAction implements Runnable
	{
		private E ex;
		private Thread t;
		
		public Action1(E ex) {this.ex = ex;}
		public void run() {execute(ex);}
		
		public void actionPerformed(ActionEvent e)
		{
			if(t!=null && t.isAlive()) return;
			t = new Thread(this,"THREAD_Action["+getValue(Action.NAME)+"]");
			t.start();
		}
	}
	
	private void execute(E ex)
	{try{ex.e();} catch(Exception e) {Outside.err(this,"execute(E)",e);}}
}
