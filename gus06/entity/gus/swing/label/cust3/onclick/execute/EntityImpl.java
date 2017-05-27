package gus06.entity.gus.swing.label.cust3.onclick.execute;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import gus06.framework.*;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20161005";}


	public void p(Object obj) throws Exception
	{
		Object[] t = (Object[]) obj;
		if(t.length!=2) throw new Exception("Wong data number: "+t.length);
		
		JLabel label = (JLabel) t[0];
		E exec = (E) t[1];
		
		new LabelHolder(label,exec);
	}
	
	
	
	private class LabelHolder extends MouseAdapter
	{
		private JLabel label;
		private E exec;
		
		public LabelHolder(JLabel label, E exec)
		{
			this.label = label;
			this.exec = exec;
			
			label.setFocusable(true);
			label.addMouseListener(this);
		}
		public void mousePressed(MouseEvent e)
		{exec(exec);}
	}
	
	
	
	private void exec(E exec)
	{
		try{exec.e();}
		catch(Exception e)
		{Outside.err(this,"exec(E)",e);}
	}
}
