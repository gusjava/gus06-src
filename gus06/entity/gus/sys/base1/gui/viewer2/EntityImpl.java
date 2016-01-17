package gus06.entity.gus.sys.base1.gui.viewer2;

import gus06.framework.*;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.util.Set;
import javax.swing.JScrollPane;

public class EntityImpl implements Entity, I, P {

	public String creationDate() {return "20150329";}


	private Service listView1;
	private Service listView2;
	private Service listView3;
	
	private Service compute1;
	private Service compute2;
	private Service compute3;


	private Object base;
	
	private JPanel panel;
	private JButton button;
	
	


	public EntityImpl() throws Exception
	{
		listView1 = Outside.service(this,"*gus.data.collection.guilist1-1");
		listView2 = Outside.service(this,"*gus.data.collection.guilist1-2");
		listView3 = Outside.service(this,"*gus.data.collection.guilist1-3");
		
		compute1 = Outside.service(this,"gus.sys.base1.compute.allfields");
		compute2 = Outside.service(this,"gus.sys.base1.compute.allvalues.forfield");
		compute3 = Outside.service(this,"gus.sys.base1.compute.allids.forfieldvalue");
		
		button = new JButton("refresh");
		
		JPanel panel1 = cn((JComponent) listView1.i(),label("Fields"));
		JPanel panel2 = cn((JComponent) listView2.i(),label("Values"));
		JPanel panel3 = cn((JComponent) listView3.i(),label("IDs"));
		
		JPanel panelC = new JPanel(new GridLayout(1,3));
		panelC.add(panel1);
		panelC.add(panel2);
		panelC.add(panel3);
		
		panel = new JPanel(new BorderLayout());
		panel.add(panelC,BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
		
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{refresh();}
		});
		listView1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{selected1();}
		});
		listView2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{selected2();}
		});
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	private JLabel label(String title)
	{
		JLabel l = new JLabel(title);
		l.setHorizontalAlignment(JLabel.CENTER);
		l.setBorder(BorderFactory.createRaisedBevelBorder());
		return l;
	}
	
	
	private JPanel cn(JComponent c, JComponent n)
	{
		JPanel p = new JPanel(new BorderLayout());
		p.add(n,BorderLayout.NORTH);
		p.add(new JScrollPane(c),BorderLayout.CENTER);
		return p;
	}
	
	
	
	
	public void p(Object obj) throws Exception
	{
		base = obj;
		
		listView1.p(null);
		listView2.p(null);
		listView3.p(null);
	}

	
	
	
	private void refresh()
	{
		try
		{
			if(base==null) return;
			
			Set set = (Set) compute1.t(base);
			
			listView1.p(set);
			listView2.p(null);
			listView3.p(null);
		}
		catch(Exception e)
		{Outside.err(this,"refresh()",e);}
	}
	
	
	
	
	private void selected1()
	{
		try
		{
			if(base==null) return;
			
			String field = (String) listView1.g();
			
			Set set = field==null?null:(Set) compute2.t(new Object[]{base,field});
			
			listView2.p(set);
			listView3.p(null);
		}
		catch(Exception e)
		{Outside.err(this,"selected1()",e);}
	}
	
	
	private void selected2()
	{
		try
		{
			if(base==null) return;
			
			String field = (String) listView1.g();
			String value = (String) listView2.g();
			
			Set set = field==null || value==null?null:(Set) compute3.t(new Object[]{base,field,value});
			
			listView3.p(set);
		}
		catch(Exception e)
		{Outside.err(this,"selected2()",e);}
	}
}
