package gus06.entity.gus.swing.dialog.blocked1.okcancel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import gus06.framework.*;
import javax.swing.BorderFactory;
import java.awt.Color;

public class EntityImpl implements Entity, F, V {

	public String creationDate() {return "20151007";}
	
	public static final int GAP = 20;

	
	private Service dialog;
	private Service dragFrame;
	
	private JPanel p_buttons;
	private JButton button_ok;
	private JButton button_cancel;
	
	private boolean ok = false;
	
	

	public EntityImpl() throws Exception
	{
		dialog = Outside.service(this,"gus.swing.dialog.blocked1");
		dragFrame = Outside.service(this,"gus.swing.comp.cust.dragframe");
		
		button_ok = new JButton("OK");
		button_ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {ok();}
		});
		button_cancel = new JButton("Cancel");
		button_cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {cancel();}
		});
		
		p_buttons = new JPanel(new GridLayout(1,2,GAP,GAP));
		p_buttons.setBorder(BorderFactory.createEmptyBorder(GAP,0,0,0));
		p_buttons.setBackground(Color.WHITE);
		p_buttons.add(button_ok);
		p_buttons.add(button_cancel);
	}
	
	
	
	
	public void v(String key, Object obj) throws Exception
	{
		if(key.equals("do") && obj.equals("ok")) {ok();return;}
		if(key.equals("do") && obj.equals("cancel")) {cancel();return;}
		
		dialog.v(key,obj);
	}

	

	public boolean f(Object obj) throws Exception
	{
		JComponent content = (JComponent) obj;
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(GAP,GAP,GAP,GAP));
		panel.setBackground(Color.WHITE);
		
		panel.add(content,BorderLayout.CENTER);
		panel.add(p_buttons,BorderLayout.SOUTH);
		
		dragFrame.p(panel);
		
		ok = false;
		dialog.p(panel);
		return ok;
	}
	
	
	
	
	
	
	private void cancel()
	{
		try
		{
			ok = false;
			dialog.p(null);
		}
		catch(Exception e)
		{Outside.err(this,"cancel()",e);}
	}
	
	
	
	private void ok()
	{
		try
		{
			ok = true;
			dialog.p(null);
		}
		catch(Exception e)
		{Outside.err(this,"ok()",e);}
	}
}
