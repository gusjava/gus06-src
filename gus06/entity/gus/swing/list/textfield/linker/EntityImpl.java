package gus06.entity.gus.swing.list.textfield.linker;

import gus06.framework.*;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;


public class EntityImpl implements Entity, P {

	public String creationDate() {return "20140819";}
	
	
	
	public void p(Object obj) throws Exception
	{
		Object[] o = (Object[]) obj;
		if(o.length!=2) throw new Exception("Wrong data number: "+o.length);
		
		JList list = (JList) o[0];
		JTextField field = (JTextField) o[1];
		
		new Holder(list,field);
	}
	
	
	private class Holder extends KeyAdapter
	{
		private JList list;
		private JTextField field;
		
		public Holder(JList list, JTextField field)
		{
			this.list = list;
			this.field = field;
			
			list.addKeyListener(this);
			field.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0),new AbstractAction() {
				public void actionPerformed(ActionEvent e) {focusList();}
			});
		}
		
		
		public void keyPressed(KeyEvent e)
		{
			int code = e.getKeyCode();
			
			if(code==KeyEvent.VK_UP && list.getSelectedIndex()==0) focusField();
			else if(code==KeyEvent.VK_ESCAPE) focusField();
		}
		
		
		private void focusList()
		{
			list.requestFocusInWindow();
			if(list.getModel().getSize()>0)
			list.getSelectionModel().setSelectionInterval(0,0);
		}


		private void focusField()
		{field.requestFocusInWindow();}
	}
}
