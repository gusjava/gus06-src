package gus06.entity.gus.sys.listchooser1.gui.main;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.BorderFactory;

public class EntityImpl extends S1 implements Entity, ActionListener, I, P, G, V {

	public String creationDate() {return "20161209";}
	
	
	private Service selector;
	private Service shiftPanel;
	private Object annexe;


	public EntityImpl() throws Exception
	{
		shiftPanel = Outside.service(this,"*gus.swing.panel.shiftpanel");
		selector = Outside.service(this,"*gus.sys.listchooser1.gui.selector1");
		
		selector.addActionListener(this);
		refreshGui();
	}
	
	
	public Object i() throws Exception
	{return shiftPanel.i();}
	
	
	public Object g() throws Exception
	{return selector.g();}
	
	
	
	private void refreshGui() throws Exception
	{
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setBackground(Color.WHITE);
		
		JComponent selectorComp = (JComponent) selector.i();
		
		if(annexe!=null)
		{
			JComponent annexeComp = (JComponent) ((I) annexe).i();
			panel1.add(selectorComp,BorderLayout.WEST);
			panel1.add(annexeComp,BorderLayout.CENTER);
		}
		else
		{
			panel1.add(selectorComp,BorderLayout.CENTER);
		}
		
		shiftPanel.p(panel1);
	}
	
	
	
	public void p(Object obj) throws Exception
	{
		selector.p(obj);
		if(annexe!=null) ((P) annexe).p(null);
	}
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("annexe")) {setAnnexe(obj);return;}
		
		throw new Exception("Unknown key: "+key);
	}
	
	
	private void setAnnexe(Object annexe) throws Exception
	{
		this.annexe = annexe;
		refreshGui();
	}



	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if(s.equals("typed_enter()")) {typed_enter();return;}
		if(s.equals("typed_escape()")) {typed_escape();return;}
		if(s.equals("selectionChanged()")) {selectionChanged();return;}
	}
	
	
	
	private void selectionChanged()
	{
		try
		{
			if(annexe!=null)
			((P) annexe).p(selector.g());
		}
		catch(Exception e)
		{Outside.err(this,"selectionChanged()",e);}
	}
	
	
	private void typed_enter()
	{send(this,"typed_enter()");}
	
	private void typed_escape()
	{send(this,"typed_escape()");}
}
