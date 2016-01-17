package gus06.entity.gus.data.collection.guilist1;

import gus06.framework.*;
import javax.swing.*;
import java.util.*;
import java.awt.BorderLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class EntityImpl extends S1 implements Entity, I, P, G, ListSelectionListener {

	public String creationDate() {return "20150329";}


	private JPanel panel;
	private JList list;
	private JLabel label;
	private Collection col;



	public EntityImpl() throws Exception
	{
		list = new JList();
		list.addListSelectionListener(this);
        
		label = new JLabel(" ");
        
		panel = new JPanel(new BorderLayout());
		panel.add(new JScrollPane(list),BorderLayout.CENTER);
		panel.add(label,BorderLayout.SOUTH);
	}
	
	
	public Object i() throws Exception
	{return panel;}
	
	
	
	public void p(Object obj) throws Exception
	{
		col = (Collection) obj;
		
		if(col!=null)
		{
			Vector vec = new Vector(col);
			if(!(col instanceof List))
			Collections.sort(vec);
			list.setListData(vec);
			label.setText(" "+col.size());
		}
		else
		{
			list.setListData(new Vector());
			label.setText(" ");
		}
	}
	
	
	
	public Object g() throws Exception
	{
		if(list.isSelectionEmpty()) return null;
		return list.getSelectedValue();
	}
	
	
	
	public void valueChanged(ListSelectionEvent e)
	{selectionChanged();}
    
    
	private void selectionChanged()
	{send(this,"selectionChanged()");}
}
