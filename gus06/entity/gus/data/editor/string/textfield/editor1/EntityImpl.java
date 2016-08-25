package gus06.entity.gus.data.editor.string.textfield.editor1;

import gus06.framework.*;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EntityImpl extends S1 implements Entity, I, G, P, ActionListener {

	public String creationDate() {return "20140724";}


	private Service textChanged;
	private Service actionClear;

	private JTextField field;

	public EntityImpl() throws Exception
	{
		textChanged = Outside.service(this,"gus.swing.textcomp.textchanged.delayed");
		actionClear = Outside.service(this,"gus.swing.textcomp.cust.action.escap.clear");

		field = new JTextField();
		field.setMargin(new Insets(3,3,3,3));

		actionClear.p(field);

		S sup = (S) textChanged.t(field);
		sup.addActionListener(this);
	}
	
	
	public Object g() throws Exception
	{return field.getText();}
	
	
	public Object i() throws Exception
	{return field;}
	
	
	public void p(Object obj) throws Exception
	{field.setText(obj==null?"":(String) obj);}



	public void actionPerformed(ActionEvent e)
	{changed();}


	private void changed()
	{send(this,"changed()");}
}
